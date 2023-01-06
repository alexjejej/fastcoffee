package com.example.alejandro.fastcoffee.cliente.platillos;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.example.alejandro.fastcoffee.cliente.bebidas.Smoothies;
import com.example.alejandro.fastcoffee.cliente.mesacliente;
import com.example.alejandro.fastcoffee.utilidades.AdaptadorRv;
import com.example.alejandro.fastcoffee.utilidades.ConexionSQLiteHelper;
import com.example.alejandro.fastcoffee.utilidades.ConexionSQLiteHelper2;
import com.example.alejandro.fastcoffee.utilidades.Cuenta;
import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.utilidades.Utilidades;
import com.example.alejandro.fastcoffee.utilidades.Utilidades2;
import com.example.alejandro.fastcoffee.utilidades.entradasRv;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;

public class entradas extends AppCompatActivity {

    RecyclerView rv;
    public String titulo, precio, descripcion, mesaseleccionada;
    public Integer id;
    public int preciototal = 0, preciot = 0, cont;
    public int valor;
    private static final String TAG = mesacliente.class.getSimpleName();
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    int contalitas=0, contBBQ=0, contaderezo=0, contzanahoria=0, costo1=0,costo2=0,costo3=0,ccosto=0,cantidad1=0,cantidad2=0,cantidad3=0,cont0=0,contBufalo=0,contfuego=0,contpapas=0,nuevocosto=0;
    int nnuevacantidad=0, nuevocosto1=0, nuevacantidad1=0, nuevocosto2=0, nuevacantidad2=0, nuevocosto3=0,nuevacantidad3=0,ganancia0=0;
    int ccantidad=0, formula=0, formula1=0, formula2=0, formula3=0;
    int suma0=0;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entradas);
        SharedPreferences preferences = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        mesaseleccionada = preferences.getString("mesa","");
        valor = preferences.getInt("precioT",0);
        cont = preferences.getInt("keycont",0);
        rv=(RecyclerView) findViewById(R.id.rv);
        final LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        database = FirebaseDatabase.getInstance();

        final List<entradasRv> listaentradas;
        listaentradas = Arrays.asList(new entradasRv(R.drawable.alitasbbq, "Alitas sabor BBQ","acompañadas de aderezo y zanahorias", "75"),
                new entradasRv(R.drawable.bbq, "Alitas sabor Bufalo","acompañadas de aderezo y zanahorias", "75"),
                new entradasRv(R.drawable.fuego, "Alitas sabor fuego","Acompañadas de aderezo y zanahorias","75"),
                new entradasRv(R.drawable.gajo, "Papas gajo", "Acompañadas de aderezo", "50"));
        final AdaptadorRv adaptador = new AdaptadorRv(listaentradas);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Seleccion: "+listaentradas.get(rv.getChildAdapterPosition(v)).getTitulo(),Toast.LENGTH_SHORT).show();
                id =1;
                titulo = listaentradas.get(rv.getChildAdapterPosition(v)).getTitulo();
                precio = listaentradas.get(rv.getChildAdapterPosition(v)).getPrecio();
                descripcion = listaentradas.get(rv.getChildAdapterPosition(v)).getDescripcion();
                confirmarOrden();
            }


            private void confirmarOrden() {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(entradas.this);
                dialogo1.setTitle("Confirmar pedido");
                dialogo1.setMessage("¿Agregar '"+titulo+"' a la orden?");
                dialogo1.setCancelable(false);

                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        registrarOrden();
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Producto agregado a la orden correctamente", Toast.LENGTH_SHORT);
                        toast1.show();

                    }
                });

                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Producto no agregado", Toast.LENGTH_SHORT);

                    }
                });
                dialogo1.show();
            }


            private void registrarOrden(){

                //Variable total

                SharedPreferences preferences = getSharedPreferences("contadores", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                preciot = Integer.parseInt(precio);
                preciototal = valor + preciot;
                editor.putInt("precioT",preciototal);
                editor.apply();

                //Registro del carrito

                ConexionSQLiteHelper conn=new ConexionSQLiteHelper(entradas.this, "bd_orden",null,1);
                SQLiteDatabase db=conn.getReadableDatabase();
                ContentValues values=new ContentValues();
                values.put(Utilidades.CAMPO_ID,"1");
                values.put(Utilidades.CAMPO_TITULO,titulo);
                values.put(Utilidades.CAMPO_DESCRIPCION,descripcion);
                values.put(Utilidades.CAMPO_PRECIO,precio);
                Long idResultante = db.insert(Utilidades.TABLA_ORDEN,Utilidades.CAMPO_ID,values);
                db.close();




                // LLenar total y mostrar el carrito

                Intent intent = new Intent(entradas.this, Cuenta.class);
                intent.putExtra("Total",preciototal);
                startActivityForResult(intent, 0);


            }

        });
        rv.setAdapter(adaptador);
    }




}
