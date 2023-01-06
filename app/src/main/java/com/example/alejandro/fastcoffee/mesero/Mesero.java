package com.example.alejandro.fastcoffee.mesero;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.alejandro.fastcoffee.mesero.Mesero;
import com.example.alejandro.fastcoffee.MainActivity;
import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.mesacliente;
import com.example.alejandro.fastcoffee.utilidades.AdaptadorCocina;
import com.example.alejandro.fastcoffee.utilidades.AdaptadorMesero;
import com.example.alejandro.fastcoffee.utilidades.cocinaRv;
import com.example.alejandro.fastcoffee.utilidades.meseroRv;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Mesero extends AppCompatActivity {

    private RecyclerView recyclerView, rv;
    List<meseroRv> meserorv;
    List<cocinaRv> cocinarv;
    AdaptadorMesero adapter;
    AdaptadorCocina adapter2;
    String estado, producto, idconvert, id, key, mensaje;

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
    public void onBackPressed() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("¡ALERTA!");
        dialogo1.setMessage("No se puede salir de esta pestaña");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });

        dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesero);
        recyclerView = findViewById(R.id.rvmesero);
        rv = findViewById(R.id.rvmensajes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new LinearLayoutManager(this));
        meserorv = new ArrayList<>();
        cocinarv = new ArrayList<>();
        adapter = new AdaptadorMesero(meserorv);
        adapter2= new AdaptadorCocina(cocinarv);
        recyclerView.setAdapter(adapter);
        rv.setAdapter(adapter2);
        Button btnayuda = (Button) findViewById(R.id.btnayuda);
        btnayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mesero.this, Ayuda.class);
                startActivity(intent);
            }
        });


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estado = meserorv.get(recyclerView.getChildAdapterPosition(v)).getEstado();
                producto = meserorv.get(recyclerView.getChildAdapterPosition(v)).getProducto();
                id = meserorv.get(recyclerView.getChildAdapterPosition(v)).getId();
               // Toast.makeText(getApplicationContext(),""+id,Toast.LENGTH_SHORT).show();
                TerminarProducto();
            }
        });

        adapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MensajeRecibido();
                key = cocinarv.get(rv.getChildAdapterPosition(v)).getId();
                mensaje = cocinarv.get(rv.getChildAdapterPosition(v)).getProducto();
            }
        });

        //Llenar en el recyclerview Firebase de los productos

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Query query = database.getReference().child("productos").orderByChild("estado").equalTo("terminado");;
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                meserorv.removeAll(meserorv);
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {
                    meseroRv meseroR= snapshot.getValue(meseroRv.class);
                    meserorv.add(meseroR);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("error", databaseError.getMessage());

            }
        });

        //Mensajes

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        Query query1 = db.getReference().child("mensaje").orderByChild("id");
        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cocinarv.removeAll(cocinarv);
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {
                    cocinaRv cocina= snapshot.getValue(cocinaRv.class);
                    cocinarv.add(cocina);
                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("error", databaseError.getMessage());

            }
        });
    }

    private void MensajeRecibido() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle(""+mensaje);
        dialogo1.setMessage("¿Eliminar mensaje?");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Mensaje eliminado correctamente", Toast.LENGTH_SHORT);
                toast1.show();
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference messageReference = database.getReference().child("mensaje").child(key);
                messageReference.removeValue();

            }
        });

        dialogo1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.show();
    }



    private void TerminarProducto() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Terminar producto");
        dialogo1.setMessage("¿'"+producto+"' entregado?");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                registrarOrden();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Producto terminado correctamente", Toast.LENGTH_SHORT);
                toast1.show();

            }
        });

        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Producto en entrega", Toast.LENGTH_SHORT);

            }
        });
        dialogo1.show();
    }

    private void registrarOrden() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference messageReference = database.getReference().child("productos").child(id);
        messageReference.child("estado").setValue("finalizado");
    }



}






