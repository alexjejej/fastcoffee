package com.example.alejandro.fastcoffee.dueño;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.utilidades.AdaptadorVenta;
import com.example.alejandro.fastcoffee.utilidades.ventaRv;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VerInventario extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ventaRv> ventarv;
    AdaptadorVenta adaptadorVenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_inventario);

        recyclerView = findViewById(R.id.rvinventario);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ventarv = new ArrayList<>();
        adaptadorVenta = new AdaptadorVenta(ventarv);
        recyclerView.setAdapter(adaptadorVenta);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Query query = database.getReference().child("inventario");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ventarv.removeAll(ventarv);
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    ventaRv venta = snapshot.getValue(ventaRv.class);
                    ventarv.add(venta);
                }
                adaptadorVenta.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("error", databaseError.getMessage());

            }
        });

    }
}
