package com.example.alejandro.fastcoffee;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.cliente.empezarpedido;

import com.example.alejandro.fastcoffee.cliente.Cliente;
import com.example.alejandro.fastcoffee.utilidades.AdaptadorCocina;
import com.example.alejandro.fastcoffee.utilidades.OrdenTerminada;
import com.example.alejandro.fastcoffee.utilidades.cocinaRv;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class tiempodeespera extends AppCompatActivity {

    TextView txt;
    private TextView tem;
    private Button st, btnservilletas, btncubiertos, btncuenta, btnmesero, btnmensaje;
    private EditText etmensaje;
    private CountDownTimer countDownTimer;
    private static long timemill=480000;
    private static long contador, suma;
    private boolean timerun;
    private long timelm;
    RecyclerView recyclerView;
    List<cocinaRv> cocinarv;
    AdaptadorCocina adapter;
    String mesaseleccionada, mensaje;

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
        setContentView(R.layout.activity_tiempodeespera);
        txt = (TextView) findViewById(R.id.txtcronometro);
        btnservilletas = findViewById(R.id.btnservilletas);
        btncubiertos = findViewById(R.id.btncubiertos);
        btncuenta = findViewById(R.id.btncuenta);
        btnmesero = findViewById(R.id.btnmesero);
        btnmensaje = findViewById(R.id.btnmensaje);
        etmensaje = findViewById(R.id.etmensaje);
        SharedPreferences pref = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        suma = pref.getLong("tiempoespera", 0);
        mesaseleccionada = pref.getString("mesa","");
        timemill = timemill + suma;
        timelm = timemill;
        updateTimer();
        Button btn = (Button) findViewById(R.id.btnterminarorden);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrdenTerminada.class);
                startActivityForResult(intent, 0);

            }
        });
        countDownTimer= new CountDownTimer(timelm,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timelm=millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                timerun=false;
                txt.setText("¡Gracias por tu preferencia!");
            }
        }.start();
        timerun=true;

        recyclerView = findViewById(R.id.rvpedido);
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
                    if (snapshot.getValue().equals("finalizado")) {

                    }
                    else {
                        cocinaRv cocinar = snapshot.getValue(cocinaRv.class);
                        cocinarv.add(cocinar);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("error", databaseError.getMessage());

            }
        });

        MensajerMesero();

    }



    private void MensajerMesero() {

        btnservilletas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("mensaje").push();
                String id = db.getKey();
                db.child("id").setValue(id);
                db.child("mesa").setValue(mesaseleccionada);
                db.child("producto").setValue("Faltan servilletas en la "+mesaseleccionada);
                Toast.makeText(getApplicationContext(),"Comunicado correctamente a los meseros", Toast.LENGTH_SHORT).show();
            }
        });
        btncubiertos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("mensaje").push();
                String id = db.getKey();
                db.child("id").setValue(id);
                db.child("mesa").setValue(mesaseleccionada);
                db.child("producto").setValue("Faltan cubiertos en la "+mesaseleccionada);
                Toast.makeText(getApplicationContext(),"Comunicado correctamente a los meseros", Toast.LENGTH_SHORT).show();
            }
        });
        btncuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrdenTerminada.class);
                startActivityForResult(intent, 0);
            }
        });
        btnmensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("mensaje").push();
                String id = db.getKey();
                db.child("id").setValue(id);
                db.child("mesa").setValue(mesaseleccionada);
                mensaje = etmensaje.getText().toString();
                etmensaje.setText("");
                db.child("producto").setValue("La "+mesaseleccionada+" dice: "+mensaje);
                Toast.makeText(getApplicationContext(),"Comunicado correctamente a los meseros", Toast.LENGTH_SHORT).show();
            }
        });
        btnmesero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("mensaje").push();
                String id = db.getKey();
                db.child("id").setValue(id);
                db.child("mesa").setValue(mesaseleccionada);
                db.child("producto").setValue("Se ocupa la presencia del mesero en la "+mesaseleccionada);
                Toast.makeText(getApplicationContext(),"Comunicado correctamente a los meseros", Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void ordenar (View view) {
        Intent i = new Intent(this, Cliente.class);
        startActivityForResult(i, 0);

    }

    public  void updateTimer(){
        int min = (int) (timelm /1000)/60;
        int sec =  (int) (timelm /1000)%60;
        String timetext=String.format(Locale.getDefault(),"%02d:%02d",min,sec);
        txt.setText(timetext);
    }


}

