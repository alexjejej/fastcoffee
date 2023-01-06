package com.example.alejandro.fastcoffee.cliente.platillos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.alejandro.fastcoffee.R;

public class platofuerte extends AppCompatActivity {

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
        setContentView(R.layout.activity_platofuerte);

    final ImageButton btnent = (ImageButton) findViewById(R.id.btncrepasalada);
    final ImageButton btnhambur = (ImageButton) findViewById(R.id.btnhamburguesas);


        btnent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            btnent.setAlpha(125);
            btnhambur.setAlpha(255);


            Intent intent = new Intent(v.getContext(), crepasaladas.class);
            startActivityForResult(intent, 0);

        }
    });


        btnhambur.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            btnent.setAlpha(255);
            btnhambur.setAlpha(125);


            Intent intent = new Intent(v.getContext(), hamburguesas.class);
            startActivityForResult(intent, 0);

        }
    });


}
}

