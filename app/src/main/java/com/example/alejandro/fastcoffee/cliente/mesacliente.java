package com.example.alejandro.fastcoffee.cliente;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.platillos.hamburguesas;
import com.example.alejandro.fastcoffee.utilidades.Cuenta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mesacliente extends AppCompatActivity {

    String mesa;

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
        setContentView(R.layout.activity_mesacliente);


        Button seleccion = (Button) findViewById(R.id.seleccion);
        seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObtenerSpinner();
            }
        });


    }

    private void ObtenerSpinner() {
        Spinner spinnertipo = (Spinner) findViewById(R.id.spinnermesa);
        mesa = spinnertipo.getSelectedItem().toString();
        SharedPreferences preferences = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("mesa",mesa);
        editor.apply();
        Intent intent = new Intent(this, empezarpedido.class);
        startActivityForResult(intent, 0);
    }


}


