package com.example.alejandro.fastcoffee.utilidades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.entidades.Ordenes;
import com.example.alejandro.fastcoffee.entidades.Ordenes2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.alejandro.fastcoffee.tiempodeespera;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class cuenta2 extends AppCompatActivity {

    ListView listViewOrden;
    ArrayList<String> listaInformacion;
    ArrayList<Ordenes> listaOrden;
    ConexionSQLiteHelper conn;
    TextView preciototal;
    Button btnterminarorden, seguircomprando;
    int valortotal, cont, contpedidos, ganancia, contganancia, contventa, venta, precio, ganantotal;
    int idp;
    int gananciaproducto;
    int gananciatotal;
    String mesaseleccionada, contConvertido, titulo, preciostring;
    String titulos;
    String[] partes;
    int a=0, contalitas=0,contcafe=0;
    int ganancia0=0, ganancia1=0, ganancia2=0, ganancia3=0, ganancia4=0, ganancia5=0, ganancia6=0, ganancia7=0, ganancia8=0, ganancia9=0, ganancia10=0, ganancia11=0, ganancia12=0;
    int gananciaa0=0, gananciaa1=0, gananciaa2=0, gananciaa3=0, gananciaa4=0, gananciaa5=0, gananciaa6=0, gananciaa7=0, gananciaa8=0, gananciaa9=0, gananciaa10=0, gananciaa11=0, gananciaa12=0;
    int suma0=0,suma1=0,suma2=0,suma3=0,suma4=0,suma5=0,suma6=0,suma7=0,suma8=0,suma9=0,suma10=0,suma11=0,suma12=0;
    int cont0=0,cont1=0,cont2=0,cont3=0,cont4=0,cont5=0,cont6=0,cont7=0,cont8=0,cont9=0,cont10=0,cont11=0,cont12=0;
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
        setContentView(R.layout.activity_cuenta2);
        preciototal = (TextView) findViewById(R.id.txtTotal);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_orden2", null, 1);
        listViewOrden = findViewById(R.id.lvorden2);

        SharedPreferences pref = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        mesaseleccionada = pref.getString("mesa", "");

        idp = pref.getInt("idp", 0);

        database = FirebaseDatabase.getInstance();

        consultarOrden();


        LlenarEnFirebase();
    }


    private void consultarOrden() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Ordenes orden = null;
        listaOrden = new ArrayList<Ordenes>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_ORDEN2, null);

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

    private void LlenarEnFirebase() {

        final DatabaseReference invent = FirebaseDatabase.getInstance().getReference();
        invent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                DatabaseReference bd = FirebaseDatabase.getInstance().getReference().child("inventario");
                DatabaseReference general = FirebaseDatabase.getInstance().getReference();
                //Fecha

                SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");
                String fechaComoCadena = sdf.format(new Date());
                String[] parts = fechaComoCadena.split(" ");
                final String fecha = parts[0];
                final String fechastring = fecha;// 123


                //Ciclo para recuperar los productos que estan en sqlite y llenarlo en firebase

                final SQLiteDatabase db = conn.getReadableDatabase();
                Ordenes orden = null;
                listaOrden = new ArrayList<Ordenes>();
                Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_ORDEN2, null);
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
                    contventa = precio + contventa;




                    if (titulo.equals("Alitas sabor BBQ")) {

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


                        //Salsa BBQ
                        if (contBBQ == 0) {
                            cantidad1 = dataSnapshot.child("inventario").child("Salsa BBQ").child("cantidad").getValue(Integer.class);
                            costo1 = dataSnapshot.child("inventario").child("Salsa BBQ").child("costo").getValue(Integer.class);
                            formula1 = (500 * costo1) / cantidad1; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto1 = costo1 - formula1;
                            nuevacantidad1 = cantidad1 - 500;
                            bd.child("Salsa BBQ").child("cantidad").setValue(nuevacantidad1);
                            bd.child("Salsa BBQ").child("costo").setValue(nuevocosto1);

                        }
                        if (contBBQ == 1) {
                            nuevacantidad1 = nuevacantidad1 - 500;
                            nuevocosto1 = nuevocosto1 - formula1;
                            bd.child("Salsa BBQ").child("cantidad").setValue(nuevacantidad1);
                            bd.child("Salsa BBQ").child("costo").setValue(nuevocosto1);
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
                            ganancia0 = ganancia0 + ganancia0;
                            cont0=2;
                        }
                        cont0=1;
                    }
                    if (titulo.equals("Latte crema Irlandesa")) {
                        /////latte crema
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



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula13;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }
                    if (titulo.equals("Latte caramelo")) {
                        /////latte caramelo
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



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula14;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }
                    if (titulo.equals("Latte Tiramisu")) {
                        /////Latte tiramisu
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



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula15;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }
                    if (titulo.equals("Latte Rompope Italiano")) {
                        /////Latte Rompope
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



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula16;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }
                    if (titulo.equals("Latte cajeta")) {
                        /////Latte cajeta
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



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula17;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }
                    if (titulo.equals("Latte amaretto")) {
                        /////Latte amaretto
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



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula18;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }
                    if (titulo.equals("Latte chocolate Macadamia")) {
                        /////Latte macadamia
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



                        if (cont1==0) {
                            suma1 = formula4 + formula5 + formula6 + formula19;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;

                    }

                    //otros
                    if (titulo.equals("Refrescos")) {
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

                        if (cont1==0) {
                            suma1 = formula26;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Agua")) {
                        if (contagua == 0) {
                            cantidad39 = dataSnapshot.child("inventario").child("Agua").child("cantidad").getValue(Integer.class);
                            costo39 = dataSnapshot.child("inventario").child("Agua").child("costo").getValue(Integer.class);
                            formula39 = (500 * costo39) / cantidad39; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto39 = costo39 - formula39;
                            nuevacantidad39 = cantidad39 - 500;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad39);
                            bd.child("Agua").child("costo").setValue(nuevocosto39);

                        }
                        if (contagua == 1) {
                            nuevacantidad39 = nuevacantidad39 - 500;
                            nuevocosto39 = nuevocosto39 - formula39;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad39);
                            bd.child("Agua" +
                                    "").child("costo").setValue(nuevocosto39);
                            contagua = 2;
                        }
                        contagua = 1;

                        if (cont1==0) {
                            suma1 = formula39;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Cerveza")) {
                        //cerveza
                        if (contcerveza == 0) {
                            cantidad37 = dataSnapshot.child("inventario").child("Cerveza").child("cantidad").getValue(Integer.class);
                            costo37 = dataSnapshot.child("inventario").child("Cerveza").child("costo").getValue(Integer.class);
                            formula37 = (350 * costo37) / cantidad37; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto37 = costo37 - formula37;
                            nuevacantidad37 = cantidad37 - 350;
                            bd.child("Cerveza").child("cantidad").setValue(nuevacantidad37);
                            bd.child("Cerveza").child("costo").setValue(nuevocosto37);

                        }
                        if (contcerveza == 1) {
                            nuevacantidad37 = nuevacantidad37 - 350;
                            nuevocosto37 = nuevocosto37 - formula37;
                            bd.child("Cerveza").child("cantidad").setValue(nuevacantidad37);
                            bd.child("Cerveza").child("costo").setValue(nuevocosto37);
                            contcerveza = 2;
                        }
                        contcerveza = 1;


                        if (cont1==0) {
                            suma1 = formula37;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Cubeta c/10 cervezas")) {
                        //cerveza
                        if (contcerveza == 0) {
                            cantidad37 = dataSnapshot.child("inventario").child("Cerveza").child("cantidad").getValue(Integer.class);
                            costo37 = dataSnapshot.child("inventario").child("Cerveza").child("costo").getValue(Integer.class);
                            formula37 = (3500 * costo37) / cantidad37; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto37 = costo37 - formula37;
                            nuevacantidad37 = cantidad37 - 3500;
                            bd.child("Cerveza").child("cantidad").setValue(nuevacantidad37);
                            bd.child("Cerveza").child("costo").setValue(nuevocosto37);

                        }
                        if (contcerveza == 1) {
                            nuevacantidad37 = nuevacantidad37 - 3500;
                            nuevocosto37 = nuevocosto37 - formula37;
                            bd.child("Cerveza").child("cantidad").setValue(nuevacantidad37);
                            bd.child("Cerveza").child("costo").setValue(nuevocosto37);
                            contcerveza = 2;
                        }
                        contcerveza = 1;


                        if (cont1==0) {
                            suma1 = formula37;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Copa de vino")) {
                        //Vino tinto
                        if (contvinot == 0) {
                            cantidad33 = dataSnapshot.child("inventario").child("Vino tinto").child("cantidad").getValue(Integer.class);
                            costo33 = dataSnapshot.child("inventario").child("Vino tinto").child("costo").getValue(Integer.class);
                            formula33 = (250 * costo33) / cantidad33; //250 es la cantidad de mililitros que se utilizará de ron
                            nuevocosto33 = costo33 - formula33;
                            nuevacantidad33 = cantidad33 - 250;
                            bd.child("Vino tinto").child("cantidad").setValue(nuevacantidad33);
                            bd.child("Vino tinto").child("costo").setValue(nuevocosto33);

                        }
                        if (contvinot == 1) {
                            nuevacantidad33 = nuevacantidad33 - 250;
                            nuevocosto33 = nuevocosto33 - formula33;
                            bd.child("Vino tinto").child("cantidad").setValue(nuevacantidad33);
                            bd.child("Vino tinto").child("costo").setValue(nuevocosto33);
                            contvinot = 2;
                        }
                        contvinot = 1;


                        if (cont1==0) {
                            suma1 = formula33;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Botella de vino")) {
                        if (contvinot == 0) {
                            cantidad33 = dataSnapshot.child("inventario").child("Vino tinto").child("cantidad").getValue(Integer.class);
                            costo33 = dataSnapshot.child("inventario").child("Vino tinto").child("costo").getValue(Integer.class);
                            formula33 = (750 * costo33) / cantidad33; //250 es la cantidad de mililitros que se utilizará de ron
                            nuevocosto33 = costo33 - formula33;
                            nuevacantidad33 = cantidad33 - 750;
                            bd.child("Vino tinto").child("cantidad").setValue(nuevacantidad33);
                            bd.child("Vino tinto").child("costo").setValue(nuevocosto33);

                        }
                        if (contvinot == 1) {
                            nuevacantidad33 = nuevacantidad33 - 750;
                            nuevocosto33 = nuevocosto33 - formula33;
                            bd.child("Vino tinto").child("cantidad").setValue(nuevacantidad33);
                            bd.child("Vino tinto").child("costo").setValue(nuevocosto33);
                            contvinot = 2;
                        }
                        contvinot = 1;


                        if (cont1==0) {
                            suma1 = formula33;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }

                    //Smoothies
                    if (titulo.equals("Smoothie de fresa")) {
                        if (contagua == 0) {
                            cantidad39 = dataSnapshot.child("inventario").child("Agua").child("cantidad").getValue(Integer.class);
                            costo39 = dataSnapshot.child("inventario").child("Agua").child("costo").getValue(Integer.class);
                            formula39 = (500 * costo39) / cantidad39; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto39 = costo39 - formula39;
                            nuevacantidad39 = cantidad39 - 500;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad39);
                            bd.child("Agua").child("costo").setValue(nuevocosto39);

                        }
                        if (contagua == 1) {
                            nuevacantidad39 = nuevacantidad39 - 500;
                            nuevocosto39 = nuevocosto39 - formula39;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad39);
                            bd.child("Agua" +
                                    "").child("costo").setValue(nuevocosto39);
                            contagua = 2;
                        }
                        contagua = 1;

                        ///fresa
                        if (contfresa == 0) {
                            cantidad42 = dataSnapshot.child("inventario").child("Fresa").child("cantidad").getValue(Integer.class);
                            costo42 = dataSnapshot.child("inventario").child("Fresa").child("costo").getValue(Integer.class);
                            formula42 = (25 * costo42) / cantidad42; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto42 = costo42 - formula42;
                            nuevacantidad42 = cantidad42 - 25;
                            bd.child("Fresa").child("cantidad").setValue(nuevacantidad42);
                            bd.child("Fresa").child("costo").setValue(nuevocosto42);

                        }
                        if (contfresa == 1) {
                            nuevacantidad42 = nuevacantidad42 - 25;
                            nuevocosto42 = nuevocosto42 - formula42;
                            bd.child("Fresa").child("cantidad").setValue(nuevacantidad42);
                            bd.child("Fresa").child("costo").setValue(nuevocosto42);
                            contfresa = 2;
                        }
                        contfresa = 1;

                        if (cont1==0) {
                            suma1 = formula39 + formula42;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Smoothie de moras")) {
                        if (contagua == 0) {
                            cantidad39 = dataSnapshot.child("inventario").child("Agua").child("cantidad").getValue(Integer.class);
                            costo39 = dataSnapshot.child("inventario").child("Agua").child("costo").getValue(Integer.class);
                            formula39 = (500 * costo39) / cantidad39; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto39 = costo39 - formula39;
                            nuevacantidad39 = cantidad39 - 500;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad39);
                            bd.child("Agua").child("costo").setValue(nuevocosto39);

                        }
                        if (contagua == 1) {
                            nuevacantidad39 = nuevacantidad39 - 500;
                            nuevocosto39 = nuevocosto39 - formula39;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad39);
                            bd.child("Agua" +
                                    "").child("costo").setValue(nuevocosto39);
                            contagua = 2;
                        }
                        contagua = 1;

                        ///moras
                        if (contmoras == 0) {
                            cantidad43 = dataSnapshot.child("inventario").child("Moras").child("cantidad").getValue(Integer.class);
                            costo43 = dataSnapshot.child("inventario").child("Moras").child("costo").getValue(Integer.class);
                            formula43 = (25 * costo43) / cantidad43; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto43 = costo43 - formula43;
                            nuevacantidad43 = cantidad43 - 25;
                            bd.child("Moras").child("cantidad").setValue(nuevacantidad43);
                            bd.child("Moras").child("costo").setValue(nuevocosto43);

                        }
                        if (contmoras == 1) {
                            nuevacantidad43 = nuevacantidad43 - 25;
                            nuevocosto43 = nuevocosto43 - formula43;
                            bd.child("Moras").child("cantidad").setValue(nuevacantidad43);
                            bd.child("Moras").child("costo").setValue(nuevocosto43);
                            contmoras = 2;
                        }
                        contmoras = 1;

                        if (cont1==0) {
                            suma1 = formula39 + formula43;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Smoothie de mango")) {
                        if (contagua == 0) {
                            cantidad39 = dataSnapshot.child("inventario").child("Agua").child("cantidad").getValue(Integer.class);
                            costo39 = dataSnapshot.child("inventario").child("Agua").child("costo").getValue(Integer.class);
                            formula39 = (500 * costo39) / cantidad39; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto39 = costo39 - formula39;
                            nuevacantidad39 = cantidad39 - 500;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad39);
                            bd.child("Agua").child("costo").setValue(nuevocosto39);

                        }
                        if (contagua == 1) {
                            nuevacantidad39 = nuevacantidad39 - 500;
                            nuevocosto39 = nuevocosto39 - formula39;
                            bd.child("Agua").child("cantidad").setValue(nuevacantidad39);
                            bd.child("Agua" +
                                    "").child("costo").setValue(nuevocosto39);
                            contagua = 2;
                        }
                        contagua = 1;

                        ///mango
                        if (contmango == 0) {
                            cantidad44 = dataSnapshot.child("inventario").child("Mango").child("cantidad").getValue(Integer.class);
                            costo44 = dataSnapshot.child("inventario").child("Mango").child("costo").getValue(Integer.class);
                            formula44 = (25 * costo44) / cantidad44; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto44 = costo44 - formula44;
                            nuevacantidad44 = cantidad44 - 25;
                            bd.child("Mango").child("cantidad").setValue(nuevacantidad44);
                            bd.child("Mango").child("costo").setValue(nuevocosto44);

                        }
                        if (contmango == 1) {
                            nuevacantidad44 = nuevacantidad44 - 25;
                            nuevocosto44 = nuevocosto44 - formula44;
                            bd.child("Mango").child("cantidad").setValue(nuevacantidad44);
                            bd.child("Mango").child("costo").setValue(nuevocosto44);
                            contmango = 2;
                        }
                        contmango = 1;

                        if (cont1==0) {
                            suma1 = formula39 + formula44;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }

                    //Sodas Italianas
                    if (titulo.equals("Soda Italiana de manzana verde")) {
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

                        //jarabe de manzana
                        if (contjmanzana == 0) {
                            cantidad44 = dataSnapshot.child("inventario").child("Jarabe de manzana").child("cantidad").getValue(Integer.class);
                            costo44 = dataSnapshot.child("inventario").child("Jarabe de manzana").child("costo").getValue(Integer.class);
                            formula44 = (30 * costo44) / cantidad44; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto44 = costo44 - formula44;
                            nuevacantidad44 = cantidad44 - 30;
                            bd.child("Jarabe de manzana").child("cantidad").setValue(nuevacantidad44);
                            bd.child("Jarabe de manzana").child("costo").setValue(nuevocosto44);

                        }
                        if (contjmanzana == 1) {
                            nuevacantidad44 = nuevacantidad44 - 30;
                            nuevocosto44 = nuevocosto44 - formula44;
                            bd.child("Jarabe de manzana").child("cantidad").setValue(nuevacantidad44);
                            bd.child("Jarabe de manzana").child("costo").setValue(nuevocosto44);
                            contjmanzana = 2;
                        }
                        contjmanzana = 1;


                        if (cont1==0) {
                            suma1 = formula29 + formula44 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Soda Italiana de fruta de la pasión")) {
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

                        //jarabe de maracuya
                        if (contjmaracuya == 0) {
                            cantidad45 = dataSnapshot.child("inventario").child("Jarabe de maracuya").child("cantidad").getValue(Integer.class);
                            costo45 = dataSnapshot.child("inventario").child("Jarabe de maracuya").child("costo").getValue(Integer.class);
                            formula45 = (30 * costo45) / cantidad45; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto45 = costo45 - formula45;
                            nuevacantidad45 = cantidad45 - 30;
                            bd.child("Jarabe de maracuya").child("cantidad").setValue(nuevacantidad45);
                            bd.child("Jarabe de maracuya").child("costo").setValue(nuevocosto45);

                        }
                        if (contjmaracuya == 1) {
                            nuevacantidad45 = nuevacantidad45 - 30;
                            nuevocosto45 = nuevocosto45 - formula45;
                            bd.child("Jarabe de maracuya").child("cantidad").setValue(nuevacantidad45);
                            bd.child("Jarabe de maracuya").child("costo").setValue(nuevocosto45);
                            contjmaracuya = 2;
                        }
                        contjmaracuya = 1;


                        if (cont1==0) {
                            suma1 = formula29 + formula45 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Soda Italiana de mango")) {
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

                        //jarabe de mango
                        if (contjmango == 0) {
                            cantidad46 = dataSnapshot.child("inventario").child("Jarabe de mango").child("cantidad").getValue(Integer.class);
                            costo46 = dataSnapshot.child("inventario").child("Jarabe de mango").child("costo").getValue(Integer.class);
                            formula46 = (30 * costo46) / cantidad46; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto46 = costo46 - formula46;
                            nuevacantidad46 = cantidad46 - 30;
                            bd.child("Jarabe de mango").child("cantidad").setValue(nuevacantidad46);
                            bd.child("Jarabe de mango").child("costo").setValue(nuevocosto46);

                        }
                        if (contjmango == 1) {
                            nuevacantidad46 = nuevacantidad46 - 30;
                            nuevocosto46 = nuevocosto46 - formula46;
                            bd.child("Jarabe de mango").child("cantidad").setValue(nuevacantidad46);
                            bd.child("Jarabe de mango").child("costo").setValue(nuevocosto46);
                            contjmango = 2;
                        }
                        contjmango = 1;


                        if (cont1==0) {
                            suma1 = formula29 + formula46 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }

                    //Crepa salada
                    if (titulo.equals("Crepa Napolitana")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //Salami
                        if (contsalami == 0) {
                            cantidad48 = dataSnapshot.child("inventario").child("Salami").child("cantidad").getValue(Integer.class);
                            costo48 = dataSnapshot.child("inventario").child("Salami").child("costo").getValue(Integer.class);
                            formula48= (20 * costo48) / cantidad48; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto48 = costo48 - formula48;
                            nuevacantidad48 = cantidad48 - 20;
                            bd.child("Salami").child("cantidad").setValue(nuevacantidad48);
                            bd.child("Salami").child("costo").setValue(nuevocosto48);

                        }
                        if (contsalami == 1) {
                            nuevacantidad48 = nuevacantidad48 - 20;
                            nuevocosto48 = nuevocosto48 - formula48;
                            bd.child("Salami").child("cantidad").setValue(nuevacantidad48);
                            bd.child("Salami").child("costo").setValue(nuevocosto48);
                            contsalami = 2;
                        }
                        contsalami = 1;

                        //peperoni
                        if (contpeperoni == 0) {
                            cantidad49 = dataSnapshot.child("inventario").child("Peperoni").child("cantidad").getValue(Integer.class);
                            costo49 = dataSnapshot.child("inventario").child("Peperoni").child("costo").getValue(Integer.class);
                            formula49= (20 * costo49) / cantidad49; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto49 = costo49 - formula49;
                            nuevacantidad49 = cantidad49 - 20;
                            bd.child("Peperoni").child("cantidad").setValue(nuevacantidad49);
                            bd.child("Peperoni").child("costo").setValue(nuevocosto49);

                        }
                        if (contpeperoni == 1) {
                            nuevacantidad49 = nuevacantidad49 - 20;
                            nuevocosto49 = nuevocosto49 - formula49;
                            bd.child("Peperoni").child("cantidad").setValue(nuevacantidad49);
                            bd.child("Peperoni").child("costo").setValue(nuevocosto49);
                            contpeperoni = 2;
                        }
                        contpeperoni = 1;

                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula48 + formula49 + formula50 + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Tres Quesos")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;



                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula50 + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Hawaiana")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //jamon
                        if (contjamon == 0) {
                            cantidad52 = dataSnapshot.child("inventario").child("Jamon").child("cantidad").getValue(Integer.class);
                            costo52 = dataSnapshot.child("inventario").child("Jamon").child("costo").getValue(Integer.class);
                            formula52= (20 * costo52) / cantidad52; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto52 = costo52 - formula52;
                            nuevacantidad52 = cantidad52 - 20;
                            bd.child("Jamon").child("cantidad").setValue(nuevacantidad52);
                            bd.child("Jamon").child("costo").setValue(nuevocosto52);

                        }
                        if (contjamon == 1) {
                            nuevacantidad52 = nuevacantidad52 - 20;
                            nuevocosto52 = nuevocosto52 - formula52;
                            bd.child("Jamon").child("cantidad").setValue(nuevacantidad52);
                            bd.child("Jamon").child("costo").setValue(nuevocosto52);
                            contjamon = 2;
                        }
                        contjamon = 1;

                        //pina
                        if (contpina == 0) {
                            cantidad53 = dataSnapshot.child("inventario").child("Piña").child("cantidad").getValue(Integer.class);
                            costo53 = dataSnapshot.child("inventario").child("Piña").child("costo").getValue(Integer.class);
                            formula53= (20 * costo53) / cantidad53; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto53 = costo53 - formula53;
                            nuevacantidad53 = cantidad53 - 20;
                            bd.child("Piña").child("cantidad").setValue(nuevacantidad53);
                            bd.child("Piña").child("costo").setValue(nuevocosto53);

                        }
                        if (contpina == 1) {
                            nuevacantidad53 = nuevacantidad53 - 20;
                            nuevocosto53 = nuevocosto53 - formula53;
                            bd.child("Piña").child("cantidad").setValue(nuevacantidad53);
                            bd.child("Piña").child("costo").setValue(nuevocosto53);
                            contpina = 2;
                        }
                        contpina = 1;

                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula52 + formula53 + formula50 + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Vegetariana")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //panela
                        if (contpanela == 0) {
                            cantidad54 = dataSnapshot.child("inventario").child("Panela").child("cantidad").getValue(Integer.class);
                            costo54 = dataSnapshot.child("inventario").child("Panela").child("costo").getValue(Integer.class);
                            formula54= (20 * costo54) / cantidad54; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto54 = costo54 - formula54;
                            nuevacantidad54 = cantidad54 - 20;
                            bd.child("Panela").child("cantidad").setValue(nuevacantidad54);
                            bd.child("Panela").child("costo").setValue(nuevocosto54);

                        }
                        if (contpanela == 1) {
                            nuevacantidad54 = nuevacantidad54 - 20;
                            nuevocosto54 = nuevocosto54 - formula54;
                            bd.child("Panela").child("cantidad").setValue(nuevacantidad54);
                            bd.child("Panela").child("costo").setValue(nuevocosto54);
                            contpanela = 2;
                        }
                        contpanela = 1;

                        //aceitunas
                        if (contaceitunas == 0) {
                            cantidad55 = dataSnapshot.child("inventario").child("Aceitunas").child("cantidad").getValue(Integer.class);
                            costo55 = dataSnapshot.child("inventario").child("Aceitunas").child("costo").getValue(Integer.class);
                            formula55= (20 * costo55) / cantidad55; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto55 = costo55 - formula55;
                            nuevacantidad55 = cantidad55 - 20;
                            bd.child("Aceitunas").child("cantidad").setValue(nuevacantidad55);
                            bd.child("Aceitunas").child("costo").setValue(nuevocosto55);

                        }
                        if (contaceitunas == 1) {
                            nuevacantidad55 = nuevacantidad55 - 20;
                            nuevocosto55 = nuevocosto55- formula55;
                            bd.child("Aceitunas").child("cantidad").setValue(nuevacantidad55);
                            bd.child("Aceitunas").child("costo").setValue(nuevocosto55);
                            contaceitunas = 2;
                        }
                        contaceitunas = 1;



                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula54 + formula55  + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Al Pesto")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //pollo
                        if (contpollo == 0) {
                            cantidad56 = dataSnapshot.child("inventario").child("Pollo").child("cantidad").getValue(Integer.class);
                            costo56 = dataSnapshot.child("inventario").child("Pollo").child("costo").getValue(Integer.class);
                            formula56= (20 * costo56) / cantidad56; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto56 = costo56 - formula56;
                            nuevacantidad56 = cantidad56 - 20;
                            bd.child("Pollo").child("cantidad").setValue(nuevacantidad56);
                            bd.child("Pollo").child("costo").setValue(nuevocosto56);

                        }
                        if (contpollo == 1) {
                            nuevacantidad56 = nuevacantidad56 - 20;
                            nuevocosto56 = nuevocosto56 - formula56;
                            bd.child("Pollo").child("cantidad").setValue(nuevacantidad56);
                            bd.child("Pollo").child("costo").setValue(nuevocosto56);
                            contpollo = 2;
                        }
                        contpollo = 1;

                        //aceitunas
                        if (contaceitunas == 0) {
                            cantidad55 = dataSnapshot.child("inventario").child("Aceitunas").child("cantidad").getValue(Integer.class);
                            costo55 = dataSnapshot.child("inventario").child("Aceitunas").child("costo").getValue(Integer.class);
                            formula55= (20 * costo55) / cantidad55; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto55 = costo55 - formula55;
                            nuevacantidad55 = cantidad55 - 20;
                            bd.child("Aceitunas").child("cantidad").setValue(nuevacantidad55);
                            bd.child("Aceitunas").child("costo").setValue(nuevocosto55);

                        }
                        if (contaceitunas == 1) {
                            nuevacantidad55 = nuevacantidad55 - 20;
                            nuevocosto55 = nuevocosto55- formula55;
                            bd.child("Aceitunas").child("cantidad").setValue(nuevacantidad55);
                            bd.child("Aceitunas").child("costo").setValue(nuevocosto55);
                            contaceitunas = 2;
                        }
                        contaceitunas = 1;

                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula56 + formula55 + formula50 + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa BBQ")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //pollo
                        if (contpollo == 0) {
                            cantidad56 = dataSnapshot.child("inventario").child("Pollo").child("cantidad").getValue(Integer.class);
                            costo56 = dataSnapshot.child("inventario").child("Pollo").child("costo").getValue(Integer.class);
                            formula56= (20 * costo56) / cantidad56; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto56 = costo56 - formula56;
                            nuevacantidad56 = cantidad56 - 20;
                            bd.child("Pollo").child("cantidad").setValue(nuevacantidad56);
                            bd.child("Pollo").child("costo").setValue(nuevocosto56);

                        }
                        if (contpollo == 1) {
                            nuevacantidad56 = nuevacantidad56 - 20;
                            nuevocosto56 = nuevocosto56 - formula56;
                            bd.child("Pollo").child("cantidad").setValue(nuevacantidad56);
                            bd.child("Pollo").child("costo").setValue(nuevocosto56);
                            contpollo = 2;
                        }
                        contpollo = 1;



                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula56  + formula50 + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Italiana")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //pollo
                        if (contpollo == 0) {
                            cantidad56 = dataSnapshot.child("inventario").child("Pollo").child("cantidad").getValue(Integer.class);
                            costo56 = dataSnapshot.child("inventario").child("Pollo").child("costo").getValue(Integer.class);
                            formula56= (20 * costo56) / cantidad56; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto56 = costo56 - formula56;
                            nuevacantidad56 = cantidad56 - 20;
                            bd.child("Pollo").child("cantidad").setValue(nuevacantidad56);
                            bd.child("Pollo").child("costo").setValue(nuevocosto56);

                        }
                        if (contpollo == 1) {
                            nuevacantidad56 = nuevacantidad56 - 20;
                            nuevocosto56 = nuevocosto56 - formula56;
                            bd.child("Pollo").child("cantidad").setValue(nuevacantidad56);
                            bd.child("Pollo").child("costo").setValue(nuevocosto56);
                            contpollo = 2;
                        }
                        contpollo = 1;

                        //tocino
                        if (conttocino == 0) {
                            cantidad57 = dataSnapshot.child("inventario").child("Tocino").child("cantidad").getValue(Integer.class);
                            costo57 = dataSnapshot.child("inventario").child("Tocino").child("costo").getValue(Integer.class);
                            formula57= (20 * costo57) / cantidad57; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto57 = costo57 - formula57;
                            nuevacantidad57 = cantidad57 - 20;
                            bd.child("Tocino").child("cantidad").setValue(nuevacantidad57);
                            bd.child("Tocino").child("costo").setValue(nuevocosto57);

                        }
                        if (conttocino == 1) {
                            nuevacantidad57 = nuevacantidad57 - 20;
                            nuevocosto57 = nuevocosto57- formula57;
                            bd.child("Tocino").child("cantidad").setValue(nuevacantidad57);
                            bd.child("Tocino").child("costo").setValue(nuevocosto57);
                            conttocino = 2;
                        }
                        conttocino = 1;

                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula56 + formula57 + formula50 + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Selva Negra")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //pierna
                        if (contpierna == 0) {
                            cantidad58 = dataSnapshot.child("inventario").child("Pierna").child("cantidad").getValue(Integer.class);
                            costo58 = dataSnapshot.child("inventario").child("Pierna").child("costo").getValue(Integer.class);
                            formula58= (20 * costo58) / cantidad58; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto58 = costo58 - formula58;
                            nuevacantidad58 = cantidad58 - 20;
                            bd.child("Pierna").child("cantidad").setValue(nuevacantidad58);
                            bd.child("Pierna").child("costo").setValue(nuevocosto58);

                        }
                        if (contpierna == 1) {
                            nuevacantidad58 = nuevacantidad58 - 20;
                            nuevocosto58 = nuevocosto58 - formula58;
                            bd.child("Pierna").child("cantidad").setValue(nuevacantidad58);
                            bd.child("Pierna").child("costo").setValue(nuevocosto58);
                            contpierna = 2;
                        }
                        contpierna = 1;

                        //aceitunas
                        if (contaceitunas == 0) {
                            cantidad55 = dataSnapshot.child("inventario").child("Aceitunas").child("cantidad").getValue(Integer.class);
                            costo55 = dataSnapshot.child("inventario").child("Aceitunas").child("costo").getValue(Integer.class);
                            formula55= (20 * costo55) / cantidad55; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto55 = costo55 - formula55;
                            nuevacantidad55 = cantidad55 - 20;
                            bd.child("Aceitunas").child("cantidad").setValue(nuevacantidad55);
                            bd.child("Aceitunas").child("costo").setValue(nuevocosto55);

                        }
                        if (contaceitunas == 1) {
                            nuevacantidad55 = nuevacantidad55 - 20;
                            nuevocosto55 = nuevocosto55- formula55;
                            bd.child("Aceitunas").child("cantidad").setValue(nuevacantidad55);
                            bd.child("Aceitunas").child("costo").setValue(nuevocosto55);
                            contaceitunas = 2;
                        }
                        contaceitunas = 1;

                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula58 + formula55 + formula50 + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Marina")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //atun
                        if (contatun == 0) {
                            cantidad59 = dataSnapshot.child("inventario").child("Atun").child("cantidad").getValue(Integer.class);
                            costo59 = dataSnapshot.child("inventario").child("Atun").child("costo").getValue(Integer.class);
                            formula59= (20 * costo59) / cantidad59; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto59 = costo59 - formula59;
                            nuevacantidad59 = cantidad59 - 20;
                            bd.child("Atun").child("cantidad").setValue(nuevacantidad59);
                            bd.child("Atun").child("costo").setValue(nuevocosto59);

                        }
                        if (contatun == 1) {
                            nuevacantidad59 = nuevacantidad59 - 20;
                            nuevocosto59 = nuevocosto59 - formula59;
                            bd.child("Atun").child("cantidad").setValue(nuevacantidad59);
                            bd.child("Atun").child("costo").setValue(nuevocosto59);
                            contatun = 2;
                        }
                        contatun = 1;

                        //aceitunas
                        if (contaceitunas == 0) {
                            cantidad55 = dataSnapshot.child("inventario").child("Aceitunas").child("cantidad").getValue(Integer.class);
                            costo55 = dataSnapshot.child("inventario").child("Aceitunas").child("costo").getValue(Integer.class);
                            formula55= (20 * costo55) / cantidad55; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto55 = costo55 - formula55;
                            nuevacantidad55 = cantidad55 - 20;
                            bd.child("Aceitunas").child("cantidad").setValue(nuevacantidad55);
                            bd.child("Aceitunas").child("costo").setValue(nuevocosto55);

                        }
                        if (contaceitunas == 1) {
                            nuevacantidad55 = nuevacantidad55 - 20;
                            nuevocosto55 = nuevocosto55- formula55;
                            bd.child("Aceitunas").child("cantidad").setValue(nuevacantidad55);
                            bd.child("Aceitunas").child("costo").setValue(nuevocosto55);
                            contaceitunas = 2;
                        }
                        contaceitunas = 1;

                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Ensalada
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;


                        if (cont1==0) {
                            suma1 = formula47 + formula59 + formula55 + formula50 + formula51 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }

                    //Crepa dulce
                    if (titulo.equals("Crepa de Lechera")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //lechera
                        if (contlechera == 0) {
                            cantidad60 = dataSnapshot.child("inventario").child("Lechera").child("cantidad").getValue(Integer.class);
                            costo60 = dataSnapshot.child("inventario").child("Lechera").child("costo").getValue(Integer.class);
                            formula60 = (20 * costo60) / cantidad60; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto60 = costo60 - formula60;
                            nuevacantidad60 = cantidad60 - 20;
                            bd.child("Lechera").child("cantidad").setValue(nuevacantidad60);
                            bd.child("Lechera").child("costo").setValue(nuevocosto60);

                        }
                        if (contlechera == 1) {
                            nuevacantidad60 = nuevacantidad60 - 20;
                            nuevocosto60 = nuevocosto60 - formula60;
                            bd.child("Lechera").child("cantidad").setValue(nuevacantidad60);
                            bd.child("Lechera").child("costo").setValue(nuevocosto60);
                            contlechera = 2;
                        }
                        contlechera = 1;




                        if (cont1==0) {
                            suma1 = formula47 + formula60 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa de Mermelada")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //mermelada
                        if (contmermelada == 0) {
                            cantidad61 = dataSnapshot.child("inventario").child("Mermelada").child("cantidad").getValue(Integer.class);
                            costo61 = dataSnapshot.child("inventario").child("Mermelada").child("costo").getValue(Integer.class);
                            formula61 = (20 * costo61) / cantidad61; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto61 = costo61 - formula61;
                            nuevacantidad61 = cantidad61 - 20;
                            bd.child("Mermelada").child("cantidad").setValue(nuevacantidad61);
                            bd.child("Mermelada").child("costo").setValue(nuevocosto61);

                        }
                        if (contmermelada == 1) {
                            nuevacantidad61 = nuevacantidad61 - 20;
                            nuevocosto61 = nuevocosto61 - formula61;
                            bd.child("Mermelada").child("cantidad").setValue(nuevacantidad61);
                            bd.child("Mermelada").child("costo").setValue(nuevocosto61);
                            contmermelada = 2;
                        }
                        contmermelada = 1;




                        if (cont1==0) {
                            suma1 = formula47 + formula61 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa de Cajeta")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //Cajeta
                        if (contcajeta == 0) {
                            cantidad62 = dataSnapshot.child("inventario").child("Cajeta").child("cantidad").getValue(Integer.class);
                            costo62 = dataSnapshot.child("inventario").child("Cajeta").child("costo").getValue(Integer.class);
                            formula62 = (20 * costo62) / cantidad62; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto62 = costo62 - formula62;
                            nuevacantidad62 = cantidad62 - 20;
                            bd.child("Cajeta").child("cantidad").setValue(nuevacantidad62);
                            bd.child("Cajeta").child("costo").setValue(nuevocosto62);

                        }
                        if (contcajeta == 1) {
                            nuevacantidad62 = nuevacantidad62 - 20;
                            nuevocosto62 = nuevocosto62 - formula62;
                            bd.child("Cajeta").child("cantidad").setValue(nuevacantidad62);
                            bd.child("Cajeta").child("costo").setValue(nuevocosto62);
                            contcajeta = 2;
                        }
                        contcajeta = 1;




                        if (cont1==0) {
                            suma1 = formula47 + formula62 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa de Lechera con Zarzamora")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //lechera
                        if (contlechera == 0) {
                            cantidad60 = dataSnapshot.child("inventario").child("Lechera").child("cantidad").getValue(Integer.class);
                            costo60 = dataSnapshot.child("inventario").child("Lechera").child("costo").getValue(Integer.class);
                            formula60 = (20 * costo60) / cantidad60; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto60 = costo60 - formula60;
                            nuevacantidad60 = cantidad60 - 20;
                            bd.child("Lechera").child("cantidad").setValue(nuevacantidad60);
                            bd.child("Lechera").child("costo").setValue(nuevocosto60);

                        }
                        if (contlechera == 1) {
                            nuevacantidad60 = nuevacantidad60 - 20;
                            nuevocosto60 = nuevocosto60 - formula60;
                            bd.child("Lechera").child("cantidad").setValue(nuevacantidad60);
                            bd.child("Lechera").child("costo").setValue(nuevocosto60);
                            contlechera = 2;
                        }
                        contlechera = 1;

                        //Zarzamora
                        if (contzarzamora == 0) {
                            cantidad63 = dataSnapshot.child("inventario").child("Zarzamora").child("cantidad").getValue(Integer.class);
                            costo63 = dataSnapshot.child("inventario").child("Zarzamora").child("costo").getValue(Integer.class);
                            formula63 = (20 * costo63) / cantidad63; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto63 = costo63 - formula63;
                            nuevacantidad63 = cantidad63 - 20;
                            bd.child("Zarzamora").child("cantidad").setValue(nuevacantidad63);
                            bd.child("Zarzamora").child("costo").setValue(nuevocosto63);

                        }
                        if (contzarzamora == 1) {
                            nuevacantidad63 = nuevacantidad63 - 20;
                            nuevocosto63 = nuevocosto63 - formula63;
                            bd.child("Zarzamora").child("cantidad").setValue(nuevacantidad63);
                            bd.child("Zarzamora").child("costo").setValue(nuevocosto63);
                            contzarzamora = 2;
                        }
                        contzarzamora = 1;




                        if (cont1==0) {
                            suma1 = formula47 + formula60 + formula63 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa de Queso crema y Zarzamora")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //Queso crema
                        if (contquesocre == 0) {
                            cantidad64 = dataSnapshot.child("inventario").child("Queso crema").child("cantidad").getValue(Integer.class);
                            costo64 = dataSnapshot.child("inventario").child("Queso crema").child("costo").getValue(Integer.class);
                            formula64 = (20 * costo64) / cantidad64; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto64 = costo64 - formula64;
                            nuevacantidad64 = cantidad64 - 20;
                            bd.child("Queso crema").child("cantidad").setValue(nuevacantidad64);
                            bd.child("Queso crema").child("costo").setValue(nuevocosto64);

                        }
                        if (contquesocre == 1) {
                            nuevacantidad64 = nuevacantidad64 - 20;
                            nuevocosto64 = nuevocosto64 - formula64;
                            bd.child("Queso crema").child("cantidad").setValue(nuevacantidad64);
                            bd.child("Queso crema").child("costo").setValue(nuevocosto64);
                            contquesocre = 2;
                        }
                        contquesocre = 1;

                        //Zarzamora
                        if (contzarzamora == 0) {
                            cantidad63 = dataSnapshot.child("inventario").child("Zarzamora").child("cantidad").getValue(Integer.class);
                            costo63 = dataSnapshot.child("inventario").child("Zarzamora").child("costo").getValue(Integer.class);
                            formula63 = (20 * costo63) / cantidad63; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto63 = costo63 - formula63;
                            nuevacantidad63 = cantidad63 - 20;
                            bd.child("Zarzamora").child("cantidad").setValue(nuevacantidad63);
                            bd.child("Zarzamora").child("costo").setValue(nuevocosto63);

                        }
                        if (contzarzamora == 1) {
                            nuevacantidad63 = nuevacantidad63 - 20;
                            nuevocosto63 = nuevocosto63 - formula63;
                            bd.child("Zarzamora").child("cantidad").setValue(nuevacantidad63);
                            bd.child("Zarzamora").child("costo").setValue(nuevocosto63);
                            contzarzamora = 2;
                        }
                        contzarzamora = 1;




                        if (cont1==0) {
                            suma1 = formula47 + formula60 + formula63 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa de Nutella")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //Nutella
                        if (contnutella == 0) {
                            cantidad65 = dataSnapshot.child("inventario").child("Nutella").child("cantidad").getValue(Integer.class);
                            costo65 = dataSnapshot.child("inventario").child("Nutella").child("costo").getValue(Integer.class);
                            formula65 = (20 * costo65) / cantidad65; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto65 = costo65 - formula65;
                            nuevacantidad65 = cantidad65 - 20;
                            bd.child("Nutella").child("cantidad").setValue(nuevacantidad65);
                            bd.child("Nutella").child("costo").setValue(nuevocosto65);

                        }
                        if (contnutella == 1) {
                            nuevacantidad65 = nuevacantidad65 - 20;
                            nuevocosto65 = nuevocosto65 - formula65;
                            bd.child("Nutella").child("cantidad").setValue(nuevacantidad65);
                            bd.child("Nutella").child("costo").setValue(nuevocosto65);
                            contnutella = 2;
                        }
                        contnutella = 1;




                        if (cont1==0) {
                            suma1 = formula47 + formula65 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Chocolate Supremo")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //Nutella
                        if (contnutella == 0) {
                            cantidad65 = dataSnapshot.child("inventario").child("Nutella").child("cantidad").getValue(Integer.class);
                            costo65 = dataSnapshot.child("inventario").child("Nutella").child("costo").getValue(Integer.class);
                            formula65 = (20 * costo65) / cantidad65; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto65 = costo65 - formula65;
                            nuevacantidad65 = cantidad65 - 20;
                            bd.child("Nutella").child("cantidad").setValue(nuevacantidad65);
                            bd.child("Nutella").child("costo").setValue(nuevocosto65);

                        }
                        if (contnutella == 1) {
                            nuevacantidad65 = nuevacantidad65 - 20;
                            nuevocosto65 = nuevocosto65 - formula65;
                            bd.child("Nutella").child("cantidad").setValue(nuevacantidad65);
                            bd.child("Nutella").child("costo").setValue(nuevocosto65);
                            contnutella = 2;
                        }
                        contnutella = 1;


                        //chocolate
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


                        ///fresa
                        if (contfresa == 0) {
                            cantidad42 = dataSnapshot.child("inventario").child("Fresa").child("cantidad").getValue(Integer.class);
                            costo42 = dataSnapshot.child("inventario").child("Fresa").child("costo").getValue(Integer.class);
                            formula42 = (25 * costo42) / cantidad42; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto42 = costo42 - formula42;
                            nuevacantidad42 = cantidad42 - 25;
                            bd.child("Fresa").child("cantidad").setValue(nuevacantidad42);
                            bd.child("Fresa").child("costo").setValue(nuevocosto42);

                        }
                        if (contfresa == 1) {
                            nuevacantidad42 = nuevacantidad42 - 25;
                            nuevocosto42 = nuevocosto42 - formula42;
                            bd.child("Fresa").child("cantidad").setValue(nuevacantidad42);
                            bd.child("Fresa").child("costo").setValue(nuevocosto42);
                            contfresa = 2;
                        }
                        contfresa = 1;

                        ///Nuez
                        if (contnuez == 0) {
                            cantidad66 = dataSnapshot.child("inventario").child("Nuez").child("cantidad").getValue(Integer.class);
                            costo66 = dataSnapshot.child("inventario").child("Nuez").child("costo").getValue(Integer.class);
                            formula66 = (25 * costo66) / cantidad66; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto66 = costo66 - formula66;
                            nuevacantidad66 = cantidad66 - 25;
                            bd.child("Nuez").child("cantidad").setValue(nuevacantidad66);
                            bd.child("Nuez").child("costo").setValue(nuevocosto66);

                        }
                        if (contnuez == 1) {
                            nuevacantidad66 = nuevacantidad66 - 25;
                            nuevocosto66 = nuevocosto66 - formula66;
                            bd.child("Nuez").child("cantidad").setValue(nuevacantidad66);
                            bd.child("Nuez").child("costo").setValue(nuevocosto66);
                            contnuez = 2;
                        }
                        contnuez = 1;

                        ///helado de chocolate
                        if (conthchocolate == 0) {
                            cantidad67 = dataSnapshot.child("inventario").child("Helado de chocolate").child("cantidad").getValue(Integer.class);
                            costo67 = dataSnapshot.child("inventario").child("Helado de chocolate").child("costo").getValue(Integer.class);
                            formula67 = (25 * costo67) / cantidad67; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto67 = costo67 - formula67;
                            nuevacantidad67 = cantidad67 - 25;
                            bd.child("Helado de chocolate").child("cantidad").setValue(nuevacantidad67);
                            bd.child("Helado de chocolate").child("costo").setValue(nuevocosto67);

                        }
                        if (conthchocolate == 1) {
                            nuevacantidad67 = nuevacantidad67 - 25;
                            nuevocosto67 = nuevocosto67 - formula67;
                            bd.child("Helado de chocolate").child("cantidad").setValue(nuevacantidad67);
                            bd.child("Helado de chocolate").child("costo").setValue(nuevocosto67);
                            conthchocolate = 2;
                        }
                        conthchocolate = 1;




                        if (cont1==0) {
                            suma1 = formula47 + formula65 + formula24 + formula42 + formula66 + formula67 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Paraíso Frutal")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //Queso crema
                        if (contquesocre == 0) {
                            cantidad64 = dataSnapshot.child("inventario").child("Queso crema").child("cantidad").getValue(Integer.class);
                            costo64 = dataSnapshot.child("inventario").child("Queso crema").child("costo").getValue(Integer.class);
                            formula64 = (20 * costo64) / cantidad64; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto64 = costo64 - formula64;
                            nuevacantidad64 = cantidad64 - 20;
                            bd.child("Queso crema").child("cantidad").setValue(nuevacantidad64);
                            bd.child("Queso crema").child("costo").setValue(nuevocosto64);

                        }
                        if (contquesocre == 1) {
                            nuevacantidad64 = nuevacantidad64 - 20;
                            nuevocosto64 = nuevocosto64 - formula64;
                            bd.child("Queso crema").child("cantidad").setValue(nuevacantidad64);
                            bd.child("Queso crema").child("costo").setValue(nuevocosto64);
                            contquesocre = 2;
                        }
                        contquesocre = 1;

                        ///platano
                        if (contfresa == 0) {
                            cantidad42 = dataSnapshot.child("inventario").child("Fresa").child("cantidad").getValue(Integer.class);
                            costo42 = dataSnapshot.child("inventario").child("Fresa").child("costo").getValue(Integer.class);
                            formula42 = (25 * costo42) / cantidad42; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto42 = costo42 - formula42;
                            nuevacantidad42 = cantidad42 - 25;
                            bd.child("Fresa").child("cantidad").setValue(nuevacantidad42);
                            bd.child("Fresa").child("costo").setValue(nuevocosto42);

                        }
                        if (contfresa == 1) {
                            nuevacantidad42 = nuevacantidad42 - 25;
                            nuevocosto42 = nuevocosto42 - formula42;
                            bd.child("Fresa").child("cantidad").setValue(nuevacantidad42);
                            bd.child("Fresa").child("costo").setValue(nuevocosto42);
                            contfresa = 2;
                        }
                        contfresa = 1;

                        ///Nuez
                        if (contnuez == 0) {
                            cantidad66 = dataSnapshot.child("inventario").child("Nuez").child("cantidad").getValue(Integer.class);
                            costo66 = dataSnapshot.child("inventario").child("Nuez").child("costo").getValue(Integer.class);
                            formula66 = (20 * costo66) / cantidad66; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto66 = costo66 - formula66;
                            nuevacantidad66 = cantidad66 - 20;
                            bd.child("Nuez").child("cantidad").setValue(nuevacantidad66);
                            bd.child("Nuez").child("costo").setValue(nuevocosto66);

                        }
                        if (contnuez == 1) {
                            nuevacantidad66 = nuevacantidad66 - 20;
                            nuevocosto66 = nuevocosto66 - formula66;
                            bd.child("Nuez").child("cantidad").setValue(nuevacantidad66);
                            bd.child("Nuez").child("costo").setValue(nuevocosto66);
                            contnuez = 2;
                        }
                        contnuez = 1;

                        //lechera
                        if (contlechera == 0) {
                            cantidad60 = dataSnapshot.child("inventario").child("Lechera").child("cantidad").getValue(Integer.class);
                            costo60 = dataSnapshot.child("inventario").child("Lechera").child("costo").getValue(Integer.class);
                            formula60 = (20 * costo60) / cantidad60; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto60 = costo60 - formula60;
                            nuevacantidad60 = cantidad60 - 20;
                            bd.child("Lechera").child("cantidad").setValue(nuevacantidad60);
                            bd.child("Lechera").child("costo").setValue(nuevocosto60);

                        }
                        if (contlechera == 1) {
                            nuevacantidad60 = nuevacantidad60 - 20;
                            nuevocosto60 = nuevocosto60 - formula60;
                            bd.child("Lechera").child("cantidad").setValue(nuevacantidad60);
                            bd.child("Lechera").child("costo").setValue(nuevocosto60);
                            contlechera = 2;
                        }
                        contlechera = 1;

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




                        if (cont1==0) {
                            suma1 = formula47 + formula64 + formula63 + formula42 + formula66 + formula60 + formula7 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Crepa Dulce Tentación")) {
                        //Masa de crepa
                        if (contmcrepas == 0) {
                            cantidad47 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo47 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula47 = (230 * costo47) / cantidad47; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto47 = costo47 - formula47;
                            nuevacantidad47 = cantidad47 - 230;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);

                        }
                        if (contmcrepas == 1) {
                            nuevacantidad47 = nuevacantidad47 - 230;
                            nuevocosto47 = nuevocosto47 - formula47;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad47);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto47);
                            contmcrepas = 2;
                        }
                        contmcrepas = 1;

                        //Queso crema
                        if (contquesocre == 0) {
                            cantidad64 = dataSnapshot.child("inventario").child("Queso crema").child("cantidad").getValue(Integer.class);
                            costo64 = dataSnapshot.child("inventario").child("Queso crema").child("costo").getValue(Integer.class);
                            formula64 = (20 * costo64) / cantidad64; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto64 = costo64 - formula64;
                            nuevacantidad64 = cantidad64 - 20;
                            bd.child("Queso crema").child("cantidad").setValue(nuevacantidad64);
                            bd.child("Queso crema").child("costo").setValue(nuevocosto64);

                        }
                        if (contquesocre == 1) {
                            nuevacantidad64 = nuevacantidad64 - 20;
                            nuevocosto64 = nuevocosto64 - formula64;
                            bd.child("Queso crema").child("cantidad").setValue(nuevacantidad64);
                            bd.child("Queso crema").child("costo").setValue(nuevocosto64);
                            contquesocre = 2;
                        }
                        contquesocre = 1;

                        //Cajeta
                        if (contcajeta == 0) {
                            cantidad62 = dataSnapshot.child("inventario").child("Cajeta").child("cantidad").getValue(Integer.class);
                            costo62 = dataSnapshot.child("inventario").child("Cajeta").child("costo").getValue(Integer.class);
                            formula62 = (20 * costo62) / cantidad62; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto62 = costo62 - formula62;
                            nuevacantidad62 = cantidad62 - 20;
                            bd.child("Cajeta").child("cantidad").setValue(nuevacantidad62);
                            bd.child("Cajeta").child("costo").setValue(nuevocosto62);

                        }
                        if (contcajeta == 1) {
                            nuevacantidad62 = nuevacantidad62 - 20;
                            nuevocosto62 = nuevocosto62 - formula62;
                            bd.child("Cajeta").child("cantidad").setValue(nuevacantidad62);
                            bd.child("Cajeta").child("costo").setValue(nuevocosto62);
                            contcajeta = 2;
                        }
                        contcajeta = 1;

                        ///platano
                        if (contplatano == 0) {
                            cantidad68 = dataSnapshot.child("inventario").child("Platano").child("cantidad").getValue(Integer.class);
                            costo68 = dataSnapshot.child("inventario").child("Platano").child("costo").getValue(Integer.class);
                            formula68 = (20 * costo68) / cantidad68; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto68 = costo68 - formula68;
                            nuevacantidad68 = cantidad68 - 20;
                            bd.child("Platano").child("cantidad").setValue(nuevacantidad68);
                            bd.child("Platano").child("costo").setValue(nuevocosto68);

                        }
                        if (contplatano == 1) {
                            nuevacantidad68 = nuevacantidad68 - 20;
                            nuevocosto68 = nuevocosto68 - formula68;
                            bd.child("Platano").child("cantidad").setValue(nuevacantidad68);
                            bd.child("Platano").child("costo").setValue(nuevocosto68);
                            contplatano = 2;
                        }
                        contplatano = 1;


                        ///Nuez
                        if (contnuez == 0) {
                            cantidad66 = dataSnapshot.child("inventario").child("Nuez").child("cantidad").getValue(Integer.class);
                            costo66 = dataSnapshot.child("inventario").child("Nuez").child("costo").getValue(Integer.class);
                            formula66 = (20 * costo66) / cantidad66; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto66 = costo66 - formula66;
                            nuevacantidad66 = cantidad66 - 20;
                            bd.child("Nuez").child("cantidad").setValue(nuevacantidad66);
                            bd.child("Nuez").child("costo").setValue(nuevocosto66);

                        }
                        if (contnuez == 1) {
                            nuevacantidad66 = nuevacantidad66 - 20;
                            nuevocosto66 = nuevocosto66 - formula66;
                            bd.child("Nuez").child("cantidad").setValue(nuevacantidad66);
                            bd.child("Nuez").child("costo").setValue(nuevocosto66);
                            contnuez = 2;
                        }
                        contnuez = 1;

                        //lechera
                        if (contlechera == 0) {
                            cantidad60 = dataSnapshot.child("inventario").child("Lechera").child("cantidad").getValue(Integer.class);
                            costo60 = dataSnapshot.child("inventario").child("Lechera").child("costo").getValue(Integer.class);
                            formula60 = (20 * costo60) / cantidad60; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto60 = costo60 - formula60;
                            nuevacantidad60 = cantidad60 - 20;
                            bd.child("Lechera").child("cantidad").setValue(nuevacantidad60);
                            bd.child("Lechera").child("costo").setValue(nuevocosto60);

                        }
                        if (contlechera == 1) {
                            nuevacantidad60 = nuevacantidad60 - 20;
                            nuevocosto60 = nuevocosto60 - formula60;
                            bd.child("Lechera").child("cantidad").setValue(nuevacantidad60);
                            bd.child("Lechera").child("costo").setValue(nuevocosto60);
                            contlechera = 2;
                        }
                        contlechera = 1;

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




                        if (cont1==0) {
                            suma1 = formula47 + formula64 + formula62 + formula68 + formula66 + formula60 + formula7 ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }

                    //Hamburguesas
                    if (titulo.equals("Hamburguesa sencilla")) {
                        //Pan de hamburguesa
                        if (contpanh == 0) {
                            cantidad69 = dataSnapshot.child("inventario").child("Pan de hamburguesas").child("cantidad").getValue(Integer.class);
                            costo69 = dataSnapshot.child("inventario").child("Pan de hamburguesas").child("costo").getValue(Integer.class);
                            formula69 = (230 * costo69) / cantidad69; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto69 = costo69 - formula69;
                            nuevacantidad69 = cantidad69 - 230;
                            bd.child("Pan de hamburguesas").child("cantidad").setValue(nuevacantidad69);
                            bd.child("Pan de hamburguesas").child("costo").setValue(nuevocosto69);

                        }
                        if (contpanh == 1) {
                            nuevacantidad69 = nuevacantidad69 - 230;
                            nuevocosto69 = nuevocosto69 - formula69;
                            bd.child("Pan de hamburguesas").child("cantidad").setValue(nuevacantidad69);
                            bd.child("Pan de hamburguesas").child("costo").setValue(nuevocosto69);
                            contpanh = 2;
                        }
                        contpanh = 1;

                        //Carne
                        if (contcarneh == 0) {
                            cantidad70 = dataSnapshot.child("inventario").child("Carne de hamburguesas").child("cantidad").getValue(Integer.class);
                            costo70 = dataSnapshot.child("inventario").child("Carne de hamburguesas").child("costo").getValue(Integer.class);
                            formula70 = (20 * costo70) / cantidad70; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto70 = costo70 - formula70;
                            nuevacantidad70 = cantidad70 - 20;
                            bd.child("Carne de hamburguesas").child("cantidad").setValue(nuevacantidad70);
                            bd.child("Carne de hamburguesas").child("costo").setValue(nuevocosto70);

                        }
                        if (contcarneh == 1) {
                            nuevacantidad70 = nuevacantidad70 - 20;
                            nuevocosto70 = nuevocosto70 - formula70;
                            bd.child("Carne de hamburguesas").child("cantidad").setValue(nuevacantidad70);
                            bd.child("Carne de hamburguesas").child("costo").setValue(nuevocosto70);
                            contcarneh = 2;
                        }
                        contcarneh = 1;
                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Lechuga
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;
                        //papas gajo
                        if (contpapas == 0) {
                            ccantidad = dataSnapshot.child("inventario").child("Papas").child("cantidad").getValue(Integer.class);
                            ccosto = dataSnapshot.child("inventario").child("Papas").child("costo").getValue(Integer.class);
                            formula = (500 * ccosto) / ccantidad; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto = ccosto - formula;
                            nnuevacantidad = ccantidad - 500;
                            bd.child("Papas").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Papas").child("costo").setValue(nuevocosto);

                        }
                        if (contpapas == 1) {
                            nnuevacantidad = nnuevacantidad - 500;
                            nuevocosto = nuevocosto - formula;
                            bd.child("Papas").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Papas").child("costo").setValue(nuevocosto);
                            contpapas = 2;
                        }
                        contpapas = 1;



                        if (cont1==0) {
                            suma1 = formula69 + formula70 + formula50 + formula51 + formula;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Hamburguesa Pamplona")) {
                        //Pan de hamburguesa
                        if (contpanh == 0) {
                            cantidad69 = dataSnapshot.child("inventario").child("Pan de hamburguesas").child("cantidad").getValue(Integer.class);
                            costo69 = dataSnapshot.child("inventario").child("Pan de hamburguesas").child("costo").getValue(Integer.class);
                            formula69 = (230 * costo69) / cantidad69; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto69 = costo69 - formula69;
                            nuevacantidad69 = cantidad69 - 230;
                            bd.child("Pan de hamburguesas").child("cantidad").setValue(nuevacantidad69);
                            bd.child("Pan de hamburguesas").child("costo").setValue(nuevocosto69);

                        }
                        if (contpanh == 1) {
                            nuevacantidad69 = nuevacantidad69 - 230;
                            nuevocosto69 = nuevocosto69 - formula69;
                            bd.child("Pan de hamburguesas").child("cantidad").setValue(nuevacantidad69);
                            bd.child("Pan de hamburguesas").child("costo").setValue(nuevocosto69);
                            contpanh = 2;
                        }
                        contpanh = 1;

                        //Carne
                        if (contcarneh == 0) {
                            cantidad70 = dataSnapshot.child("inventario").child("Carne de hamburguesas").child("cantidad").getValue(Integer.class);
                            costo70 = dataSnapshot.child("inventario").child("Carne de hamburguesas").child("costo").getValue(Integer.class);
                            formula70 = (20 * costo70) / cantidad70; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto70 = costo70 - formula70;
                            nuevacantidad70 = cantidad70 - 20;
                            bd.child("Carne de hamburguesas").child("cantidad").setValue(nuevacantidad70);
                            bd.child("Carne de hamburguesas").child("costo").setValue(nuevocosto70);

                        }
                        if (contcarneh == 1) {
                            nuevacantidad70 = nuevacantidad70 - 20;
                            nuevocosto70 = nuevocosto70 - formula70;
                            bd.child("Carne de hamburguesas").child("cantidad").setValue(nuevacantidad70);
                            bd.child("Carne de hamburguesas").child("costo").setValue(nuevocosto70);
                            contcarneh = 2;
                        }
                        contcarneh = 1;


                        //Chorizo
                        if (contchorizo == 0) {
                            cantidad71 = dataSnapshot.child("inventario").child("Chorizo").child("cantidad").getValue(Integer.class);
                            costo71 = dataSnapshot.child("inventario").child("Chorizo").child("costo").getValue(Integer.class);
                            formula71 = (20 * costo71) / cantidad71; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto71 = costo71 - formula71;
                            nuevacantidad71 = cantidad71 - 20;
                            bd.child("Chorizo").child("cantidad").setValue(nuevacantidad71);
                            bd.child("Chorizo").child("costo").setValue(nuevocosto71);

                        }
                        if (contchorizo == 1) {
                            nuevacantidad71 = nuevacantidad71 - 20;
                            nuevocosto71 = nuevocosto71 - formula71;
                            bd.child("Chorizo").child("cantidad").setValue(nuevacantidad71);
                            bd.child("Chorizo").child("costo").setValue(nuevocosto71);
                            contchorizo = 2;
                        }
                        contchorizo = 1;
                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Lechuga
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;
                        //papas gajo
                        if (contpapas == 0) {
                            ccantidad = dataSnapshot.child("inventario").child("Papas").child("cantidad").getValue(Integer.class);
                            ccosto = dataSnapshot.child("inventario").child("Papas").child("costo").getValue(Integer.class);
                            formula = (500 * ccosto) / ccantidad; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto = ccosto - formula;
                            nnuevacantidad = ccantidad - 500;
                            bd.child("Papas").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Papas").child("costo").setValue(nuevocosto);

                        }
                        if (contpapas == 1) {
                            nnuevacantidad = nnuevacantidad - 500;
                            nuevocosto = nuevocosto - formula;
                            bd.child("Papas").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Papas").child("costo").setValue(nuevocosto);
                            contpapas = 2;
                        }
                        contpapas = 1;



                        if (cont1==0) {
                            suma1 = formula69 + formula70 + formula71 + formula50 + formula51 + formula;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Hamburguesa Hawaiana")) {

                        //Pan de hamburguesa
                        if (contpanh == 0) {
                            cantidad69 = dataSnapshot.child("inventario").child("Pan de hamburguesas").child("cantidad").getValue(Integer.class);
                            costo69 = dataSnapshot.child("inventario").child("Pan de hamburguesas").child("costo").getValue(Integer.class);
                            formula69 = (230 * costo69) / cantidad69; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto69 = costo69 - formula69;
                            nuevacantidad69 = cantidad69 - 230;
                            bd.child("Pan de hamburguesas").child("cantidad").setValue(nuevacantidad69);
                            bd.child("Pan de hamburguesas").child("costo").setValue(nuevocosto69);

                        }
                        if (contpanh == 1) {
                            nuevacantidad69 = nuevacantidad69 - 230;
                            nuevocosto69 = nuevocosto69 - formula69;
                            bd.child("Pan de hamburguesas").child("cantidad").setValue(nuevacantidad69);
                            bd.child("Pan de hamburguesas").child("costo").setValue(nuevocosto69);
                            contpanh = 2;
                        }
                        contpanh = 1;

                        //Carne
                        if (contcarneh == 0) {
                            cantidad70 = dataSnapshot.child("inventario").child("Carne de hamburguesas").child("cantidad").getValue(Integer.class);
                            costo70 = dataSnapshot.child("inventario").child("Carne de hamburguesas").child("costo").getValue(Integer.class);
                            formula70 = (20 * costo70) / cantidad70; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto70 = costo70 - formula70;
                            nuevacantidad70 = cantidad70 - 20;
                            bd.child("Carne de hamburguesas").child("cantidad").setValue(nuevacantidad70);
                            bd.child("Carne de hamburguesas").child("costo").setValue(nuevocosto70);

                        }
                        if (contcarneh == 1) {
                            nuevacantidad70 = nuevacantidad70 - 20;
                            nuevocosto70 = nuevocosto70 - formula70;
                            bd.child("Carne de hamburguesas").child("cantidad").setValue(nuevacantidad70);
                            bd.child("Carne de hamburguesas").child("costo").setValue(nuevocosto70);
                            contcarneh = 2;
                        }
                        contcarneh = 1;

                        //tocino
                        if (conttocino == 0) {
                            cantidad57 = dataSnapshot.child("inventario").child("Tocino").child("cantidad").getValue(Integer.class);
                            costo57 = dataSnapshot.child("inventario").child("Tocino").child("costo").getValue(Integer.class);
                            formula57= (20 * costo57) / cantidad57; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto57 = costo57 - formula57;
                            nuevacantidad57 = cantidad57 - 20;
                            bd.child("Tocino").child("cantidad").setValue(nuevacantidad57);
                            bd.child("Tocino").child("costo").setValue(nuevocosto57);

                        }
                        if (conttocino == 1) {
                            nuevacantidad57 = nuevacantidad57 - 20;
                            nuevocosto57 = nuevocosto57- formula57;
                            bd.child("Tocino").child("cantidad").setValue(nuevacantidad57);
                            bd.child("Tocino").child("costo").setValue(nuevocosto57);
                            conttocino = 2;
                        }
                        conttocino = 1;

                        //jamon
                        if (contjamon == 0) {
                            cantidad52 = dataSnapshot.child("inventario").child("Jamon").child("cantidad").getValue(Integer.class);
                            costo52 = dataSnapshot.child("inventario").child("Jamon").child("costo").getValue(Integer.class);
                            formula52= (20 * costo52) / cantidad52; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto52 = costo52 - formula52;
                            nuevacantidad52 = cantidad52 - 20;
                            bd.child("Jamon").child("cantidad").setValue(nuevacantidad52);
                            bd.child("Jamon").child("costo").setValue(nuevocosto52);

                        }
                        if (contjamon == 1) {
                            nuevacantidad52 = nuevacantidad52 - 20;
                            nuevocosto52 = nuevocosto52 - formula52;
                            bd.child("Jamon").child("cantidad").setValue(nuevacantidad52);
                            bd.child("Jamon").child("costo").setValue(nuevocosto52);
                            contjamon = 2;
                        }
                        contjamon = 1;

                        //pina
                        if (contpina == 0) {
                            cantidad53 = dataSnapshot.child("inventario").child("Piña").child("cantidad").getValue(Integer.class);
                            costo53 = dataSnapshot.child("inventario").child("Piña").child("costo").getValue(Integer.class);
                            formula53= (20 * costo53) / cantidad53; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto53 = costo53 - formula53;
                            nuevacantidad53 = cantidad53 - 20;
                            bd.child("Piña").child("cantidad").setValue(nuevacantidad53);
                            bd.child("Piña").child("costo").setValue(nuevocosto53);

                        }
                        if (contpina == 1) {
                            nuevacantidad53 = nuevacantidad53 - 20;
                            nuevocosto53 = nuevocosto53 - formula53;
                            bd.child("Piña").child("cantidad").setValue(nuevacantidad53);
                            bd.child("Piña").child("costo").setValue(nuevocosto53);
                            contpina = 2;
                        }
                        contpina = 1;


                        //queso man
                        if (contquesoman == 0) {
                            cantidad50 = dataSnapshot.child("inventario").child("Queso manchego").child("cantidad").getValue(Integer.class);
                            costo50 = dataSnapshot.child("inventario").child("Queso manchego").child("costo").getValue(Integer.class);
                            formula50= (20 * costo50) / cantidad50; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto50 = costo50 - formula50;
                            nuevacantidad50 = cantidad50 - 20;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);

                        }
                        if (contquesoman == 1) {
                            nuevacantidad50 = nuevacantidad50 - 20;
                            nuevocosto50 = nuevocosto50 - formula50;
                            bd.child("Queso manchego").child("cantidad").setValue(nuevacantidad50);
                            bd.child("Queso manchego").child("costo").setValue(nuevocosto50);
                            contquesoman = 2;
                        }
                        contquesoman = 1;

                        //Lechuga
                        if (contlechuga == 0) {
                            cantidad51 = dataSnapshot.child("inventario").child("Lechuga").child("cantidad").getValue(Integer.class);
                            costo51 = dataSnapshot.child("inventario").child("Lechuga").child("costo").getValue(Integer.class);
                            formula51= (20 * costo51) / cantidad51; //15 es la cantidad en mililitros que se utilizará de limon
                            nuevocosto51 = costo51 - formula51;
                            nuevacantidad51 = cantidad51 - 20;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);

                        }
                        if (contlechuga == 1) {
                            nuevacantidad51 = nuevacantidad51 - 20;
                            nuevocosto51 = nuevocosto51 - formula51;
                            bd.child("Lechuga").child("cantidad").setValue(nuevacantidad51);
                            bd.child("Lechuga").child("costo").setValue(nuevocosto51);
                            contlechuga = 2;
                        }
                        contlechuga = 1;
                        //papas gajo
                        if (contpapas == 0) {
                            ccantidad = dataSnapshot.child("inventario").child("Papas").child("cantidad").getValue(Integer.class);
                            ccosto = dataSnapshot.child("inventario").child("Papas").child("costo").getValue(Integer.class);
                            formula = (500 * ccosto) / ccantidad; //500 es la cantidad en gramos que se utilizará de alitas de pollo
                            nuevocosto = ccosto - formula;
                            nnuevacantidad = ccantidad - 500;
                            bd.child("Papas").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Papas").child("costo").setValue(nuevocosto);

                        }
                        if (contpapas == 1) {
                            nnuevacantidad = nnuevacantidad - 500;
                            nuevocosto = nuevocosto - formula;
                            bd.child("Papas").child("cantidad").setValue(nnuevacantidad);
                            bd.child("Papas").child("costo").setValue(nuevocosto);
                            contpapas = 2;
                        }
                        contpapas = 1;



                        if (cont1==0) {
                            suma1 = formula69 + formula70 + formula57 + formula52 + formula53 + formula50 + formula51 + formula ;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }

                    //Otros
                    if (titulo.equals("Galletas")) {
                        //Galletas
                        if (contgalletas == 0) {
                            cantidad72 = dataSnapshot.child("inventario").child("Masa de crepa").child("cantidad").getValue(Integer.class);
                            costo72 = dataSnapshot.child("inventario").child("Masa de crepa").child("costo").getValue(Integer.class);
                            formula72 = (50 * costo72) / cantidad72; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto72 = costo72 - formula72;
                            nuevacantidad72 = cantidad72 - 50;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad72);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto72);

                        }
                        if (contgalletas == 1) {
                            nuevacantidad72 = nuevacantidad72 - 50;
                            nuevocosto72 = nuevocosto72 - formula72;
                            bd.child("Masa de crepa").child("cantidad").setValue(nuevacantidad72);
                            bd.child("Masa de crepa").child("costo").setValue(nuevocosto72);
                            contgalletas = 2;
                        }
                        contgalletas = 1;



                        if (cont1==0) {
                            suma1 = formula72;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Rebanada de Pastel")) {
                        //Pastel
                        if (contpastel == 0) {
                            cantidad73 = dataSnapshot.child("inventario").child("Pastel").child("cantidad").getValue(Integer.class);
                            costo73 = dataSnapshot.child("inventario").child("Pastel").child("costo").getValue(Integer.class);
                            formula73 = (100 * costo73) / cantidad73; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto73 = costo73 - formula73;
                            nuevacantidad73 = cantidad73 - 100;
                            bd.child("Pastel").child("cantidad").setValue(nuevacantidad73);
                            bd.child("Pastel").child("costo").setValue(nuevocosto73);

                        }
                        if (contpastel == 1) {
                            nuevacantidad73 = nuevacantidad73 - 100;
                            nuevocosto73 = nuevocosto73 - formula73;
                            bd.child("Pastel").child("cantidad").setValue(nuevacantidad73);
                            bd.child("Pastel").child("costo").setValue(nuevocosto73);
                            contpastel = 2;
                        }
                        contpastel = 1;



                        if (cont1==0) {
                            suma1 = formula73;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Brownie con Helado")) {
                        //Brownie
                        if (contbrownie == 0) {
                            cantidad74 = dataSnapshot.child("inventario").child("Brownie").child("cantidad").getValue(Integer.class);
                            costo74 = dataSnapshot.child("inventario").child("Brownie").child("costo").getValue(Integer.class);
                            formula74 = (100 * costo74) / cantidad74; //500 es la cantidad en mililitros que se utilizará de refrescos
                            nuevocosto74 = costo74 - formula74;
                            nuevacantidad74 = cantidad74 - 100;
                            bd.child("Brownie").child("cantidad").setValue(nuevacantidad74);
                            bd.child("Brownie").child("costo").setValue(nuevocosto74);

                        }
                        if (contbrownie == 1) {
                            nuevacantidad74 = nuevacantidad74 - 100;
                            nuevocosto74 = nuevocosto74 - formula74;
                            bd.child("Brownie").child("cantidad").setValue(nuevacantidad74);
                            bd.child("Brownie").child("costo").setValue(nuevocosto74);
                            contbrownie = 2;
                        }
                        contbrownie = 1;

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



                        if (cont1==0) {
                            suma1 = formula73 + formula7;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }
                    if (titulo.equals("Copa de Helado")) {
                        //Helado de Vainilla
                        if (conthvainilla == 0) {
                            cantidad7 = dataSnapshot.child("inventario").child("Helado de Vainilla").child("cantidad").getValue(Integer.class);
                            costo7 = dataSnapshot.child("inventario").child("Helado de Vainilla").child("costo").getValue(Integer.class);
                            formula7 = (75 * costo7) / cantidad7; //25 es la cantidad en gramos que se utilizara de azucar
                            nuevocosto7 = costo7 - formula7;
                            nuevacantidad7 = cantidad7 - 75;
                            bd.child("Helado de Vainilla").child("cantidad").setValue(nuevacantidad7);
                            bd.child("Helado de Vainilla").child("costo").setValue(nuevocosto7);

                        }
                        if (conthvainilla == 1) {
                            nuevacantidad7 = nuevacantidad7 - 75;
                            nuevocosto7 = nuevocosto7 - formula7;
                            bd.child("Helado de Vainilla").child("cantidad").setValue(nuevacantidad7);
                            bd.child("Helado de Vainilla").child("costo").setValue(nuevocosto7);
                            conthvainilla = 2;
                        }
                        conthvainilla = 1;



                        if (cont1==0) {
                            suma1 = formula7;
                            ganancia1 = precio - suma1;

                        }
                        if (cont1==1) {
                            ganancia1 = ganancia1 + ganancia1;
                            cont1=2;
                        }
                        cont1=1;
                    }


                    //Pedidos

                    //mDatabase = database.getReference().child("pedidos").push();
                    //mDatabase.child("idp").setValue(idp);
                    //mDatabase.child("total").setValue(valortotal);

                    contganancia = ganancia0+ganancia1+ganancia2+ganancia3+ganancia4+ganancia5+ganancia6+ganancia7+ganancia8+ganancia9+ganancia10+ganancia11+ganancia12;

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.child("ganancias").child(fecha).child("ganancia").getValue(Integer.class) == null) {

                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("ganancias").child(fecha);
                                ref.child("ganancia").setValue(contganancia);
                                ref.child("venta").setValue(contventa);

                            } else {
                                ganancia = dataSnapshot.child("ganancias").child(fecha).child("ganancia").getValue(Integer.class);
                                venta = dataSnapshot.child("ganancias").child(fecha).child("venta").getValue(Integer.class);
                                ganancia = contganancia + ganancia;
                                venta = contventa + venta;
                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("ganancias").child(fecha);
                                ref.child("ganancia").setValue(ganancia);
                                ref.child("venta").setValue(venta);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


                //Eliminar carrito
                db.delete(Utilidades.TABLA_ORDEN2, null, null);
                db.close();

                //Conteo productos
                SharedPreferences preferences = getSharedPreferences("contadores", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("cont", cont);
                editor.apply();
                Intent intent = new Intent(cuenta2.this, tiempodeespera.class);
                startActivityForResult(intent, 0);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}



