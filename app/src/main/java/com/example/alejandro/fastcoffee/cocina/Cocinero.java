package com.example.alejandro.fastcoffee.cocina;
import android.content.DialogInterface;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.cliente.platillos.hamburguesas;
import com.example.alejandro.fastcoffee.utilidades.AdaptadorCocina;
import com.example.alejandro.fastcoffee.utilidades.cocinaRv;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cocinero extends AppCompatActivity {
     RecyclerView recyclerView;
     List<cocinaRv> cocinarv;
     AdaptadorCocina adapter;
     String estado, producto, id;
     DatabaseReference mFirebaseRef;

    DatabaseReference dbproductos;


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
        setContentView(R.layout.activity_cocinero);

        recyclerView = findViewById(R.id.rvproductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cocinarv = new ArrayList<>();
        adapter = new AdaptadorCocina(cocinarv);
        recyclerView.setAdapter(adapter);


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 estado = cocinarv.get(recyclerView.getChildAdapterPosition(v)).getEstado();
                 producto = cocinarv.get(recyclerView.getChildAdapterPosition(v)).getProducto();
                 id = cocinarv.get(recyclerView.getChildAdapterPosition(v)).getId();

                TerminarProducto();
            }
        });

        //Llenar en el recyclerview Firebase

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Query query = database.getReference().child("productos").orderByChild("estado").equalTo("En cocina");;
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

    private void TerminarProducto() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Terminar producto");
        dialogo1.setMessage("¿Terminó de preparar '"+producto+"'?");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                registrarOrden();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Producto terminado correctamente", Toast.LENGTH_SHORT);
                toast1.show();

            }
        });

        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Toast toast1 = Toast.makeText(getApplicationContext(), "Producto en preparación", Toast.LENGTH_SHORT);

            }
        });
        dialogo1.show();
    }

    private void registrarOrden() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference messageReference = database.getReference().child("productos").child(id);
        messageReference.child("estado").setValue("terminado");
    }


}






