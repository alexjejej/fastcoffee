package com.example.alejandro.fastcoffee.cliente.platillos;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.mesacliente;
import com.example.alejandro.fastcoffee.entidades.Ordenes;
import com.example.alejandro.fastcoffee.utilidades.ConexionSQLiteHelper;
import com.example.alejandro.fastcoffee.utilidades.Utilidades;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class chapatas extends AppCompatActivity {

    ListView listViewOrden;
    ArrayList<String> listaInformacion;
    ArrayList<Ordenes> listaOrden;
    ConexionSQLiteHelper conn;
    RecyclerView rv;
    public String titulo, precio, descripcion, mesaseleccionada;
    public Integer id;
    public int preciototal = 0, preciot = 0, cont;
    public int valor;
    private static final String TAG = mesacliente.class.getSimpleName();
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapatas);

        SharedPreferences preferences = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        mesaseleccionada = preferences.getString("mesa", "");
        valor = preferences.getInt("precioT", 0);
        cont = preferences.getInt("keycont", 0);
        rv = (RecyclerView) findViewById(R.id.rv);
        final LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        database = FirebaseDatabase.getInstance();

    }
}