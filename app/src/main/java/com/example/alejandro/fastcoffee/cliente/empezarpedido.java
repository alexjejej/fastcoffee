package com.example.alejandro.fastcoffee.cliente;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.bebidas.chai;
import com.example.alejandro.fastcoffee.tiempodeespera;
import com.example.alejandro.fastcoffee.utilidades.cuenta2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class empezarpedido extends AppCompatActivity {

    int contpedidos;

    //código
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
    public void onBackPressed() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("¡ALERTA!");
        dialogo1.setMessage("No se puede salir de esta pestaña");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });

        dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empezarpedido);
        final Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(empezarpedido.this, Cliente.class);
                startActivityForResult(intent, 0);
                ContadorPedidos();

            }
        });
    }

    private void ContadorPedidos() {
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child("contadores").child("idp").getValue(Integer.class)==null) {
                    ref.child("contadores").child("idp").setValue(1);
                    SharedPreferences idp = getSharedPreferences("contadores", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = idp.edit();
                    editor.putInt("idp", 1);

                    editor.apply();
                }
                else {
                    int valor = dataSnapshot.child("contadores").child("idp").getValue(Integer.class);
                    contpedidos = valor + 1;
                    ref.child("contadores").child("idp").setValue(contpedidos);

                    SharedPreferences idp = getSharedPreferences("contadores", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = idp.edit();
                    editor.putInt("idp", contpedidos);

                    editor.apply();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
