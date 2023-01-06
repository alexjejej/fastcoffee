package com.example.alejandro.fastcoffee.dueño;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdministrarInventario extends AppCompatActivity {

    private EditText etprecio, etcantidad;
    private Button btn;
    private Spinner spinner;
    private String producto, cantidadstring, preciostring;
    private int cantidad, costo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_inventario);
        etprecio = findViewById(R.id.etprecioi);
        etcantidad = findViewById(R.id.etcantidad);
        btn = findViewById(R.id.btninventario);
        spinner = findViewById(R.id.spinnerinventario);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarDatos();
            }
        });
    }

    private void ValidarDatos() {

        producto = spinner.getSelectedItem().toString();

        if (producto.equalsIgnoreCase("Seleccione")) {
            Toast.makeText(getApplicationContext(), "Seleccione un ingrediente a registrar", Toast.LENGTH_SHORT).show();
        } else {

            if (etcantidad.getText().toString().trim().equalsIgnoreCase("")) {
                etcantidad.setError("Ingresa cantidad del ingrediente");
            }else {

                if (etprecio.getText().toString().trim().equalsIgnoreCase("")) {
                    etprecio.setError("Ingresa el coste del ingrediente");

                }else {

                    cantidadstring = etcantidad.getText().toString();
                    preciostring = etprecio.getText().toString();
                    cantidad = Integer.parseInt(cantidadstring);
                    costo = Integer.parseInt(preciostring);

                    final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.child("inventario").child(producto).child("cantidad").getValue(Integer.class)==null) {

                                ref.child("inventario").child(producto).child("producto").setValue(producto);
                                ref.child("inventario").child(producto).child("cantidad").setValue(cantidad);
                                ref.child("inventario").child(producto).child("costo").setValue(costo);
                            }

                            else {
                                int cantidadbd = dataSnapshot.child("inventario").child(producto).child("cantidad").getValue(Integer.class);
                                int costobd = dataSnapshot.child("inventario").child(producto).child("costo").getValue(Integer.class);
                                int sumacant = cantidadbd + cantidad;
                                int sumacost = costobd + costo;

                                ref.child("inventario").child(producto).child("cantidad").setValue(sumacant);
                                ref.child("inventario").child(producto).child("costo").setValue(sumacost);

                                etcantidad.setText("");
                                etprecio.setText("");
                                Toast.makeText(getApplicationContext(),"¡Ingrediente almacenado con exito!",Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        }
    }
}
