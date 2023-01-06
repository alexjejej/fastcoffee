package com.example.alejandro.fastcoffee.dueño;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.platillos.hamburguesas;
import com.example.alejandro.fastcoffee.utilidades.ConexionSQLiteHelper;
import com.example.alejandro.fastcoffee.utilidades.Utilidades;

public class Dueno extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dueno);
        Button btnagregarproductos = (Button) findViewById(R.id.btnverinventario);
        Button btnverganancias = findViewById(R.id.btnverganancias);
        Button btninventnario = (Button) findViewById(R.id.btninventario);

        btnagregarproductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dueno.this, VerInventario.class);
                startActivity(intent);
            }

        });


        btninventnario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dueno.this, AdministrarInventario.class);
                startActivity(intent);
            }
        });
        btnverganancias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dueno.this, Ganancias.class);
                startActivity(intent);
            }
        });


    }

}