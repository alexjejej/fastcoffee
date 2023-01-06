package com.example.alejandro.fastcoffee.cliente;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.bebidas.bebidas;
import com.example.alejandro.fastcoffee.cliente.platillos.platofuerte;
import com.example.alejandro.fastcoffee.cliente.platillos.entradas;
import com.example.alejandro.fastcoffee.cliente.platillos.poestres;
import com.example.alejandro.fastcoffee.utilidades.Cuenta;
import com.example.alejandro.fastcoffee.tiempodeespera;

public class Cliente extends AppCompatActivity {

    String mesaseleccionada;

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
        setContentView(R.layout.activity_cliente);

        SharedPreferences preferences = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        mesaseleccionada = preferences.getString("mesa","");

        final ImageButton com = (ImageButton) findViewById(R.id.btnplatofuerte);
        final ImageButton sushi = (ImageButton) findViewById(R.id.btnentradas);
        final ImageButton cre = (ImageButton) findViewById(R.id.btncrepas);
        final ImageButton btnbe = (ImageButton) findViewById(R.id.btnbebidas);
        final ImageButton btncarrito = (ImageButton) findViewById(R.id.btncarrito);
        final ImageButton btnpedido = (ImageButton) findViewById(R.id.btnpedido);
        final TextView txtcomida = (TextView) findViewById(R.id.txtplatofuerte);
        final TextView txtbebida = (TextView) findViewById(R.id.txtbebida);
        final TextView txsushi = (TextView) findViewById(R.id.txtentradas);
        final TextView txtposte = (TextView) findViewById(R.id.txtpostre);



        btnbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbe.setAlpha(120);
                com.setAlpha(255);
                sushi.setAlpha(255);
                cre.setAlpha(255);
                btncarrito.setAlpha(250);
                btnpedido.setAlpha(250);

                txtbebida.setTextColor(Color.parseColor("#FFFFFF"));
                txtcomida.setTextColor(Color.parseColor("#A9A9A9"));
                txsushi.setTextColor(Color.parseColor("#A9A9A9"));
                txtposte.setTextColor(Color.parseColor("#A9A9A9"));

                Intent intent = new Intent(v.getContext(), bebidas.class);
                startActivityForResult(intent, 0);

            }

        });

        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbe.setAlpha(255);
                com.setAlpha(120);
                sushi.setAlpha(255);
                cre.setAlpha(255);
                btncarrito.setAlpha(250);
                btnpedido.setAlpha(250);

                txtbebida.setTextColor(Color.parseColor("#A9A9A9"));
                txtcomida.setTextColor(Color.parseColor("#FFFFFF"));
                txsushi.setTextColor(Color.parseColor("#A9A9A9"));
                txtposte.setTextColor(Color.parseColor("#A9A9A9"));

                Intent intent = new Intent(v.getContext(), platofuerte.class);
                startActivityForResult(intent, 0);


            }
        });

        sushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbe.setAlpha(255);
                com.setAlpha(255);
                sushi.setAlpha(120);
                cre.setAlpha(255);
                btncarrito.setAlpha(250);
                btnpedido.setAlpha(250);

                txtbebida.setTextColor(Color.parseColor("#A9A9A9"));
                txtcomida.setTextColor(Color.parseColor("#A9A9A9"));
                txsushi.setTextColor(Color.parseColor("#FFFFFF"));
                txtposte.setTextColor(Color.parseColor("#A9A9A9"));

                Intent intent = new Intent(v.getContext(), entradas.class);
                startActivityForResult(intent, 0);


            }
        });

        cre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbe.setAlpha(250);
                com.setAlpha(255);
                sushi.setAlpha(255);
                cre.setAlpha(120);
                btncarrito.setAlpha(250);
                btnpedido.setAlpha(250);

                txtbebida.setTextColor(Color.parseColor("#A9A9A9"));
                txtcomida.setTextColor(Color.parseColor("#A9A9A9"));
                txsushi.setTextColor(Color.parseColor("#A9A9A9"));
                txtposte.setTextColor(Color.parseColor("#FFFFFF"));

                Intent intent = new Intent(v.getContext(), poestres.class);
                startActivityForResult(intent, 0);


            }
        });
        btncarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbe.setAlpha(255);
                com.setAlpha(255);
                sushi.setAlpha(255);
                cre.setAlpha(255);
                btncarrito.setAlpha(30);
                btnpedido.setAlpha(250);

                txtbebida.setTextColor(Color.parseColor("#A9A9A9"));
                txtcomida.setTextColor(Color.parseColor("#A9A9A9"));
                txsushi.setTextColor(Color.parseColor("#A9A9A9"));
                txtposte.setTextColor(Color.parseColor("#A9A9A9"));

                Intent intent = new Intent(v.getContext(), Cuenta.class);
                startActivityForResult(intent, 0);
            }
        });

        btnpedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbe.setAlpha(255);
                com.setAlpha(255);
                sushi.setAlpha(255);
                cre.setAlpha(255);
                btncarrito.setAlpha(250);
                btnpedido.setAlpha(30);

                txtbebida.setTextColor(Color.parseColor("#A9A9A9"));
                txtcomida.setTextColor(Color.parseColor("#A9A9A9"));
                txsushi.setTextColor(Color.parseColor("#A9A9A9"));
                txtposte.setTextColor(Color.parseColor("#A9A9A9"));

                Intent intent = new Intent(v.getContext(), tiempodeespera.class);
                startActivityForResult(intent, 0);
            }
        });

    }

}



