package com.example.alejandro.fastcoffee.cliente.bebidas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.alejandro.fastcoffee.R;

public class bebidas extends AppCompatActivity {
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
        setContentView(R.layout.activity_bebidas);
        final ImageButton btnsmoot = (ImageButton) findViewById(R.id.btnsmoothies);
        final ImageButton btnsoda = (ImageButton) findViewById(R.id.btnsodaitaliana);
        final ImageButton btncocteles = (ImageButton) findViewById(R.id.btncocteles);
        final ImageButton btncafe = (ImageButton) findViewById(R.id.btncafe);
        final ImageButton btncapu = (ImageButton) findViewById(R.id.btncapu);
        final ImageButton btnchoco = (ImageButton) findViewById(R.id.btncho);
        final ImageButton btnlate = (ImageButton) findViewById(R.id.btnlate);
        final ImageButton btnchai = (ImageButton) findViewById(R.id.btnchai);
        final ImageButton btnotros = (ImageButton) findViewById(R.id.btnotros);


        btnsmoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btnsoda = (ImageButton) findViewById(R.id.btnsodaitaliana);

                btnsmoot.setAlpha(125);
                btnsoda.setAlpha(255);
                btncocteles.setAlpha(255);
                btncafe.setAlpha(255);
                btncapu.setAlpha(255);
                btnchoco.setAlpha(255);
                btnlate.setAlpha(255);
                btnchai.setAlpha(255);
                btnotros.setAlpha(255);

                Intent intent = new Intent(v.getContext(), Smoothies.class);
                startActivityForResult(intent, 0);

            }
        });

        btnsoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnsmoot.setAlpha(255);
                btnsoda.setAlpha(125);
                btncocteles.setAlpha(255);
                btncafe.setAlpha(255);
                btncapu.setAlpha(255);
                btnchoco.setAlpha(255);
                btnlate.setAlpha(255);
                btnchai.setAlpha(255);
                btnotros.setAlpha(255);

                Intent intent = new Intent(v.getContext(), SodasItalianas.class);
                startActivityForResult(intent, 0);

            }
        });

        btncocteles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnsmoot.setAlpha(255);
                btnsoda.setAlpha(255);
                btncocteles.setAlpha(125);
                btncafe.setAlpha(255);
                btncapu.setAlpha(255);
                btnchoco.setAlpha(255);
                btnlate.setAlpha(255);
                btnchai.setAlpha(255);
                btnotros.setAlpha(255);

                Intent intent = new Intent(v.getContext(), cocteles.class);
                startActivityForResult(intent, 0);

            }
        });

        btncafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnsmoot.setAlpha(255);
                btnsoda.setAlpha(255);
                btncocteles.setAlpha(255);
                btncafe.setAlpha(125);
                btncapu.setAlpha(255);
                btnchoco.setAlpha(255);
                btnlate.setAlpha(255);
                btnchai.setAlpha(255);
                btnotros.setAlpha(255);

                Intent intent = new Intent(v.getContext(), Expresos.class);
                startActivityForResult(intent, 0);

            }
        });

        btncapu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnsmoot.setAlpha(255);
                btnsoda.setAlpha(255);
                btncocteles.setAlpha(255);
                btncafe.setAlpha(255);
                btncapu.setAlpha(125);
                btnchoco.setAlpha(255);
                btnlate.setAlpha(255);
                btnchai.setAlpha(255);
                btnotros.setAlpha(255);

                Intent intent = new Intent(v.getContext(), cappucinos.class);
                startActivityForResult(intent, 0);

            }
        });

        btnchoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnsmoot.setAlpha(255);
                btnsoda.setAlpha(255);
                btncocteles.setAlpha(255);
                btncafe.setAlpha(255);
                btncapu.setAlpha(255);
                btnchoco.setAlpha(125);
                btnlate.setAlpha(255);
                btnchai.setAlpha(255);
                btnotros.setAlpha(255);

                Intent intent = new Intent(v.getContext(), choco.class);
                startActivityForResult(intent, 0);

            }
        });
        btnlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnsmoot.setAlpha(255);
                btnsoda.setAlpha(255);
                btncocteles.setAlpha(255);
                btncafe.setAlpha(255);
                btncapu.setAlpha(255);
                btnchoco.setAlpha(255);
                btnlate.setAlpha(125);
                btnchai.setAlpha(255);
                btnotros.setAlpha(255);

                Intent intent = new Intent(v.getContext(), late.class);
                startActivityForResult(intent, 0);

            }
        });

        btnchai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnsmoot.setAlpha(255);
                btnsoda.setAlpha(255);
                btncocteles.setAlpha(255);
                btncafe.setAlpha(255);
                btncapu.setAlpha(255);
                btnchoco.setAlpha(255);
                btnlate.setAlpha(255);
                btnchai.setAlpha(125);
                btnotros.setAlpha(255);

                Intent intent = new Intent(v.getContext(), chai.class);
                startActivityForResult(intent, 0);

            }
        });

        btnotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnsmoot.setAlpha(255);
                btnsoda.setAlpha(255);
                btncocteles.setAlpha(255);
                btncafe.setAlpha(255);
                btncapu.setAlpha(255);
                btnchoco.setAlpha(255);
                btnlate.setAlpha(255);
                btnchai.setAlpha(255);
                btnotros.setAlpha(125);

                Intent intent = new Intent(v.getContext(), refresco.class);
                startActivityForResult(intent, 0);

            }
        });
    }
}
