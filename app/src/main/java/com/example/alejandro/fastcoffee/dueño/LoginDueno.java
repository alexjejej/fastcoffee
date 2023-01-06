package com.example.alejandro.fastcoffee.dueño;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;

public class LoginDueno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dueno);
    }
        public void login (View view)
        {
            EditText usuario = (EditText) findViewById(R.id.etusu);
            EditText contra = (EditText) findViewById(R.id.et2);
            if (usuario.getText().toString().trim().equalsIgnoreCase(""))
                usuario.setError("Ingresa usuario");
            if (contra.getText().toString().trim().equalsIgnoreCase(""))
                contra.setError("Ingrese contraseña");

            if (usuario.getText().toString().equals("admin") && contra.getText().toString().equals("admin")) {
                Intent intent = new Intent(this, Dueno.class);
                startActivity(intent);
            } else {
                Toast toast1 = Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
                toast1.show();
            }


        }


    }


