package com.example.alejandro.fastcoffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.alejandro.fastcoffee.cliente.Cliente;
import com.example.alejandro.fastcoffee.cocina.Cocinero;
import com.example.alejandro.fastcoffee.dueño.Ganancias;
import com.example.alejandro.fastcoffee.dueño.LoginDueno;
import com.example.alejandro.fastcoffee.mesero.Mesero;
import com.example.alejandro.fastcoffee.cliente.mesacliente;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void LoginDueno(View view) {
        Intent intent = new Intent(this, LoginDueno.class);
        startActivity(intent);
    }
    public void cliente(View view) {
        Intent intent = new Intent(MainActivity.this, mesacliente.class);
        startActivity(intent);
    }
    public void meseros(View view) {
        Intent intent = new Intent(this, Mesero.class);
        startActivity(intent);
    }
    public void cocina(View view) {
        Intent intent = new Intent(MainActivity.this, Cocinero.class);
        startActivity(intent);
    }
}

