package com.example.alejandro.fastcoffee.utilidades;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.Cliente;
import com.example.alejandro.fastcoffee.cliente.bebidas.cappucinos;
import com.example.alejandro.fastcoffee.cliente.bebidas.late;
import com.example.alejandro.fastcoffee.cliente.platillos.entradas;
import com.example.alejandro.fastcoffee.entidades.Ordenes;
import com.example.alejandro.fastcoffee.tiempodeespera;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Cuenta extends AppCompatActivity {

    ListView listViewOrden;
    ArrayList<String> listaInformacion;
    ArrayList<Ordenes> listaOrden;
    ConexionSQLiteHelper conn;
    ConexionSQLiteHelper2 conn2;
    TextView preciototal;
    Button btnterminarorden, seguircomprando;
    int valortotal, cont, contpedidos, ganancia, contganancia, contventa, venta, precio, ganantotal;
    int idp;
    int gananciaproducto;
    int gananciatotal;
    String mesaseleccionada, contConvertido, titulo, preciostring;
    String titulos;
    String[] partes;
    int cantidadd4 =0, costoo4 =0, formulaa4 =0, nuevocostoo4=0, nuevacantidadd4=0;
    int a=0, contalitas=0,contcafe=0;
    int ganancia0=0, ganancia1=0, ganancia2=0, ganancia3=0, ganancia4=0, ganancia5=0, ganancia6=0, ganancia7=0, ganancia8=0, ganancia9=0, ganancia10=0, ganancia11=0, ganancia12=0;
    int ganancia13=0, ganancia14=0, ganancia15=0, ganancia16=0, ganancia17=0, ganancia18=0, ganancia19=0, ganancia20=0, ganancia21=0, ganancia22=0, ganancia23=0, ganancia24=0, ganancia25=0;

    int gananciaa0=0, gananciaa1=0, gananciaa2=0, gananciaa3=0, gananciaa4=0, gananciaa5=0, gananciaa6=0, gananciaa7=0, gananciaa8=0, gananciaa9=0, gananciaa10=0, gananciaa11=0, gananciaa12=0;
    int gananciaa13=0, gananciaa14=0, gananciaa15=0, gananciaa16=0, gananciaa17=0, gananciaa18=0, gananciaa19=0, gananciaa20=0, gananciaa21=0, gananciaa22=0, gananciaa23=0, gananciaa24=0, gananciaa25=0;

    int suma0=0,suma1=0,suma2=0,suma3=0,suma4=0,suma5=0,suma6=0,suma7=0,suma8=0,suma9=0,suma10=0,suma11=0,suma12=0,suma13=0,suma14=0,suma15=0,suma16=0,suma17=0,suma18=0,suma19=0,suma20=0,suma21=0,suma22=0;
    int cont25=0,cont24=0,cont23=0;
    int suma23=0,suma24=0,suma25=0;
    int cont0=0,cont1=0,cont2=0,cont3=0,cont4=0,cont5=0,cont6=0,cont7=0,cont8=0,cont9=0,cont10=0,cont11=0,cont12=0,cont13=0,cont14=0,cont15=0,cont16=0,cont17=0,cont18=0,cont19=0,cont20=0,cont21=0,cont22=0;
    int conta0=0,conta1=0,conta2=0,conta3=0,conta4=0,conta5=0,conta6=0,conta7=0,conta8=0,conta9=0,conta10=0,conta11=0,conta12=0;
    int ccantidad=0, ccosto=0, formula=0, nuevocosto=0, nnuevacantidad=0;
    int cantidad1=0, costo1=0, formula1=0, nuevocosto1=0, nuevacantidad1=0,contBBQ=0;
    int cantidad2=0, costo2=0, formula2=0, nuevocosto2=0, nuevacantidad2=0,contBufalo=0;
    int cantidad3=0, costo3=0, formula3=0, nuevocosto3=0, nuevacantidad3=0,contfuego=0;
    int cantidad4=0, costo4=0, formula4=0, nuevocosto4=0, nuevacantidad4=0,contpapas=0;
    int cantidad5=0, costo5=0, formula5=0, nuevocosto5=0, nuevacantidad5=0,contzanahoria=0;
    int cantidad6=0, costo6=0, formula6=0, nuevocosto6=0, nuevacantidad6=0,contaderezo=0;
    int cantidad7=0, costo7=0, formula7=0, nuevocosto7=0, nuevacantidad7=0,contazucar=0;
    int cantidad8=0, costo8=0, formula8=0, nuevocosto8=0, nuevacantidad8=0,contleche=0;
    int cantidad9=0, costo9=0, formula9=0, nuevocosto9=0, nuevacantidad9=0,contcacao=0;
    int cantidad10=0, costo10=0, formula10=0, nuevocosto10=0, nuevacantidad10=0,conthvainilla=0;
    int cantidad11=0, costo11=0, formula11=0, nuevocosto11=0, nuevacantidad11=0,contlicor=0;
    int cantidad12=0, costo12=0, formula12=0, nuevocosto12=0, nuevacantidad12=0,contcanela=0;
    int cantidad13=0, costo13=0, formula13=0, nuevocosto13=0, nuevacantidad13=0,contnata=0;
    int cantidad14=0, costo14=0, formula14=0, nuevocosto14=0, nuevacantidad14=0,contvainilla=0;
    int cantidad15=0, costo15=0, formula15=0, nuevocosto15=0, nuevacantidad15=0,contcremaf=0;
    int cantidad16=0, costo16=0, formula16=0, nuevocosto16=0, nuevacantidad16=0,contcaramelo=0;
    int cantidad17=0, costo17=0, formula17=0, nuevocosto17=0, nuevacantidad17=0,conttiramisu=0;
    int contrompope=0,contcajeta=0,contamaretto=0,contmacadamia=0,contchocolate=0,contagua=0,contchaiv=0,contchaim=0,contchocolateb=0,contsal=0,contlimon=0,contrefrescos=0;
    int contaguamin=0,contnaranja=0,contron=0, contvinot=0, contvermouth=0, contsangria=0, contmanzana=0, contcerveza=0,contclamato=0,contcremcoco=0,contjpina=0, contfresa=0;
    int contmoras=0, contmango=0, contjmanzana=0, contjmaracuya=0, contjmango=0, contmcrepas=0, contpeperoni=0, contsalami=0, contquesoman=0, contlechuga=0;
    int contjamon=0 , contpina=0 , contpanela=0 , contpollo=0 , contaceitunas=0 , conttocino=0 , contpierna=0, contatun=0, contgalletas=0, contpastel=0, contbrownie=0;
    int contlechera=0, contmermelada=0, contzarzamora=0, contquesocre=0, contnutella=0, conthchocolate=0, contnuez=0, contplatano=0, contpanh=0, contcarneh=0,contchorizo=0;
    int cantidad18=0, costo18=0, formula18=0, nuevocosto18=0, nuevacantidad18=0;
    int cantidad19=0, costo19=0, formula19=0, nuevocosto19=0, nuevacantidad19=0;
    int cantidad20=0, costo20=0, formula20=0, nuevocosto20=0, nuevacantidad20=0;
    int cantidad21=0, costo21=0, formula21=0, nuevocosto21=0, nuevacantidad21=0;
    int cantidad22=0, costo22=0, formula22=0, nuevocosto22=0, nuevacantidad22=0;
    int cantidad23=0, costo23=0, formula23=0, nuevocosto23=0, nuevacantidad23=0;
    int cantidad24=0, costo24=0, formula24=0, nuevocosto24=0, nuevacantidad24=0;
    int cantidad25=0, costo25=0, formula25=0, nuevocosto25=0, nuevacantidad25=0;
    int cantidad26=0, costo26=0, formula26=0, nuevocosto26=0, nuevacantidad26=0;
    int cantidad27=0, costo27=0, formula27=0, nuevocosto27=0, nuevacantidad27=0;
    int cantidad28=0, costo28=0, formula28=0, nuevocosto28=0, nuevacantidad28=0;
    int cantidad29=0, costo29=0, formula29=0, nuevocosto29=0, nuevacantidad29=0;
    int cantidad30=0, costo30=0, formula30=0, nuevocosto30=0, nuevacantidad30=0;
    int cantidad31=0, costo31=0, formula31=0, nuevocosto31=0, nuevacantidad31=0;
    int cantidad32=0, costo32=0, formula32=0, nuevocosto32=0, nuevacantidad32=0;
    int cantidad33=0, costo33=0, formula33=0, nuevocosto33=0, nuevacantidad33=0;
    int cantidad34=0, costo34=0, formula34=0, nuevocosto34=0, nuevacantidad34=0;
    int cantidad35=0, costo35=0, formula35=0, nuevocosto35=0, nuevacantidad35=0;
    int cantidad36=0, costo36=0, formula36=0, nuevocosto36=0, nuevacantidad36=0;
    int cantidad37=0, costo37=0, formula37=0, nuevocosto37=0, nuevacantidad37=0;
    int cantidad38=0, costo38=0, formula38=0, nuevocosto38=0, nuevacantidad38=0;
    int cantidad39=0, costo39=0, formula39=0, nuevocosto39=0, nuevacantidad39=0;
    int cantidad40=0, costo40=0, formula40=0, nuevocosto40=0, nuevacantidad40=0;
    int cantidad41=0, costo41=0, formula41=0, nuevocosto41=0, nuevacantidad41=0;
    int cantidad42=0, costo42=0, formula42=0, nuevocosto42=0, nuevacantidad42=0;
    int cantidad43=0, costo43=0, formula43=0, nuevocosto43=0, nuevacantidad43=0;
    int cantidad44=0, costo44=0, formula44=0, nuevocosto44=0, nuevacantidad44=0;
    int cantidad45=0, costo45=0, formula45=0, nuevocosto45=0, nuevacantidad45=0;
    int cantidad46=0, costo46=0, formula46=0, nuevocosto46=0, nuevacantidad46=0;
    int cantidad47=0, costo47=0, formula47=0, nuevocosto47=0, nuevacantidad47=0;
    int cantidad48=0, costo48=0, formula48=0, nuevocosto48=0, nuevacantidad48=0;
    int cantidad49=0, costo49=0, formula49=0, nuevocosto49=0, nuevacantidad49=0;
    int cantidad50=0, costo50=0, formula50=0, nuevocosto50=0, nuevacantidad50=0;
    int cantidad51=0, costo51=0, formula51=0, nuevocosto51=0, nuevacantidad51=0;
    int cantidad52=0, costo52=0, formula52=0, nuevocosto52=0, nuevacantidad52=0;
    int cantidad53=0, costo53=0, formula53=0, nuevocosto53=0, nuevacantidad53=0;
    int cantidad54=0, costo54=0, formula54=0, nuevocosto54=0, nuevacantidad54=0;
    int cantidad55=0, costo55=0, formula55=0, nuevocosto55=0, nuevacantidad55=0;
    int cantidad56=0, costo56=0, formula56=0, nuevocosto56=0, nuevacantidad56=0;
    int cantidad57=0, costo57=0, formula57=0, nuevocosto57=0, nuevacantidad57=0;
    int cantidad58=0, costo58=0, formula58=0, nuevocosto58=0, nuevacantidad58=0;
    int cantidad59=0, costo59=0, formula59=0, nuevocosto59=0, nuevacantidad59=0;
    int cantidad60=0, costo60=0, formula60=0, nuevocosto60=0, nuevacantidad60=0;
    int cantidad61=0, costo61=0, formula61=0, nuevocosto61=0, nuevacantidad61=0;
    int cantidad62=0, costo62=0, formula62=0, nuevocosto62=0, nuevacantidad62=0;
    int cantidad63=0, costo63=0, formula63=0, nuevocosto63=0, nuevacantidad63=0;
    int cantidad64=0, costo64=0, formula64=0, nuevocosto64=0, nuevacantidad64=0;
    int cantidad65=0, costo65=0, formula65=0, nuevocosto65=0, nuevacantidad65=0;
    int cantidad66=0, costo66=0, formula66=0, nuevocosto66=0, nuevacantidad66=0;
    int cantidad67=0, costo67=0, formula67=0, nuevocosto67=0, nuevacantidad67=0;
    int cantidad68=0, costo68=0, formula68=0, nuevocosto68=0, nuevacantidad68=0;
    int cantidad69=0, costo69=0, formula69=0, nuevocosto69=0, nuevacantidad69=0;
    int cantidad70=0, costo70=0, formula70=0, nuevocosto70=0, nuevacantidad70=0;
    int cantidad71=0, costo71=0, formula71=0, nuevocosto71=0, nuevacantidad71=0;
    int cantidad72=0, costo72=0, formula72=0, nuevocosto72=0, nuevacantidad72=0;
    int cantidad73=0, costo73=0, formula73=0, nuevocosto73=0, nuevacantidad73=0;
    int cantidad74=0, costo74=0, formula74=0, nuevocosto74=0, nuevacantidad74=0;







    private DatabaseReference mDatabase;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
        preciototal = (TextView) findViewById(R.id.txtTotal);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_orden", null, 1);
        conn2 = new ConexionSQLiteHelper2(getApplicationContext(), "bd_orden", null, 1);
        listViewOrden = findViewById(R.id.lvorden);

        SharedPreferences pref = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        mesaseleccionada = pref.getString("mesa", "");

        idp = pref.getInt("idp", 0);

        database = FirebaseDatabase.getInstance();

        consultarOrden();
        mostrarTotal();

        btnterminarorden = (Button) findViewById(R.id.btncocina);
        btnterminarorden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terminarorden();

            }
        });
        seguircomprando = (Button) findViewById(R.id.button3);
        seguircomprando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seguircomprando();
            }
        });


    }

    private void mostrarTotal() {

        SharedPreferences pref = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        valortotal = pref.getInt("precioT", 0);
        preciototal.setText("$" + valortotal);

    }

    private void consultarOrden() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Ordenes orden = null;
        listaOrden = new ArrayList<Ordenes>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_ORDEN, null);

        while (cursor.moveToNext()) {
            orden = new Ordenes();
            orden.setTitulo(cursor.getString(1));
            orden.setPrecio(cursor.getString(3));
            listaOrden.add(orden);

        }
        obtenerLista();
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaInformacion);
        listViewOrden.setAdapter(adaptador);
        db.close();

    }


    private void obtenerLista() {

        listaInformacion = new ArrayList<String>();
        for (int i = 0; i < listaOrden.size(); i++) {
            listaInformacion.add(listaOrden.get(i).getTitulo() + " - " + listaOrden.get(i).getPrecio());
        }
    }

    private void terminarorden() {

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Confirmar pedido");
        dialogo1.setMessage("¿Desea terminar su pedido?");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Terminar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                LlenarEnFirebase();
                Toast toast1 = Toast.makeText(getApplicationContext(), "¡Gracias por su preferencia!", Toast.LENGTH_SHORT);
                toast1.show();

            }
        });

        dialogo1.setNegativeButton("Seguir comprando", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "¡Gracias por su preferencia!", Toast.LENGTH_SHORT);
                toast1.show();
                seguircomprando();
            }
        });
        dialogo1.show();

    }

    private void LlenarEnFirebase() {

        final DatabaseReference invent = FirebaseDatabase.getInstance().getReference();
        invent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                DatabaseReference bd = FirebaseDatabase.getInstance().getReference().child("inventario");
                DatabaseReference general = FirebaseDatabase.getInstance().getReference();


                //Ciclo para recuperar los productos que estan en sqlite y llenarlo en firebase

                final SQLiteDatabase db = conn.getReadableDatabase();
                Ordenes orden = null;
                listaOrden = new ArrayList<Ordenes>();
                Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_ORDEN, null);
                while (cursor.moveToNext()) {
                    orden = new Ordenes();
                    orden.setTitulo(cursor.getString(1));
                    orden.setPrecio(cursor.getString(3));
                    listaOrden.add(orden);
                }
                listaInformacion = new ArrayList<String>();
                for (int i = 0; i < listaOrden.size(); i++) {
                    cont = 1 + cont;
                    titulo = listaOrden.get(i).getTitulo();
                    preciostring = listaOrden.get(i).getPrecio();
                    precio = Integer.parseInt(preciostring);
                    contConvertido = Integer.toString(cont);


                    //llenar en sqlite

                    ConexionSQLiteHelper conn2=new ConexionSQLiteHelper(Cuenta.this, "bd_orden2",null,1);
                    SQLiteDatabase db2=conn2.getReadableDatabase();
                    ContentValues values2=new ContentValues();
                    values2.put(Utilidades.CAMPO_ID,"1");
                    values2.put(Utilidades.CAMPO_TITULO,titulo);
                    values2.put(Utilidades.CAMPO_DESCRIPCION,"s");
                    values2.put(Utilidades.CAMPO_PRECIO,precio);
                    Long idResultante2 = db2.insert(Utilidades.TABLA_ORDEN2,Utilidades.CAMPO_ID,values2);
                    db2.close();



                    contventa = precio + contventa;

                    //entradas--------------------------------------------------------------------------------------------------------------------------------------------------





                    if (titulo.equals("Alitas sabor Bufalo")) {
                        CrearPedido();
                        //Ingrediente - Alitas de pollo
                        if (contalitas == 0) {
                            ccantidad = dataSnapshot.child("inventario").child("Alitas de pollo").child("cantidad").getValue(Integer.class);
                            ccosto = dataSnapshot.child("inventario").child("Alitas de pollo").child("costo").getValue(Integer.class);
                            formula = (500 * ccosto) / ccantidad; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto = ccosto - formula;
                            nnuevacantidad = ccantidad - 500;
                            bd.child("Alitas de pollo").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Alitas de pollo").child("costo").setValue(nuevocosto);

                        }
                        if (contalitas == 1) {
                            nnuevacantidad = nnuevacantidad - 500;
                            nuevocosto = nuevocosto - formula;
                            bd.child("Alitas de pollo").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Alitas de pollo").child("costo").setValue(nuevocosto);
                            contalitas = 2;
                        }
                        contalitas = 1;


                        //Salsa Bufalo
                        if (contBufalo == 0) {
                            cantidad1 = dataSnapshot.child("inventario").child("Salsa BBQ").child("cantidad").getValue(Integer.class);
                            costo1 = dataSnapshot.child("inventario").child("Salsa BBQ").child("costo").getValue(Integer.class);
                            formula1 = (500 * costo1) / cantidad1; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto1 = costo1 - formula1;
                            nuevacantidad1 = cantidad1 - 500;
                            bd.child("Salsa Bufalo").child("cantidad").setValue(nuevacantidad1);
                            bd.child("Salsa Bufalo").child("costo").setValue(nuevocosto1);

                        }
                        if (contBBQ == 1) {
                            nuevacantidad1 = nuevacantidad1 - 500;
                            nuevocosto1 = nuevocosto1 - formula1;
                            bd.child("Salsa Bufalo").child("cantidad").setValue(nuevacantidad1);
                            bd.child("Salsa Bufalo").child("costo").setValue(nuevocosto1);
                            contBBQ = 2;
                        }
                        contBBQ = 1;

                        //Aderezo
                        if (contaderezo == 0) {
                            cantidad2 = dataSnapshot.child("inventario").child("Aderezo").child("cantidad").getValue(Integer.class);
                            costo2 = dataSnapshot.child("inventario").child("Aderezo").child("costo").getValue(Integer.class);
                            formula2 = (500 * costo2) / cantidad2; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto2 = costo2 - formula2;
                            nuevacantidad2 = cantidad2 - 500;
                            bd.child("Aderezo").child("cantidad").setValue(nuevacantidad2);
                            bd.child("Aderezo").child("costo").setValue(nuevocosto2);

                        }
                        if (contaderezo == 1) {
                            nuevacantidad2 = nuevacantidad2 - 500;
                            nuevocosto2 = nuevocosto2 - formula2;
                            bd.child("Aderezo").child("cantidad").setValue(nuevacantidad2);
                            bd.child("Aderezo").child("costo").setValue(nuevocosto2);
                            contaderezo = 2;
                        }
                        contaderezo = 1;

                        //Zanahoria
                        if (contzanahoria == 0) {
                            cantidad3 = dataSnapshot.child("inventario").child("Zanahoria").child("cantidad").getValue(Integer.class);
                            costo3 = dataSnapshot.child("inventario").child("Zanahoria").child("costo").getValue(Integer.class);
                            formula3 = (500 * costo3) / cantidad3; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto3 = costo3 - formula3;
                            nuevacantidad3 = cantidad3 - 500;
                            bd.child("Zanahoria").child("cantidad").setValue(nuevacantidad3);
                            bd.child("Zanahoria").child("costo").setValue(nuevocosto3);

                        }
                        if (contzanahoria == 1) {
                            nuevacantidad3 = nuevacantidad3 - 500;
                            nuevocosto3 = nuevocosto3 - formula3;
                            bd.child("Zanahoria").child("cantidad").setValue(nuevacantidad3);
                            bd.child("Zanahoria").child("costo").setValue(nuevocosto3);
                            contzanahoria = 2;
                        }
                        contzanahoria = 1;

                        if (cont0==0) {
                            suma0 = formula + formula1 + formula2 + formula3;
                            ganancia0 = precio - suma0;

                        }
                        if (cont0==1) {
                            gananciaa0 = gananciaa0 + ganancia0;
                            cont0=2;
                        }
                        cont0=1;
                    }
                    ////////////////////////////////////////////////////////////
                    if (titulo.equals("Alitas sabor fuego")) {
                        //Ingrediente - Alitas de pollo
                        if (contalitas == 0) {
                            ccantidad = dataSnapshot.child("inventario").child("Alitas de pollo").child("cantidad").getValue(Integer.class);
                            ccosto = dataSnapshot.child("inventario").child("Alitas de pollo").child("costo").getValue(Integer.class);
                            formula = (500 * ccosto) / ccantidad; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto = ccosto - formula;
                            nnuevacantidad = ccantidad - 500;
                            bd.child("Alitas de pollo").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Alitas de pollo").child("costo").setValue(nuevocosto);

                        }
                        if (contalitas == 1) {
                            nnuevacantidad = nnuevacantidad - 500;
                            nuevocosto = nuevocosto - formula;
                            bd.child("Alitas de pollo").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Alitas de pollo").child("costo").setValue(nuevocosto);
                            contalitas = 2;
                        }
                        contalitas = 1;


                        //Salsa fuego
                        if (contfuego == 0) {
                            cantidad1 = dataSnapshot.child("inventario").child("Salsa BBQ").child("cantidad").getValue(Integer.class);
                            costo1 = dataSnapshot.child("inventario").child("Salsa BBQ").child("costo").getValue(Integer.class);
                            formula1 = (500 * costo1) / cantidad1; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto1 = costo1 - formula1;
                            nuevacantidad1 = cantidad1 - 500;
                            bd.child("Salsa Fuego").child("cantidad").setValue(nuevacantidad1);
                            bd.child("Salsa Fuego").child("costo").setValue(nuevocosto1);

                        }
                        if (contfuego == 1) {
                            nuevacantidad1 = nuevacantidad1 - 500;
                            nuevocosto1 = nuevocosto1 - formula1;
                            bd.child("Salsa Fuego").child("cantidad").setValue(nuevacantidad1);
                            bd.child("Salsa Fuego").child("costo").setValue(nuevocosto1);
                            contBBQ = 2;
                        }
                        contfuego = 1;

                        //Aderezo
                        if (contaderezo == 0) {
                            cantidad2 = dataSnapshot.child("inventario").child("Aderezo").child("cantidad").getValue(Integer.class);
                            costo2 = dataSnapshot.child("inventario").child("Aderezo").child("costo").getValue(Integer.class);
                            formula2 = (500 * costo2) / cantidad2; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto2 = costo2 - formula2;
                            nuevacantidad2 = cantidad2 - 500;
                            bd.child("Aderezo").child("cantidad").setValue(nuevacantidad2);
                            bd.child("Aderezo").child("costo").setValue(nuevocosto2);

                        }
                        if (contaderezo == 1) {
                            nuevacantidad2 = nuevacantidad2 - 500;
                            nuevocosto2 = nuevocosto2 - formula2;
                            bd.child("Aderezo").child("cantidad").setValue(nuevacantidad2);
                            bd.child("Aderezo").child("costo").setValue(nuevocosto2);
                            contaderezo = 2;
                        }
                        contaderezo = 1;

                        //Zanahoria
                        if (contzanahoria == 0) {
                            cantidad3 = dataSnapshot.child("inventario").child("Zanahoria").child("cantidad").getValue(Integer.class);
                            costo3 = dataSnapshot.child("inventario").child("Zanahoria").child("costo").getValue(Integer.class);
                            formula3 = (500 * costo3) / cantidad3; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto3 = costo3 - formula3;
                            nuevacantidad3 = cantidad3 - 500;
                            bd.child("Zanahoria").child("cantidad").setValue(nuevacantidad3);
                            bd.child("Zanahoria").child("costo").setValue(nuevocosto3);

                        }
                        if (contzanahoria == 1) {
                            nuevacantidad3 = nuevacantidad3 - 500;
                            nuevocosto3 = nuevocosto3 - formula3;
                            bd.child("Zanahoria").child("cantidad").setValue(nuevacantidad3);
                            bd.child("Zanahoria").child("costo").setValue(nuevocosto3);
                            contzanahoria = 2;
                        }
                        contzanahoria = 1;

                        if (cont1==0) {
                            suma1 = formula + formula1 + formula2 + formula3;
                            gananciaa1 = precio - suma0;

                        }
                        if (cont1==1) {
                            gananciaa1 = gananciaa1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    /////////////////////////////////////////////////////////////////
                    if (titulo.equals("Papas gajo")) {
                        //Ingrediente - papas gajo
                        if (contpapas == 0) {
                            cantidadd4 = dataSnapshot.child("inventario").child("Papas").child("cantidad").getValue(Integer.class);
                            costoo4 = dataSnapshot.child("inventario").child("Papas").child("costo").getValue(Integer.class);
                            formulaa4 = (500 * costoo4) / cantidadd4; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocostoo4 = costoo4 - formulaa4;
                            nuevacantidadd4 = cantidadd4 - 500;
                            bd.child("Papas").child("cantidad").setValue(nuevacantidadd4);
                            bd.child("Papas").child("costo").setValue(nuevocostoo4);

                        }
                        if (contpapas == 1) {
                            nuevacantidadd4 = nuevacantidadd4 - 500;
                            nuevocostoo4 = nuevocostoo4 - formulaa4;
                            bd.child("Papas").child("cantidad").setValue(nuevacantidadd4);
                            bd.child("Papas").child("costo").setValue(nuevocostoo4);
                            contpapas = 2;
                        }
                        contpapas = 1;

                        //Aderezo
                        if (contaderezo == 0) {
                            cantidad2 = dataSnapshot.child("inventario").child("Aderezo").child("cantidad").getValue(Integer.class);
                            costo2 = dataSnapshot.child("inventario").child("Aderezo").child("costo").getValue(Integer.class);
                            formula2 = (500 * costo2) / cantidad2; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto2 = costo2 - formula2;
                            nuevacantidad2 = cantidad2 - 500;
                            bd.child("Aderezo").child("cantidad").setValue(nuevacantidad2);
                            bd.child("Aderezo").child("costo").setValue(nuevocosto2);

                        }
                        if (contaderezo == 1) {
                            nuevacantidad2 = nuevacantidad2 - 500;
                            nuevocosto2 = nuevocosto2 - formula2;
                            bd.child("Aderezo").child("cantidad").setValue(nuevacantidad2);
                            bd.child("Aderezo").child("costo").setValue(nuevocosto2);
                            contaderezo = 2;
                        }
                        contaderezo = 1;



                        if (cont2==0) {
                            suma2 = formula2 + formulaa4;
                            ganancia2 = precio - suma2;

                        }
                        if (cont2==1) {
                            gananciaa2 = gananciaa2 + ganancia2;
                            cont2=2;
                        }
                        cont2=1;
                    }


                    //////////////////////////////////////////////////////////////////////////////////////Cafe
                    if (titulo.equals("Sencillo")) {
                        //Ingrediente - cafe
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;



                        if (cont3==0) {
                            suma3 = formula4 + formula5 + formula6;
                            ganancia3 = precio - suma3;

                        }
                        if (cont3==1) {
                            gananciaa3 = gananciaa3 + ganancia3;
                            cont3=2;
                        }
                        cont3=1;
                    }

                    if (titulo.equals("Doble")) {
                        //Ingrediente - cafe
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (16 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 16;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 16;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (16 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 16;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 16;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (480 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 480;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 480;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;



                        if (cont4==0) {
                            suma4 = formula4 + formula5 + formula6;
                            ganancia4 = precio - suma4;

                        }
                        if (cont4==1) {
                            gananciaa4 = gananciaa4 + ganancia4;
                            cont4=2;
                        }
                        cont4=1;
                    }
                    if (titulo.equals("Americano")) {
                        //Ingrediente - cafe
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (12 * costo4) / cantidad4; //12 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 12;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 12;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;



                        if (cont5==0) {
                            suma5 = formula4 + formula5 + formula6;
                            ganancia5 = precio - suma5;

                        }
                        if (cont5==1) {
                            gananciaa5 = gananciaa5 + ganancia5;
                            cont5=2;
                        }
                        cont5=1;
                    }
                    if (titulo.equals("Affogato")) {
                        /////cafe
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;
                        //Helado de Vainilla
                        if (conthvainilla == 0) {
                            cantidad7 = dataSnapshot.child("inventario").child("Helado de Vainilla").child("cantidad").getValue(Integer.class);
                            costo7 = dataSnapshot.child("inventario").child("Helado de Vainilla").child("costo").getValue(Integer.class);
                            formula7 = (25 * costo7) / cantidad7; //25 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto7 = costo7 - formula7;
                            nuevacantidad7 = cantidad7 - 25;
                            bd.child("Helado de Vainilla").child("cantidad").setValue(nuevacantidad7);
                            bd.child("Helado de Vainilla").child("costo").setValue(nuevocosto7);

                        }
                        if (conthvainilla == 1) {
                            nuevacantidad7 = nuevacantidad7 - 25;
                            nuevocosto7 = nuevocosto7 - formula7;
                            bd.child("Helado de Vainilla").child("cantidad").setValue(nuevacantidad7);
                            bd.child("Helado de Vainilla").child("costo").setValue(nuevocosto7);
                            conthvainilla = 2;
                        }
                        conthvainilla = 1;
                        //Licor
                        if (contlicor == 0) {
                            cantidad8 = dataSnapshot.child("inventario").child("Licor").child("cantidad").getValue(Integer.class);
                            costo8 = dataSnapshot.child("inventario").child("Licor").child("costo").getValue(Integer.class);
                            formula8 = (20 * costo8) / cantidad8; //20 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto8 = costo8 - formula8;
                            nuevacantidad8 = cantidad8 - 20;
                            bd.child("Licor").child("cantidad").setValue(nuevacantidad8);
                            bd.child("Licor").child("costo").setValue(nuevocosto8);

                        }
                        if (contlicor == 1) {
                            nuevacantidad8 = nuevacantidad8 - 20;
                            nuevocosto8 = nuevocosto8- formula8;
                            bd.child("Licor").child("cantidad").setValue(nuevacantidad8);
                            bd.child("Licor").child("costo").setValue(nuevocosto8);
                            contlicor = 2;
                        }
                        contlicor = 1;



                        if (cont6==0) {
                            suma6 = formula4 + formula5 + formula6 + formula7 + formula8;
                            ganancia6 = precio - suma6;

                        }
                        if (cont6==1) {
                            gananciaa6 = gananciaa6 + ganancia6;
                            cont6=2;
                        }
                        cont6=1;
                    }



                    //Capuchino
                    if (titulo.equals("Capuchino tradicional")) {
                        /////capuchino
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;
                        //Canela
                        if (contcanela == 0) {
                            cantidad9 = dataSnapshot.child("inventario").child("Canela").child("cantidad").getValue(Integer.class);
                            costo9 = dataSnapshot.child("inventario").child("Canela").child("costo").getValue(Integer.class);
                            formula9 = (25 * costo9) / cantidad9; //25 es la cantidad en gramos que se utilizara de canela
                            nuevocosto9 = costo9 - formula9;
                            nuevacantidad9 = cantidad9 - 25;
                            bd.child("Canela").child("cantidad").setValue(nuevacantidad9);
                            bd.child("Canela").child("costo").setValue(nuevocosto9);

                        }
                        if (contcanela == 1) {
                            nuevacantidad9 = nuevacantidad9 - 25;
                            nuevocosto9 = nuevocosto9 - formula9;
                            bd.child("Canela").child("cantidad").setValue(nuevacantidad9);
                            bd.child("Canela").child("costo").setValue(nuevocosto9);
                            contcanela = 2;
                        }
                        contcanela = 1;
                        //Nata
                        if (contnata == 0) {
                            cantidad10 = dataSnapshot.child("inventario").child("Nata").child("cantidad").getValue(Integer.class);
                            costo10 = dataSnapshot.child("inventario").child("Nata").child("costo").getValue(Integer.class);
                            formula10 = (20 * costo10) / cantidad10; //20 es la cantidad en gramos que se utilizara de nata
                            nuevocosto10 = costo10 - formula10;
                            nuevacantidad10 = cantidad10 - 20;
                            bd.child("Nata").child("cantidad").setValue(nuevacantidad10);
                            bd.child("Nata").child("costo").setValue(nuevocosto10);

                        }
                        if (contnata == 1) {
                            nuevacantidad10 = nuevacantidad10 - 20;
                            nuevocosto10 = nuevocosto10- formula10;
                            bd.child("Nata").child("cantidad").setValue(nuevacantidad10);
                            bd.child("Nata").child("costo").setValue(nuevocosto10);
                            contnata = 2;
                        }
                        contnata = 1;



                        if (cont7==0) {
                            suma7 = formula4 + formula5 + formula6 + formula9 + formula10;
                            ganancia7 = precio - suma7;

                        }
                        if (cont7==1) {
                            gananciaa7 = gananciaa7 + ganancia7;
                            cont7=2;
                        }
                        cont7=1;
                    }
                    if (titulo.equals("Capuchino moka")) {
                        /////capuchino moka
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //cacao
                        if (contcacao == 0) {
                            cantidad11 = dataSnapshot.child("inventario").child("Cacao").child("cantidad").getValue(Integer.class);
                            costo11 = dataSnapshot.child("inventario").child("Cacao").child("costo").getValue(Integer.class);
                            formula11 = (20 * costo11) / cantidad11; //20 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto11 = costo11 - formula11;
                            nuevacantidad11 = cantidad11 - 20;
                            bd.child("Cacao").child("cantidad").setValue(nuevacantidad11);
                            bd.child("Cacao").child("costo").setValue(nuevocosto11);

                        }
                        if (contcacao == 1) {
                            nuevacantidad11 = nuevacantidad11 - 20;
                            nuevocosto11 = nuevocosto11- formula11;
                            bd.child("Cacao").child("cantidad").setValue(nuevacantidad11);
                            bd.child("Cacao").child("costo").setValue(nuevocosto11);
                            contcacao = 2;
                        }
                        contcacao = 1;



                        if (cont8==0) {
                            suma8 = formula4 + formula5 + formula6 + formula11;
                            ganancia8 = precio - suma8;

                        }
                        if (cont8==1) {
                            gananciaa8 = gananciaa8 + ganancia8;
                            cont8=2;
                        }
                        cont8=1;
                    }
                    if (titulo.equals("Capuchino vainilla Francesa")) {
                        /////capuchino vainilla
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //vainilla
                        if (contvainilla == 0) {
                            cantidad12 = dataSnapshot.child("inventario").child("Vainilla").child("cantidad").getValue(Integer.class);
                            costo12 = dataSnapshot.child("inventario").child("Vainilla").child("costo").getValue(Integer.class);
                            formula12 = (10 * costo12) / cantidad12; //20 es la cantidad en militros que se utilizara de vainilla
                            nuevocosto12 = costo12 - formula12;
                            nuevacantidad12 = cantidad12 - 10;
                            bd.child("Vainilla").child("cantidad").setValue(nuevacantidad12);
                            bd.child("Vainilla").child("costo").setValue(nuevocosto12);

                        }
                        if (contvainilla == 1) {
                            nuevacantidad12 = nuevacantidad12 - 10;
                            nuevocosto12 = nuevocosto12- formula12;
                            bd.child("Vainilla").child("cantidad").setValue(nuevacantidad12);
                            bd.child("Vainilla").child("costo").setValue(nuevocosto12);
                            contvainilla = 2;
                        }
                        contvainilla = 1;



                        if (cont9==0) {
                            suma9 = formula4 + formula5 + formula6 + formula12;
                            ganancia9= precio - suma9;

                        }
                        if (cont9==1) {
                            gananciaa9 = gananciaa9 + ganancia9;
                            cont9=2;
                        }
                        cont9=1;

                    }
                    if (titulo.equals("Capuchino crema Irlandesa")) {
                        /////capuchino crema
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //crema francesa
                        if (contcremaf == 0) {
                            cantidad13 = dataSnapshot.child("inventario").child("Crema Francesa").child("cantidad").getValue(Integer.class);
                            costo13 = dataSnapshot.child("inventario").child("Crema Francesa").child("costo").getValue(Integer.class);
                            formula13 = (10 * costo13) / cantidad13; //20 es la cantidad en militros que se utilizara de cremaf
                            nuevocosto13 = costo13 - formula13;
                            nuevacantidad13 = cantidad13 - 10;
                            bd.child("Crema Francesa").child("cantidad").setValue(nuevacantidad13);
                            bd.child("Crema Francesa").child("costo").setValue(nuevocosto13);

                        }
                        if (contcremaf == 1) {
                            nuevacantidad13 = nuevacantidad13 - 10;
                            nuevocosto13 = nuevocosto13- formula13;
                            bd.child("Crema Francesa").child("cantidad").setValue(nuevacantidad13);
                            bd.child("Crema Francesa").child("costo").setValue(nuevocosto13);
                            contcremaf = 2;
                        }
                        contcremaf = 1;



                        if (cont10==0) {
                            suma10 = formula4 + formula5 + formula6 + formula13;
                            ganancia10 = precio - suma10;

                        }
                        if (cont10==1) {
                            gananciaa10 = gananciaa10 + ganancia10;
                            cont10=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Capuchino caramelo")) {
                        /////capuchino caramelo
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //////Caramelo
                        if (contcaramelo == 0) {
                            cantidad14 = dataSnapshot.child("inventario").child("Caramelo").child("cantidad").getValue(Integer.class);
                            costo14 = dataSnapshot.child("inventario").child("Caramelo").child("costo").getValue(Integer.class);
                            formula14 = (10 * costo14) / cantidad14; //20 es la cantidad en militros que se utilizara de cremaf
                            nuevocosto14 = costo14 - formula14;
                            nuevacantidad14 = cantidad14 - 10;
                            bd.child("Caramelo").child("cantidad").setValue(nuevacantidad14);
                            bd.child("Caramelo").child("costo").setValue(nuevocosto14);

                        }
                        if (contcaramelo == 1) {
                            nuevacantidad14 = nuevacantidad14 - 10;
                            nuevocosto14 = nuevocosto14- formula14;
                            bd.child("Caramelo").child("cantidad").setValue(nuevacantidad14);
                            bd.child("Caramelo").child("costo").setValue(nuevocosto14);
                            contcaramelo = 2;
                        }
                        contcaramelo = 1;



                        if (cont11==0) {
                            suma11 = formula4 + formula5 + formula6 + formula14;
                            ganancia11 = precio - suma11;

                        }
                        if (cont11==1) {
                            gananciaa11 = gananciaa11 + ganancia11;
                            cont11=2;
                        }
                        cont11=1;
                    }
                    if (titulo.equals("Capuchino tiramisu")) {
                        /////capuchino tiramisu
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //////Tiramisu
                        if (conttiramisu == 0) {
                            cantidad15 = dataSnapshot.child("inventario").child("Tiramisu").child("cantidad").getValue(Integer.class);
                            costo15 = dataSnapshot.child("inventario").child("Tiramisu").child("costo").getValue(Integer.class);
                            formula15 = (10 * costo15) / cantidad15; //10 es la cantidad en militros que se utilizara de tiramisu
                            nuevocosto15 = costo15 - formula15;
                            nuevacantidad15 = cantidad15 - 10;
                            bd.child("Tiramisu").child("cantidad").setValue(nuevacantidad15);
                            bd.child("Tiramisu").child("costo").setValue(nuevocosto15);

                        }
                        if (conttiramisu == 1) {
                            nuevacantidad15 = nuevacantidad15 - 10;
                            nuevocosto15 = nuevocosto15- formula15;
                            bd.child("Tiramisu").child("cantidad").setValue(nuevacantidad15);
                            bd.child("Tiramisu").child("costo").setValue(nuevocosto15);
                            conttiramisu = 2;
                        }
                        conttiramisu = 1;



                        if (cont12==0) {
                            suma12 = formula4 + formula5 + formula6 + formula15;
                            ganancia12 = precio - suma12;

                        }
                        if (cont12==1) {
                            gananciaa12 = gananciaa12 + ganancia12;
                            cont12=2;
                        }
                        cont12=1;
                    }
                    if (titulo.equals("Capuchino rompope Italiano")) {
                        /////capuchino Rompope
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //////rompope
                        if (contrompope == 0) {
                            cantidad16 = dataSnapshot.child("inventario").child("Rompope").child("cantidad").getValue(Integer.class);
                            costo16 = dataSnapshot.child("inventario").child("Rompope").child("costo").getValue(Integer.class);
                            formula16 = (10 * costo16) / cantidad16; //10 es la cantidad en militros que se utilizara de tiramisu
                            nuevocosto16 = costo16 - formula16;
                            nuevacantidad16 = cantidad16 - 10;
                            bd.child("Rompope").child("cantidad").setValue(nuevacantidad16);
                            bd.child("Rompope").child("costo").setValue(nuevocosto16);

                        }
                        if (contrompope == 1) {
                            nuevacantidad16 = nuevacantidad16 - 10;
                            nuevocosto16 = nuevocosto16- formula16;
                            bd.child("Rompope").child("cantidad").setValue(nuevacantidad16);
                            bd.child("Rompope").child("costo").setValue(nuevocosto16);
                            contrompope = 2;
                        }
                        contrompope = 1;



                        if (cont13==0) {
                            suma13 = formula4 + formula5 + formula6 + formula16;
                            ganancia13 = precio - suma13;

                        }
                        if (cont13==1) {
                            gananciaa13 = gananciaa13 + ganancia13;
                            cont13=2;
                        }
                        cont13=1;
                    }
                    if (titulo.equals("Capuchino cajeta")) {
                        /////capuchino cajeta
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //////cajeta
                        if (contcajeta == 0) {
                            cantidad17 = dataSnapshot.child("inventario").child("Cajeta").child("cantidad").getValue(Integer.class);
                            costo17 = dataSnapshot.child("inventario").child("Cajeta").child("costo").getValue(Integer.class);
                            formula17 = (10 * costo17) / cantidad17; //10 es la cantidad en militros que se utilizara de tiramisu
                            nuevocosto17 = costo17 - formula17;
                            nuevacantidad17 = cantidad17 - 10;
                            bd.child("Cajeta").child("cantidad").setValue(nuevacantidad17);
                            bd.child("Cajeta").child("costo").setValue(nuevocosto17);

                        }
                        if (contcajeta == 1) {
                            nuevacantidad17 = nuevacantidad17 - 10;
                            nuevocosto17 = nuevocosto17- formula17;
                            bd.child("Cajeta").child("cantidad").setValue(nuevacantidad17);
                            bd.child("Cajeta").child("costo").setValue(nuevocosto17);
                            contcajeta = 2;
                        }
                        contcajeta = 1;



                        if (cont14==0) {
                            suma14 = formula4 + formula5 + formula6 + formula17;
                            ganancia14 = precio - suma14;

                        }
                        if (cont14==1) {
                            gananciaa14 = gananciaa14 + ganancia14;
                            cont14=2;
                        }
                        cont14=1;
                    }
                    if (titulo.equals("Capuchino amaretto")) {
                        /////capuchino amaretto
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //////amaretto
                        if (contamaretto == 0) {
                            cantidad18 = dataSnapshot.child("inventario").child("Amaretto").child("cantidad").getValue(Integer.class);
                            costo18 = dataSnapshot.child("inventario").child("Amaretto").child("costo").getValue(Integer.class);
                            formula18 = (10 * costo18) / cantidad18; //10 es la cantidad en militros que se utilizara de tiramisu
                            nuevocosto18 = costo18 - formula18;
                            nuevacantidad18 = cantidad18 - 10;
                            bd.child("Amaretto").child("cantidad").setValue(nuevacantidad18);
                            bd.child("Amaretto").child("costo").setValue(nuevocosto18);

                        }
                        if (contamaretto == 1) {
                            nuevacantidad18 = nuevacantidad18 - 10;
                            nuevocosto18 = nuevocosto18- formula18;
                            bd.child("Amaretto").child("cantidad").setValue(nuevacantidad18);
                            bd.child("Amaretto").child("costo").setValue(nuevocosto18);
                            contamaretto = 2;
                        }
                        contamaretto = 1;



                        if (cont15==0) {
                            suma15 = formula4 + formula5 + formula6 + formula18;
                            ganancia15 = precio - suma15;

                        }
                        if (cont15==1) {
                            ganancia15 = gananciaa15 + ganancia15;
                            cont15=2;
                        }
                        cont15=1;
                    }
                    if (titulo.equals("Chocolate Macadamia")) {
                        ///// macadamia
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //////macadamia
                        if (contmacadamia == 0) {
                            cantidad19 = dataSnapshot.child("inventario").child("Macadamia").child("cantidad").getValue(Integer.class);
                            costo19 = dataSnapshot.child("inventario").child("Macadamia").child("costo").getValue(Integer.class);
                            formula19 = (5 * costo19) / cantidad19; //5 es la cantidad en militros que se utilizara de tiramisu
                            nuevocosto19 = costo19 - formula19;
                            nuevacantidad19 = cantidad19 - 5;
                            bd.child("Macadamia").child("cantidad").setValue(nuevacantidad19);
                            bd.child("Macadamia").child("costo").setValue(nuevocosto19);

                        }
                        if (contmacadamia == 1) {
                            nuevacantidad19 = nuevacantidad19 - 5;
                            nuevocosto19 = nuevocosto19- formula19;
                            bd.child("Macadamia").child("cantidad").setValue(nuevacantidad19);
                            bd.child("Macadamia").child("costo").setValue(nuevocosto19);
                            contmacadamia = 2;
                        }
                        contmacadamia = 1;



                        if (cont16==0) {
                            suma16 = formula4 + formula5 + formula6 + formula19;
                            ganancia16 = precio - suma16;

                        }
                        if (cont16==1) {
                            gananciaa16 = gananciaa16 + ganancia16;
                            cont16=2;
                        }
                        cont16=1;
                    }

                    //Chai
                    if (titulo.equals("Vainilla")) {
                        /////chai vainilla
                        if (contchaiv == 0) {
                            cantidad20 = dataSnapshot.child("inventario").child("Chai vainilla").child("cantidad").getValue(Integer.class);
                            costo20 = dataSnapshot.child("inventario").child("Chai vainilla").child("costo").getValue(Integer.class);
                            formula20 = (8 * costo20) / cantidad20; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto20 = costo20 - formula20;
                            nuevacantidad20 = cantidad20 - 8;
                            bd.child("Chai vainilla").child("cantidad").setValue(nuevacantidad20);
                            bd.child("Chai vainilla").child("costo").setValue(nuevocosto20);

                        }
                        if (contchaiv == 1) {
                            nuevacantidad20 = nuevacantidad20 - 8;
                            nuevocosto20 = nuevocosto20 - formula20;
                            bd.child("Chai vainilla").child("cantidad").setValue(nuevacantidad20);
                            bd.child("Chai vainilla").child("costo").setValue(nuevocosto20);
                            contchaiv = 2;
                        }
                        contchaiv = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //////agua
                        if (contagua == 0) {
                            cantidad21 = dataSnapshot.child("inventario").child("Agua").child("cantidad").getValue(Integer.class);
                            costo21 = dataSnapshot.child("inventario").child("Agua").child("costo").getValue(Integer.class);
                            formula21 = (240 * costo21) / cantidad21; //240 es la cantidad en militros que se utilizara de tiramisu
                            nuevocosto21 = costo21 - formula21;
                            nuevacantidad21 = cantidad21 - 240;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad21);
                            bd.child("Agua").child("costo").setValue(nuevocosto21);

                        }
                        if (contagua == 1) {
                            nuevacantidad21 = nuevacantidad21 - 240;
                            nuevocosto21 = nuevocosto21- formula21;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad21);
                            bd.child("Agua").child("costo").setValue(nuevocosto21);
                            contagua = 2;
                        }
                        contagua = 1;



                        if (cont17==0) {
                            suma17 = formula20 + formula5 + formula6 + formula21;
                            ganancia17 = precio - suma17;

                        }
                        if (cont17==1) {
                            gananciaa17= gananciaa17 + ganancia17;
                            cont17=2;
                        }
                        cont17=1;
                    }
                    if (titulo.equals("Mango")) {
                        /////chai mango
                        if (contchaim == 0) {
                            cantidad22 = dataSnapshot.child("inventario").child("Chai mango").child("cantidad").getValue(Integer.class);
                            costo22 = dataSnapshot.child("inventario").child("Chai mango").child("costo").getValue(Integer.class);
                            formula22 = (8 * costo22) / cantidad22; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto22 = costo22 - formula22;
                            nuevacantidad22 = cantidad22 - 8;
                            bd.child("Chai mango").child("cantidad").setValue(nuevacantidad22);
                            bd.child("Chai mango").child("costo").setValue(nuevocosto22);

                        }
                        if (contchaim == 1) {
                            nuevacantidad22 = nuevacantidad22 - 8;
                            nuevocosto22 = nuevocosto22 - formula22;
                            bd.child("Chai mango").child("cantidad").setValue(nuevacantidad22);
                            bd.child("Chai mango").child("costo").setValue(nuevocosto22);
                            contchaim = 2;
                        }
                        contchaim = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //////agua
                        if (contagua == 0) {
                            cantidad21 = dataSnapshot.child("inventario").child("Agua").child("cantidad").getValue(Integer.class);
                            costo21 = dataSnapshot.child("inventario").child("Agua").child("costo").getValue(Integer.class);
                            formula21 = (240 * costo21) / cantidad21; //240 es la cantidad en militros que se utilizara de tiramisu
                            nuevocosto21 = costo21 - formula21;
                            nuevacantidad21 = cantidad21 - 240;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad21);
                            bd.child("Agua").child("costo").setValue(nuevocosto21);

                        }
                        if (contagua == 1) {
                            nuevacantidad21 = nuevacantidad21 - 240;
                            nuevocosto21 = nuevocosto21- formula21;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad21);
                            bd.child("Agua").child("costo").setValue(nuevocosto21);
                            contagua = 2;
                        }
                        contagua = 1;



                        if (cont18==0) {
                            suma18 = formula22 + formula5 + formula6 + formula21;
                            ganancia18 = precio - suma18;

                        }
                        if (cont18==1) {
                            gananciaa18 = gananciaa18 + ganancia18;
                            cont18=2;
                        }
                        cont18=1;
                    }

                    //Choco
                    if (titulo.equals("Tradicional")) {
                        if (contchocolate == 0) {
                            cantidad24 = dataSnapshot.child("inventario").child("Chocolate").child("cantidad").getValue(Integer.class);
                            costo24 = dataSnapshot.child("inventario").child("Chocolate").child("costo").getValue(Integer.class);
                            formula24 = (10 * costo24) / cantidad24; //10 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto24 = costo24 - formula24;
                            nuevacantidad24 = cantidad24 - 10;
                            bd.child("Chocolate").child("cantidad").setValue(nuevacantidad24);
                            bd.child("Chocolate").child("costo").setValue(nuevocosto24);

                        }
                        if (contchocolate == 1) {
                            nuevacantidad24 = nuevacantidad24 - 8;
                            nuevocosto24 = nuevocosto24 - formula24;
                            bd.child("Chocolate").child("cantidad").setValue(nuevacantidad24);
                            bd.child("Chocolate").child("costo").setValue(nuevocosto24);
                            contchocolate = 2;
                        }
                        contchocolate = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;


                        if (cont19==0) {
                            suma19 = formula24 + formula5 + formula6 ;
                            ganancia19 = precio - suma19;

                        }
                        if (cont1==19) {
                            gananciaa19 = gananciaa19 + ganancia19;
                            cont19=2;
                        }
                        cont19=1;
                    }
                    if (titulo.equals("Blanco")) {
                        //Chocolate blanco
                        if (contchocolateb == 0) {
                            cantidad25 = dataSnapshot.child("inventario").child("Chocolate blanco").child("cantidad").getValue(Integer.class);
                            costo25 = dataSnapshot.child("inventario").child("Chocolate blanco").child("costo").getValue(Integer.class);
                            formula25 = (10 * costo25) / cantidad25; //10 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto25 = costo25 - formula25;
                            nuevacantidad25 = cantidad25 - 10;
                            bd.child("Chocolate blanco").child("cantidad").setValue(nuevacantidad25);
                            bd.child("Chocolate blanco").child("costo").setValue(nuevocosto25);

                        }
                        if (contchocolateb == 1) {
                            nuevacantidad25 = nuevacantidad25 - 8;
                            nuevocosto25 = nuevocosto25 - formula25;
                            bd.child("Chocolate blanco").child("cantidad").setValue(nuevacantidad25);
                            bd.child("Chocolate blanco").child("costo").setValue(nuevocosto25);
                            contchocolateb = 2;
                        }
                        contchocolateb = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;


                        if (cont20==0) {
                            suma20 = formula25 + formula5 + formula6 ;
                            ganancia20 = precio - suma20;

                        }
                        if (cont20==1) {
                            gananciaa20 = gananciaa20 + ganancia20;
                            cont20=2;
                        }
                        cont20=1;
                    }

                    //cocteles
                    if (titulo.equals("Rusa de refresco")) {
                        //refrescos
                        if (contrefrescos == 0) {
                            cantidad26 = dataSnapshot.child("inventario").child("Refrescos").child("cantidad").getValue(Integer.class);
                            costo26 = dataSnapshot.child("inventario").child("Refrescos").child("costo").getValue(Integer.class);
                            formula26 = (500 * costo26) / cantidad26; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto26 = costo26 - formula26;
                            nuevacantidad26 = cantidad26 - 500;
                            bd.child("Refrescos").child("cantidad").setValue(nuevacantidad26);
                            bd.child("Refrescos").child("costo").setValue(nuevocosto26);

                        }
                        if (contrefrescos == 1) {
                            nuevacantidad26 = nuevacantidad26 - 500;
                            nuevocosto26 = nuevocosto26 - formula26;
                            bd.child("Refrescos").child("cantidad").setValue(nuevacantidad26);
                            bd.child("Refrescos").child("costo").setValue(nuevocosto26);
                            contrefrescos = 2;
                        }
                        contrefrescos = 1;


                        //Sal
                        if (contsal == 0) {
                            cantidad27 = dataSnapshot.child("inventario").child("Sal").child("cantidad").getValue(Integer.class);
                            costo27 = dataSnapshot.child("inventario").child("Sal").child("costo").getValue(Integer.class);
                            formula27 = (8 * costo27) / cantidad27; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto27 = costo27 - formula27;
                            nuevacantidad27 = cantidad27 - 8;
                            bd.child("Sal").child("cantidad").setValue(nuevacantidad27);
                            bd.child("Sal").child("costo").setValue(nuevocosto27);

                        }
                        if (contsal == 1) {
                            nuevacantidad27 = nuevacantidad27 - 8;
                            nuevocosto27 = nuevocosto27 - formula27;
                            bd.child("Sal").child("cantidad").setValue(nuevacantidad27);
                            bd.child("Sal").child("costo").setValue(nuevocosto27);
                            contsal = 2;
                        }
                        contsal = 1;

                        //Limon
                        if (contlimon == 0) {
                            cantidad28 = dataSnapshot.child("inventario").child("Limon").child("cantidad").getValue(Integer.class);
                            costo28 = dataSnapshot.child("inventario").child("Limon").child("costo").getValue(Integer.class);
                            formula28 = (15 * costo28) / cantidad28; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto28 = costo28 - formula28;
                            nuevacantidad28 = cantidad28 - 15;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);

                        }
                        if (contlimon == 1) {
                            nuevacantidad28 = nuevacantidad28 - 15;
                            nuevocosto28 = nuevocosto28 - formula28;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);
                            contlimon = 2;
                        }
                        contlimon = 1;


                        if (cont21==0) {
                            suma21 = formula26 + formula27 + formula28 ;
                            ganancia21 = precio - suma21;

                        }
                        if (cont21==1) {
                            gananciaa21 = gananciaa21 + ganancia21;
                            cont21=2;
                        }
                        cont21=1;
                    }
                    if (titulo.equals("Limonada")) {
                        //Agua mineral
                        if (contaguamin == 0) {
                            cantidad29 = dataSnapshot.child("inventario").child("Agua mineral").child("cantidad").getValue(Integer.class);
                            costo29 = dataSnapshot.child("inventario").child("Agua mineral").child("costo").getValue(Integer.class);
                            formula29 = (500 * costo29) / cantidad29; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto29 = costo29 - formula29;
                            nuevacantidad29 = cantidad29 - 500;
                            bd.child("Agua mineral").child("cantidad").setValue(nuevacantidad29);
                            bd.child("Agua mineral").child("costo").setValue(nuevocosto29);

                        }
                        if (contaguamin == 1) {
                            nuevacantidad29 = nuevacantidad29 - 500;
                            nuevocosto29 = nuevocosto29 - formula29;
                            bd.child("Agua mineral").child("cantidad").setValue(nuevacantidad29);
                            bd.child("Agua mineral").child("costo").setValue(nuevocosto29);
                            contaguamin = 2;
                        }
                        contaguamin = 1;

                        //Limon
                        if (contlimon == 0) {
                            cantidad28 = dataSnapshot.child("inventario").child("Limon").child("cantidad").getValue(Integer.class);
                            costo28 = dataSnapshot.child("inventario").child("Limon").child("costo").getValue(Integer.class);
                            formula28 = (15 * costo28) / cantidad28; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto28 = costo28 - formula28;
                            nuevacantidad28 = cantidad28 - 15;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);

                        }
                        if (contlimon == 1) {
                            nuevacantidad28 = nuevacantidad28 - 15;
                            nuevocosto28 = nuevocosto28 - formula28;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);
                            contlimon = 2;
                        }
                        contlimon = 1;


                        if (cont22==0) {
                            suma22 = formula29 + formula28 ;
                            ganancia22 = precio - suma22;

                        }
                        if (cont22==1) {
                            gananciaa22 = gananciaa22 + ganancia22;
                            cont22=2;
                        }
                        cont22=1;
                    }
                    if (titulo.equals("Naranjada")) {
                        //Agua mineral
                        if (contaguamin == 0) {
                            cantidad29 = dataSnapshot.child("inventario").child("Agua mineral").child("cantidad").getValue(Integer.class);
                            costo29 = dataSnapshot.child("inventario").child("Agua mineral").child("costo").getValue(Integer.class);
                            formula29 = (500 * costo29) / cantidad29; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto29 = costo29 - formula29;
                            nuevacantidad29 = cantidad29 - 500;
                            bd.child("Agua mineral").child("cantidad").setValue(nuevacantidad29);
                            bd.child("Agua mineral").child("costo").setValue(nuevocosto29);

                        }
                        if (contaguamin == 1) {
                            nuevacantidad29 = nuevacantidad29 - 500;
                            nuevocosto29 = nuevocosto29 - formula29;
                            bd.child("Agua mineral").child("cantidad").setValue(nuevacantidad29);
                            bd.child("Agua mineral").child("costo").setValue(nuevocosto29);
                            contaguamin = 2;
                        }
                        contaguamin = 1;

                        //Naranja
                        if (contnaranja == 0) {
                            cantidad30 = dataSnapshot.child("inventario").child("Naranja").child("cantidad").getValue(Integer.class);
                            costo30 = dataSnapshot.child("inventario").child("Naranja").child("costo").getValue(Integer.class);
                            formula30 = (15 * costo30) / cantidad30; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto30 = costo30 - formula30;
                            nuevacantidad30 = cantidad30 - 15;
                            bd.child("Naranja").child("cantidad").setValue(nuevacantidad30);
                            bd.child("Naranja").child("costo").setValue(nuevocosto30);

                        }
                        if (contnaranja == 1) {
                            nuevacantidad30 = nuevacantidad30 - 15;
                            nuevocosto30 = nuevocosto30 - formula30;
                            bd.child("Naranja").child("cantidad").setValue(nuevacantidad30);
                            bd.child("Naranja").child("costo").setValue(nuevocosto30);
                            contnaranja = 2;
                        }
                        contnaranja = 1;


                        if (cont23==0) {
                            suma23 = formula29 + formula30 ;
                            ganancia23 = precio - suma23;

                        }
                        if (cont23==1) {
                            gananciaa23 = gananciaa23 + ganancia23;
                            cont23=2;
                        }
                        cont23=1;
                    }
                    if (titulo.equals("Sangria")) {
                        //Sangria
                        if (contsangria == 0) {
                            cantidad35 = dataSnapshot.child("inventario").child("Sangria").child("cantidad").getValue(Integer.class);
                            costo35 = dataSnapshot.child("inventario").child("Sangria").child("costo").getValue(Integer.class);
                            formula35 = (10 * costo35) / cantidad35; //10 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto35 = costo35 - formula35;
                            nuevacantidad35 = cantidad35 - 10;
                            bd.child("Sangria").child("cantidad").setValue(nuevacantidad35);
                            bd.child("Sangria").child("costo").setValue(nuevocosto35);

                        }
                        if (contsangria == 1) {
                            nuevacantidad35 = nuevacantidad35 - 10;
                            nuevocosto35 = nuevocosto35 - formula35;
                            bd.child("Sangria").child("cantidad").setValue(nuevacantidad35);
                            bd.child("Sangria").child("costo").setValue(nuevocosto35);
                            contsangria = 2;
                        }
                        contsangria = 1;





                        if (cont24==0) {
                            suma24 = formula35;
                            ganancia24 = precio - suma24;

                        }
                        if (cont24==1) {
                            gananciaa24 = gananciaa24 + ganancia24;
                            cont24=2;
                        }
                        cont24=1;
                    }
                    if (titulo.equals("Mojito cubano")) {
                        //Ron
                        if (contron == 0) {
                            cantidad32 = dataSnapshot.child("inventario").child("Ron").child("cantidad").getValue(Integer.class);
                            costo32 = dataSnapshot.child("inventario").child("Ron").child("costo").getValue(Integer.class);
                            formula32 = (250 * costo32) / cantidad32; //250 es la cantidad de mililitros que se utilizará de ron
                            nuevocosto32 = costo32 - formula32;
                            nuevacantidad32 = cantidad32 - 250;
                            bd.child("Ron").child("cantidad").setValue(nuevacantidad32);
                            bd.child("Ron").child("costo").setValue(nuevocosto32);

                        }
                        if (contron == 1) {
                            nuevacantidad32 = nuevacantidad32 - 250;
                            nuevocosto32 = nuevocosto32 - formula32;
                            bd.child("Ron").child("cantidad").setValue(nuevacantidad32);
                            bd.child("Ron").child("costo").setValue(nuevocosto32);
                            contron = 2;
                        }
                        contron = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Agua mineral
                        if (contaguamin == 0) {
                            cantidad29 = dataSnapshot.child("inventario").child("Agua mineral").child("cantidad").getValue(Integer.class);
                            costo29 = dataSnapshot.child("inventario").child("Agua mineral").child("costo").getValue(Integer.class);
                            formula29 = (500 * costo29) / cantidad29; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto29 = costo29 - formula29;
                            nuevacantidad29 = cantidad29 - 500;
                            bd.child("Agua mineral").child("cantidad").setValue(nuevacantidad29);
                            bd.child("Agua mineral").child("costo").setValue(nuevocosto29);

                        }
                        if (contaguamin == 1) {
                            nuevacantidad29 = nuevacantidad29 - 500;
                            nuevocosto29 = nuevocosto29 - formula29;
                            bd.child("Agua mineral").child("cantidad").setValue(nuevacantidad29);
                            bd.child("Agua mineral").child("costo").setValue(nuevocosto29);
                            contaguamin = 2;
                        }
                        contaguamin = 1;



                        if (cont25==0) {
                            suma25 = formula32 + formula5 + formula29 ;
                            ganancia25 = precio - suma25;

                        }
                        if (cont25==1) {
                            gananciaa25 = gananciaa25 + ganancia25;
                            cont25=2;
                        }
                        cont25=1;
                    }
                    if (titulo.equals("Tinto de verano")) {
                        //Vino tinto
                        if (contvinot == 0) {
                            cantidad33 = dataSnapshot.child("inventario").child("Vino tinto").child("cantidad").getValue(Integer.class);
                            costo33 = dataSnapshot.child("inventario").child("Vino tinto").child("costo").getValue(Integer.class);
                            formula33 = (500 * costo33) / cantidad33; //250 es la cantidad de mililitros que se utilizará de ron
                            nuevocosto33 = costo33 - formula33;
                            nuevacantidad33 = cantidad33 - 500;
                            bd.child("Vino tinto").child("cantidad").setValue(nuevacantidad33);
                            bd.child("Vino tinto").child("costo").setValue(nuevocosto33);

                        }
                        if (contvinot == 1) {
                            nuevacantidad33 = nuevacantidad33 - 500;
                            nuevocosto33 = nuevocosto33 - formula33;
                            bd.child("Vino tinto").child("cantidad").setValue(nuevacantidad33);
                            bd.child("Vino tinto").child("costo").setValue(nuevocosto33);
                            contvinot = 2;
                        }
                        contvinot = 1;


                        //Vermouth
                        if (contvermouth == 0) {
                            cantidad34 = dataSnapshot.child("inventario").child("Vermouth").child("cantidad").getValue(Integer.class);
                            costo34 = dataSnapshot.child("inventario").child("Vermouth").child("costo").getValue(Integer.class);
                            formula34 = (100 * costo34) / cantidad34; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto34 = costo34 - formula34;
                            nuevacantidad34 = cantidad34 - 100;
                            bd.child("Vermouth").child("cantidad").setValue(nuevacantidad34);
                            bd.child("Vermouth").child("costo").setValue(nuevocosto34);

                        }
                        if (contvermouth == 1) {
                            nuevacantidad34 = nuevacantidad34 - 100;
                            nuevocosto34 = nuevocosto34 - formula34;
                            bd.child("Vermouth").child("cantidad").setValue(nuevacantidad34);
                            bd.child("Vermouth").child("costo").setValue(nuevocosto34);
                            contvermouth = 2;
                        }
                        contvermouth = 1;

                        //Limon
                        if (contlimon == 0) {
                            cantidad28 = dataSnapshot.child("inventario").child("Limon").child("cantidad").getValue(Integer.class);
                            costo28 = dataSnapshot.child("inventario").child("Limon").child("costo").getValue(Integer.class);
                            formula28 = (15 * costo28) / cantidad28; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto28 = costo28 - formula28;
                            nuevacantidad28 = cantidad28 - 15;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);

                        }
                        if (contlimon == 1) {
                            nuevacantidad28 = nuevacantidad28 - 15;
                            nuevocosto28 = nuevocosto28 - formula28;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);
                            contlimon = 2;
                        }
                        contlimon = 1;



                        if (cont1==0) {
                            suma1 = formula33 + formula34 + formula28;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Clericot")) {
                        //Vino tinto
                        if (contvinot == 0) {
                            cantidad33 = dataSnapshot.child("inventario").child("Vino tinto").child("cantidad").getValue(Integer.class);
                            costo33 = dataSnapshot.child("inventario").child("Vino tinto").child("costo").getValue(Integer.class);
                            formula33 = (500 * costo33) / cantidad33; //250 es la cantidad de mililitros que se utilizará de ron
                            nuevocosto33 = costo33 - formula33;
                            nuevacantidad33 = cantidad33 - 500;
                            bd.child("Vino tinto").child("cantidad").setValue(nuevacantidad33);
                            bd.child("Vino tinto").child("costo").setValue(nuevocosto33);

                        }
                        if (contvinot == 1) {
                            nuevacantidad33 = nuevacantidad33 - 500;
                            nuevocosto33 = nuevocosto33 - formula33;
                            bd.child("Vino tinto").child("cantidad").setValue(nuevacantidad33);
                            bd.child("Vino tinto").child("costo").setValue(nuevocosto33);
                            contvinot = 2;
                        }
                        contvinot = 1;


                        //Agua mineral
                        if (contaguamin == 0) {
                            cantidad29 = dataSnapshot.child("inventario").child("Agua mineral").child("cantidad").getValue(Integer.class);
                            costo29 = dataSnapshot.child("inventario").child("Agua mineral").child("costo").getValue(Integer.class);
                            formula29 = (500 * costo29) / cantidad29; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto29 = costo29 - formula29;
                            nuevacantidad29 = cantidad29 - 500;
                            bd.child("Agua mineral").child("cantidad").setValue(nuevacantidad29);
                            bd.child("Agua mineral").child("costo").setValue(nuevocosto29);

                        }
                        if (contaguamin == 1) {
                            nuevacantidad29 = nuevacantidad29 - 500;
                            nuevocosto29 = nuevocosto29 - formula29;
                            bd.child("Agua mineral").child("cantidad").setValue(nuevacantidad29);
                            bd.child("Agua mineral").child("costo").setValue(nuevocosto29);
                            contaguamin = 2;
                        }
                        contaguamin = 1;

                        //Limon
                        if (contlimon == 0) {
                            cantidad28 = dataSnapshot.child("inventario").child("Limon").child("cantidad").getValue(Integer.class);
                            costo28 = dataSnapshot.child("inventario").child("Limon").child("costo").getValue(Integer.class);
                            formula28 = (15 * costo28) / cantidad28; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto28 = costo28 - formula28;
                            nuevacantidad28 = cantidad28 - 15;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);

                        }
                        if (contlimon == 1) {
                            nuevacantidad28 = nuevacantidad28 - 15;
                            nuevocosto28 = nuevocosto28 - formula28;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);
                            contlimon = 2;
                        }
                        contlimon = 1;

                        //Manzana
                        if (contmanzana == 0) {
                            cantidad36 = dataSnapshot.child("inventario").child("Manzana").child("cantidad").getValue(Integer.class);
                            costo36 = dataSnapshot.child("inventario").child("Manzana").child("costo").getValue(Integer.class);
                            formula36 = (50 * costo36) / cantidad36; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto36 = costo36 - formula36;
                            nuevacantidad36 = cantidad36 - 50;
                            bd.child("Manzana").child("cantidad").setValue(nuevacantidad36);
                            bd.child("Manzana").child("costo").setValue(nuevocosto36);

                        }
                        if (contmanzana == 1) {
                            nuevacantidad36 = nuevacantidad36 - 50;
                            nuevocosto36 = nuevocosto36 - formula36;
                            bd.child("Manzana").child("cantidad").setValue(nuevacantidad36);
                            bd.child("Manzana").child("costo").setValue(nuevocosto36);
                            contmanzana = 2;
                        }
                        contmanzana = 1;



                        if (cont1==0) {
                            suma1 = formula33 + formula29 + formula28 + formula36;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Rusa de cerveza")) {
                        //cerveza
                        if (contcerveza == 0) {
                            cantidad37 = dataSnapshot.child("inventario").child("Cerveza").child("cantidad").getValue(Integer.class);
                            costo37 = dataSnapshot.child("inventario").child("Cerveza").child("costo").getValue(Integer.class);
                            formula37 = (500 * costo37) / cantidad37; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto37 = costo37 - formula37;
                            nuevacantidad37 = cantidad37 - 500;
                            bd.child("Cerveza").child("cantidad").setValue(nuevacantidad37);
                            bd.child("Cerveza").child("costo").setValue(nuevocosto37);

                        }
                        if (contcerveza == 1) {
                            nuevacantidad37 = nuevacantidad37 - 500;
                            nuevocosto37 = nuevocosto37 - formula37;
                            bd.child("Cerveza").child("cantidad").setValue(nuevacantidad37);
                            bd.child("Cerveza").child("costo").setValue(nuevocosto37);
                            contcerveza = 2;
                        }
                        contcerveza = 1;


                        //Sal
                        if (contsal == 0) {
                            cantidad27 = dataSnapshot.child("inventario").child("Sal").child("cantidad").getValue(Integer.class);
                            costo27 = dataSnapshot.child("inventario").child("Sal").child("costo").getValue(Integer.class);
                            formula27 = (8 * costo27) / cantidad27; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto27 = costo27 - formula27;
                            nuevacantidad27 = cantidad27 - 8;
                            bd.child("Sal").child("cantidad").setValue(nuevacantidad27);
                            bd.child("Sal").child("costo").setValue(nuevocosto27);

                        }
                        if (contsal == 1) {
                            nuevacantidad27 = nuevacantidad27 - 8;
                            nuevocosto27 = nuevocosto27 - formula27;
                            bd.child("Sal").child("cantidad").setValue(nuevacantidad27);
                            bd.child("Sal").child("costo").setValue(nuevocosto27);
                            contsal = 2;
                        }
                        contsal = 1;

                        //Limon
                        if (contlimon == 0) {
                            cantidad28 = dataSnapshot.child("inventario").child("Limon").child("cantidad").getValue(Integer.class);
                            costo28 = dataSnapshot.child("inventario").child("Limon").child("costo").getValue(Integer.class);
                            formula28 = (15 * costo28) / cantidad28; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto28 = costo28 - formula28;
                            nuevacantidad28 = cantidad28 - 15;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);

                        }
                        if (contlimon == 1) {
                            nuevacantidad28 = nuevacantidad28 - 15;
                            nuevocosto28 = nuevocosto28 - formula28;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);
                            contlimon = 2;
                        }
                        contlimon = 1;


                        if (cont1==0) {
                            suma1 = formula37 + formula27 + formula28 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Michelada")) {
                        //cerveza
                        if (contcerveza == 0) {
                            cantidad37 = dataSnapshot.child("inventario").child("Cerveza").child("cantidad").getValue(Integer.class);
                            costo37 = dataSnapshot.child("inventario").child("Cerveza").child("costo").getValue(Integer.class);
                            formula37 = (500 * costo37) / cantidad37; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto37 = costo37 - formula37;
                            nuevacantidad37 = cantidad37 - 500;
                            bd.child("Cerveza").child("cantidad").setValue(nuevacantidad37);
                            bd.child("Cerveza").child("costo").setValue(nuevocosto37);

                        }
                        if (contcerveza == 1) {
                            nuevacantidad37 = nuevacantidad37 - 500;
                            nuevocosto37 = nuevocosto37 - formula37;
                            bd.child("Cerveza").child("cantidad").setValue(nuevacantidad37);
                            bd.child("Cerveza").child("costo").setValue(nuevocosto37);
                            contcerveza = 2;
                        }
                        contcerveza = 1;


                        //Sal
                        if (contsal == 0) {
                            cantidad27 = dataSnapshot.child("inventario").child("Sal").child("cantidad").getValue(Integer.class);
                            costo27 = dataSnapshot.child("inventario").child("Sal").child("costo").getValue(Integer.class);
                            formula27 = (8 * costo27) / cantidad27; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto27 = costo27 - formula27;
                            nuevacantidad27 = cantidad27 - 8;
                            bd.child("Sal").child("cantidad").setValue(nuevacantidad27);
                            bd.child("Sal").child("costo").setValue(nuevocosto27);

                        }
                        if (contsal == 1) {
                            nuevacantidad27 = nuevacantidad27 - 8;
                            nuevocosto27 = nuevocosto27 - formula27;
                            bd.child("Sal").child("cantidad").setValue(nuevacantidad27);
                            bd.child("Sal").child("costo").setValue(nuevocosto27);
                            contsal = 2;
                        }
                        contsal = 1;

                        //Limon
                        if (contlimon == 0) {
                            cantidad28 = dataSnapshot.child("inventario").child("Limon").child("cantidad").getValue(Integer.class);
                            costo28 = dataSnapshot.child("inventario").child("Limon").child("costo").getValue(Integer.class);
                            formula28 = (15 * costo28) / cantidad28; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto28 = costo28 - formula28;
                            nuevacantidad28 = cantidad28 - 15;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);

                        }
                        if (contlimon == 1) {
                            nuevacantidad28 = nuevacantidad28 - 15;
                            nuevocosto28 = nuevocosto28 - formula28;
                            bd.child("Limon").child("cantidad").setValue(nuevacantidad28);
                            bd.child("Limon").child("costo").setValue(nuevocosto28);
                            contlimon = 2;
                        }
                        contlimon = 1;

                        //Clamato
                        if (contclamato == 0) {
                            cantidad38 = dataSnapshot.child("inventario").child("Clamato").child("cantidad").getValue(Integer.class);
                            costo38 = dataSnapshot.child("inventario").child("Clamato").child("costo").getValue(Integer.class);
                            formula38 = (250 * costo38) / cantidad38; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto38 = costo38 - formula38;
                            nuevacantidad38 = cantidad38 - 250;
                            bd.child("Clamato").child("cantidad").setValue(nuevacantidad38);
                            bd.child("Clamato").child("costo").setValue(nuevocosto38);

                        }
                        if (contclamato == 1) {
                            nuevacantidad38 = nuevacantidad38 - 250;
                            nuevocosto38 = nuevocosto38 - formula38;
                            bd.child("Clamato").child("cantidad").setValue(nuevacantidad38);
                            bd.child("Clamato").child("costo").setValue(nuevocosto38);
                            contclamato = 2;
                        }
                        contclamato = 1;


                        if (cont1==0) {
                            suma1 = formula37 + formula27 + formula28 + formula38 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Piña colada")) {
                        //Ron
                        if (contron == 0) {
                            cantidad32 = dataSnapshot.child("inventario").child("Ron").child("cantidad").getValue(Integer.class);
                            costo32 = dataSnapshot.child("inventario").child("Ron").child("costo").getValue(Integer.class);
                            formula32 = (250 * costo32) / cantidad32; //250 es la cantidad de mililitros que se utilizará de ron
                            nuevocosto32 = costo32 - formula32;
                            nuevacantidad32 = cantidad32 - 250;
                            bd.child("Ron").child("cantidad").setValue(nuevacantidad32);
                            bd.child("Ron").child("costo").setValue(nuevocosto32);

                        }
                        if (contron == 1) {
                            nuevacantidad32 = nuevacantidad32 - 250;
                            nuevocosto32 = nuevocosto32 - formula32;
                            bd.child("Ron").child("cantidad").setValue(nuevacantidad32);
                            bd.child("Ron").child("costo").setValue(nuevocosto32);
                            contron = 2;
                        }
                        contron = 1;


                        //Crema de coco
                        if (contcremcoco == 0) {
                            cantidad40 = dataSnapshot.child("inventario").child("Crema de coco").child("cantidad").getValue(Integer.class);
                            costo40 = dataSnapshot.child("inventario").child("Crema de coco").child("costo").getValue(Integer.class);
                            formula40 = (50 * costo40) / cantidad40; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto40 = costo40 - formula40;
                            nuevacantidad40 = cantidad40 - 50;
                            bd.child("Crema de coco").child("cantidad").setValue(nuevacantidad40);
                            bd.child("Crema de coco").child("costo").setValue(nuevocosto40);

                        }
                        if (contcremcoco == 1) {
                            nuevacantidad40 = nuevacantidad40 - 50;
                            nuevocosto40 = nuevocosto40 - formula40;
                            bd.child("Crema de coco").child("cantidad").setValue(nuevacantidad40);
                            bd.child("Crema de coco").child("costo").setValue(nuevocosto40);
                            contcremcoco = 2;
                        }
                        contcremcoco = 1;

                        //Jugo de piña
                        if (contjpina == 0) {
                            cantidad41 = dataSnapshot.child("inventario").child("Juego de pina").child("cantidad").getValue(Integer.class);
                            costo41 = dataSnapshot.child("inventario").child("Jugo de pina").child("costo").getValue(Integer.class);
                            formula41 = (500 * costo41) / cantidad41; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto41 = costo41 - formula41;
                            nuevacantidad41 = cantidad41 - 500;
                            bd.child("Jugo de pina").child("cantidad").setValue(nuevacantidad41);
                            bd.child("Jugo de pina").child("costo").setValue(nuevocosto41);

                        }
                        if (contjpina == 1) {
                            nuevacantidad41 = nuevacantidad41 - 500;
                            nuevocosto41 = nuevocosto41 - formula41;
                            bd.child("Jugo de pina").child("cantidad").setValue(nuevacantidad41);
                            bd.child("Jugo de pina").child("costo").setValue(nuevocosto41);
                            contjpina = 2;
                        }
                        contjpina = 1;



                        if (cont1==0) {
                            suma1 = formula32 + formula41 + formula40 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }

                    //late
                    if (titulo.equals("Latte tradicional")) {
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;
                        //Canela
                        if (contcanela == 0) {
                            cantidad9 = dataSnapshot.child("inventario").child("Canela").child("cantidad").getValue(Integer.class);
                            costo9 = dataSnapshot.child("inventario").child("Canela").child("costo").getValue(Integer.class);
                            formula9 = (25 * costo9) / cantidad9; //25 es la cantidad en gramos que se utilizara de canela
                            nuevocosto9 = costo9 - formula9;
                            nuevacantidad9 = cantidad9 - 25;
                            bd.child("Canela").child("cantidad").setValue(nuevacantidad9);
                            bd.child("Canela").child("costo").setValue(nuevocosto9);

                        }
                        if (contcanela == 1) {
                            nuevacantidad9 = nuevacantidad9 - 25;
                            nuevocosto9 = nuevocosto9 - formula9;
                            bd.child("Canela").child("cantidad").setValue(nuevacantidad9);
                            bd.child("Canela").child("costo").setValue(nuevocosto9);
                            contcanela = 2;
                        }
                        contcanela = 1;
                        //Nata
                        if (contnata == 0) {
                            cantidad10 = dataSnapshot.child("inventario").child("Nata").child("cantidad").getValue(Integer.class);
                            costo10 = dataSnapshot.child("inventario").child("Nata").child("costo").getValue(Integer.class);
                            formula10 = (20 * costo10) / cantidad10; //20 es la cantidad en gramos que se utilizara de nata
                            nuevocosto10 = costo10 - formula10;
                            nuevacantidad10 = cantidad10 - 20;
                            bd.child("Nata").child("cantidad").setValue(nuevacantidad10);
                            bd.child("Nata").child("costo").setValue(nuevocosto10);

                        }
                        if (contnata == 1) {
                            nuevacantidad10 = nuevacantidad10 - 20;
                            nuevocosto10 = nuevocosto10- formula10;
                            bd.child("Nata").child("cantidad").setValue(nuevacantidad10);
                            bd.child("Nata").child("costo").setValue(nuevocosto10);
                            contnata = 2;
                        }
                        contnata = 1;



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula9 + formula10;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Latte moka")) {
                        /////late moka
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //cacao
                        if (contcacao == 0) {
                            cantidad11 = dataSnapshot.child("inventario").child("Cacao").child("cantidad").getValue(Integer.class);
                            costo11 = dataSnapshot.child("inventario").child("Cacao").child("costo").getValue(Integer.class);
                            formula11 = (20 * costo11) / cantidad11; //20 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto11 = costo11 - formula11;
                            nuevacantidad11 = cantidad11 - 20;
                            bd.child("Cacao").child("cantidad").setValue(nuevacantidad11);
                            bd.child("Cacao").child("costo").setValue(nuevocosto11);

                        }
                        if (contcacao == 1) {
                            nuevacantidad11 = nuevacantidad11 - 20;
                            nuevocosto11 = nuevocosto11- formula11;
                            bd.child("Cacao").child("cantidad").setValue(nuevacantidad11);
                            bd.child("Cacao").child("costo").setValue(nuevocosto11);
                            contcacao = 2;
                        }
                        contcacao = 1;



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula11;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }
                    if (titulo.equals("Latte vainilla Francesa")) {
                        /////late vainilla
                        if (contcafe == 0) {
                            cantidad4 = dataSnapshot.child("inventario").child("Cafe").child("cantidad").getValue(Integer.class);
                            costo4 = dataSnapshot.child("inventario").child("Cafe").child("costo").getValue(Integer.class);
                            formula4 = (8 * costo4) / cantidad4; //8 es la cantidad en gramos que se utilizará de cafe
                            nuevocosto4 = costo4 - formula4;
                            nuevacantidad4 = cantidad4 - 8;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);

                        }
                        if (contcafe == 1) {
                            nuevacantidad4 = nuevacantidad4 - 8;
                            nuevocosto4 = nuevocosto4 - formula4;
                            bd.child("Cafe").child("cantidad").setValue(nuevacantidad4);
                            bd.child("Cafe").child("costo").setValue(nuevocosto4);
                            contcafe = 2;
                        }
                        contcafe = 1;


                        //Azucar
                        if (contazucar == 0) {
                            cantidad5 = dataSnapshot.child("inventario").child("Azucar").child("cantidad").getValue(Integer.class);
                            costo5 = dataSnapshot.child("inventario").child("Azucar").child("costo").getValue(Integer.class);
                            formula5 = (8 * costo5) / cantidad5; //8 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto5 = costo5 - formula5;
                            nuevacantidad5 = cantidad5 - 8;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);

                        }
                        if (contazucar == 1) {
                            nuevacantidad5 = nuevacantidad5 - 8;
                            nuevocosto5 = nuevocosto5 - formula5;
                            bd.child("Azucar").child("cantidad").setValue(nuevacantidad5);
                            bd.child("Azucar").child("costo").setValue(nuevocosto5);
                            contazucar = 2;
                        }
                        contazucar = 1;

                        //Leche
                        if (contleche == 0) {
                            cantidad6 = dataSnapshot.child("inventario").child("Leche").child("cantidad").getValue(Integer.class);
                            costo6 = dataSnapshot.child("inventario").child("Leche").child("costo").getValue(Integer.class);
                            formula6 = (240 * costo6) / cantidad6; //240 es la cantidad en mililitros que se utilizará de leche
                            nuevocosto6 = costo6 - formula6;
                            nuevacantidad6 = cantidad6 - 240;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);

                        }
                        if (contleche == 1) {
                            nuevacantidad6 = nuevacantidad6 - 240;
                            nuevocosto6 = nuevocosto6 - formula6;
                            bd.child("Leche").child("cantidad").setValue(nuevacantidad6);
                            bd.child("Leche").child("costo").setValue(nuevocosto6);
                            contleche = 2;
                        }
                        contleche = 1;

                        //vainilla
                        if (contvainilla == 0) {
                            cantidad12 = dataSnapshot.child("inventario").child("Vainilla").child("cantidad").getValue(Integer.class);
                            costo12 = dataSnapshot.child("inventario").child("Vainilla").child("costo").getValue(Integer.class);
                            formula12 = (10 * costo12) / cantidad12; //20 es la cantidad en militros que se utilizara de vainilla
                            nuevocosto12 = costo12 - formula12;
                            nuevacantidad12 = cantidad12 - 10;
                            bd.child("Vainilla").child("cantidad").setValue(nuevacantidad12);
                            bd.child("Vainilla").child("costo").setValue(nuevocosto12);

                        }
                        if (contvainilla == 1) {
                            nuevacantidad12 = nuevacantidad12 - 10;
                            nuevocosto12 = nuevocosto12- formula12;
                            bd.child("Vainilla").child("cantidad").setValue(nuevacantidad12);
                            bd.child("Vainilla").child("costo").setValue(nuevocosto12);
                            contvainilla = 2;
                        }
                        contvainilla = 1;



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula12;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }


                    contganancia = ganancia0+ganancia1+ganancia2+ganancia3+ganancia4+ganancia5+ganancia6+ganancia7+ganancia8+ganancia9+ganancia10+ganancia11+ganancia12;
                    //Fecha

                    SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");
                    String fechaComoCadena = sdf.format(new Date());
                    String[] parts = fechaComoCadena.split(" ");
                    final String fecha = parts[0];
                    final String fechastring = fecha;// 123

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.child("ganancias").child(fecha).child("ganancia").getValue(Integer.class) == null) {

                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("ganancias").child(fecha);
                                ref.child("ganancia").setValue(contganancia);


                            } else {
                                ganancia = dataSnapshot.child("ganancias").child(fecha).child("ganancia").getValue(Integer.class);
                                venta = dataSnapshot.child("ganancias").child(fecha).child("venta").getValue(Integer.class);
                                ganancia = contganancia + ganancia;
                                venta = contventa + venta;
                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("ganancias").child(fecha);
                                ref.child("ganancia").setValue(ganancia);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                db.delete(Utilidades.TABLA_ORDEN, null, null);
                db.close();
                //Conteo productos
                SharedPreferences preferences = getSharedPreferences("contadores", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("cont", cont);
                editor.apply();
                Intent intent = new Intent(Cuenta.this, cuenta2.class);
                startActivityForResult(intent, 0);


            }

            private void CrearPedido() {
                //Fecha

                SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");
                String fechaComoCadena = sdf.format(new Date());
                String[] parts = fechaComoCadena.split(" ");
                final String fecha = parts[0];
                final String fechastring = fecha;// 123

                DatabaseReference messageReference = database.getReference().child("productos").push();
                String id = messageReference.getKey();
                messageReference.child("id").setValue(id);
                messageReference.child("idp").setValue(idp);
                messageReference.child("mesa").setValue(mesaseleccionada);
                messageReference.child("producto numero").setValue(contConvertido);
                messageReference.child("producto").setValue(titulo);
                messageReference.child("estado").setValue("En cocina");
                messageReference.child("fecha").setValue(fechaComoCadena);

                //Ventas y ganancias

                final DatabaseReference bdd = database.getReference().child("ventas").push();
                bdd.child("idp").setValue(idp);
                bdd.child("producto").setValue(titulo);
                bdd.child("precio").setValue(precio);
                bdd.child("fecha").setValue(fechaComoCadena);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void seguircomprando() {
        Intent intent = new Intent(Cuenta.this, Cliente.class);
        startActivityForResult(intent, 0);
    }


}





