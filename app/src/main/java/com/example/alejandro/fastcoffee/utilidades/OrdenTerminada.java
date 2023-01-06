package com.example.alejandro.fastcoffee.utilidades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.Cliente;
import com.example.alejandro.fastcoffee.cliente.empezarpedido;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrdenTerminada extends AppCompatActivity {

    RecyclerView recyclerView;
    List<cocinaRv> cocinarv;
    AdaptadorCocina adapter;
    TextView preciototal;

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
        setContentView(R.layout.activity_orden_terminada);
        recyclerView = findViewById(R.id.rvordenterminada);
        preciototal = findViewById(R.id.txttotal2);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdenTerminada.this, empezarpedido.class);
                startActivityForResult(intent, 0);

                nuevopedido();
            }
        });

        SharedPreferences pref = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        int valortotal = pref.getInt("precioT", 0);
        preciototal.setText("$" + valortotal);

        recyclerView = findViewById(R.id.rvordenterminada);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cocinarv = new ArrayList<>();
        adapter = new AdaptadorCocina(cocinarv);
        recyclerView.setAdapter(adapter);


        SharedPreferences idp = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        int idpedido = idp.getInt("idp", 0);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Query query = database.getReference().child("productos").orderByChild("idp").equalTo(idpedido);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cocinarv.removeAll(cocinarv);
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {


                        cocinaRv cocinar = snapshot.getValue(cocinaRv.class);
                        cocinarv.add(cocinar);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("error", databaseError.getMessage());

            }
        });
    }
    private void nuevopedido() {
        SharedPreferences settings = this.getSharedPreferences("contadores", Context.MODE_PRIVATE);
        settings.edit().remove("precioT").commit();
        settings.edit().remove("keycont").commit();
        settings.edit().remove("tiempoespera").commit();
    }
}

