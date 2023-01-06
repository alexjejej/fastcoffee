package com.example.alejandro.fastcoffee.cliente.platillos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.alejandro.fastcoffee.R;

public class poestres extends AppCompatActivity {

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
        setContentView(R.layout.postres);
        final ImageButton btndul = (ImageButton) findViewById(R.id.btncrepasd);

        final ImageButton btnotros = (ImageButton) findViewById(R.id.btnotros);

        btndul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btndul.setAlpha(125);

                btnotros.setAlpha(255);
                Intent intent = new Intent(v.getContext(),crepasdulces.class);
                startActivityForResult(intent, 0);

            }
        });



        btnotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btndul.setAlpha(255);
                btnotros.setAlpha(125);

                Intent intent = new Intent(v.getContext(), otros.class);
                startActivityForResult(intent, 0);

            }
        });
    }
}
