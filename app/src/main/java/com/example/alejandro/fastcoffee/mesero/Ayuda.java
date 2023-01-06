package com.example.alejandro.fastcoffee.mesero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alejandro.fastcoffee.mesero.Mesero;
import com.example.alejandro.fastcoffee.R;

public class Ayuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        Button btnvolver = (Button) findViewById(R.id.btnvolver);

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ayuda.this, Mesero.class);
                startActivity(intent);
            }
        });

    }


}
