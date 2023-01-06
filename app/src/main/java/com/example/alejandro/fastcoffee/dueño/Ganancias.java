package com.example.alejandro.fastcoffee.dueño;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.alejandro.fastcoffee.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Ganancias extends AppCompatActivity {
    String dia, mes, ano;
    int diaint, sumaganacia, sumaventa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganancias);
        Button dia = findViewById(R.id.btndia);
        Button mes = findViewById(R.id.btnmes);
        dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaciones();
            }
        });
        mes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graficarmes();
            }
        });

    }


    private void validaciones() {
        Spinner spinnerdia = findViewById(R.id.spinnerdia);
        dia = spinnerdia.getSelectedItem().toString();
        diaint = Integer.parseInt(dia);
        Spinner spinnermes = findViewById(R.id.spinnermes);
        mes = spinnermes.getSelectedItem().toString();
        Spinner spinnerano = findViewById(R.id.spinnerano);
        ano = spinnerano.getSelectedItem().toString();

        if (ano.equals("2020") || ano.equals("2021")) {
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Error");
            dialogo1.setMessage("No hay datos con este año");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Cambiar año", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {

                }
            });

            dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                }
            });
            dialogo1.show();
        }
        else {
            if (mes.equals("Febrero") && diaint >= 30) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                dialogo1.setTitle("Error");
                dialogo1.setMessage("Febrero no tiene más de 30 días");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Cambiar día o mes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                    }
                });

                dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                    }
                });
                dialogo1.show();
            } else {
                if (mes.equals("Abril") && diaint == 31) {
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                    dialogo1.setTitle("Error");
                    dialogo1.setMessage("Abril no tiene 31 días");
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("Cambiar día o mes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {

                        }
                    });

                    dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                        }
                    });
                    dialogo1.show();
                } else {
                    if (mes.equals("Junio") && diaint == 31) {
                        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                        dialogo1.setTitle("Error");
                        dialogo1.setMessage("Junio no tiene 31 días");
                        dialogo1.setCancelable(false);
                        dialogo1.setPositiveButton("Cambiar día o mes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo1, int id) {

                            }
                        });

                        dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo1, int id) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                            }
                        });
                        dialogo1.show();
                    } else {
                        if (mes.equals("Septiembre") && diaint == 31) {
                            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                            dialogo1.setTitle("Error");
                            dialogo1.setMessage("Septiembre no tiene 31 días");
                            dialogo1.setCancelable(false);
                            dialogo1.setPositiveButton("Cambiar día o mes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo1, int id) {

                                }
                            });

                            dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo1, int id) {
                                    Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                                }
                            });
                            dialogo1.show();
                        } else {
                            if (mes.equals("Noviembre") && diaint == 31) {
                                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                                dialogo1.setTitle("Error");
                                dialogo1.setMessage("Noviembre no tiene 31 días");
                                dialogo1.setCancelable(false);
                                dialogo1.setPositiveButton("Cambiar día o mes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogo1, int id) {

                                    }
                                });

                                dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogo1, int id) {
                                        Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                                    }
                                });
                                dialogo1.show();
                            } else {
                                leerspiners();
                                graficardia();

                            }
                        }

                    }
                }
            }
        }
    }

    private void graficardia() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("ganancias").child(ano).child(mes).child(dia).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    int gan = dataSnapshot.child("ganancia").getValue(Integer.class);
                    int ventas = dataSnapshot.child("venta").getValue(Integer.class);

                    SharedPreferences idp = getSharedPreferences("contadores", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = idp.edit();
                    editor.putInt("ganancia",gan);
                    editor.putInt("venta",ventas);
                    editor.apply();
                    Intent intent = new Intent(Ganancias.this, graficas.class);
                    startActivityForResult(intent, 0);
                }else{
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Ganancias.this);
                    dialogo1.setTitle("Error");
                    dialogo1.setMessage("No hay datos registrados de este día");
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("Cambiar día o mes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {

                        }
                    });

                    dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                        }
                    });
                    dialogo1.show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void graficarmes() {
        leerspiners();
        if (ano.equals("2020") || ano.equals("2021")) {
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Error");
            dialogo1.setMessage("No hay datos con este año");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Cambiar año", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {

                }
            });

            dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                }
            });
            dialogo1.show();
        }
        else {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            ref.child("ganancias").child(ano).child(mes).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            int gan = snapshot.child("ganancia").getValue(Integer.class);
                            int ventas = snapshot.child("venta").getValue(Integer.class);
                            sumaganacia = sumaganacia + gan;
                            sumaventa = ventas + sumaventa;

                        }
                        SharedPreferences idp = getSharedPreferences("contadores", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = idp.edit();
                        editor.putInt("ganancia", sumaganacia);
                        editor.putInt("venta", sumaventa);
                        editor.apply();
                        Intent intent = new Intent(Ganancias.this, graficas.class);
                        startActivityForResult(intent, 0);
                    } else {
                        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Ganancias.this);
                        dialogo1.setTitle("Error");
                        dialogo1.setMessage("No hay datos registrados de este mes");
                        dialogo1.setCancelable(false);
                        dialogo1.setPositiveButton("Cambiar mes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo1, int id) {

                            }
                        });

                        dialogo1.setNegativeButton("", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo1, int id) {
                                Toast toast1 = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

                            }
                        });
                        dialogo1.show();
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }


    private void leerspiners() {
        Spinner spinnerdia = findViewById(R.id.spinnerdia);
        dia = spinnerdia.getSelectedItem().toString();
        diaint = Integer.parseInt(dia);
        Spinner spinnermes = findViewById(R.id.spinnermes);
        mes = spinnermes.getSelectedItem().toString();
        Spinner spinnerano = findViewById(R.id.spinnerano);
        ano = spinnerano.getSelectedItem().toString();

        if (mes.equals("Enero")) {
            mes = "01";
        }
        if (mes.equals("Febrero")) {
            mes = "02";
        }
        if (mes.equals("Marzo")) {
            mes = "03";
        }
        if (mes.equals("Abril")) {
            mes = "04";
        }
        if (mes.equals("Mayo")) {
            mes= "05";
        }
        if (mes.equals("Junio")) {
            mes = "06";
        }
        if (mes.equals("Julio")) {
            mes = "07";
        }
        if (mes.equals("Agosto")) {
            mes = "08";
        }
        if (mes.equals("Septimebre")) {
            mes = "09";
        }
        if (mes.equals("Octubre")) {
            mes = "10";
        }
        if (mes.equals("Noviembre")) {
            mes = "11";
        }
        if (mes.equals("Dicimebre")) {
            mes = "12";
        }


        if (dia.equals("1")) {
            dia = "01";
        }
        if (dia.equals("2")) {
            dia = "02";
        }
        if (dia.equals("3")) {
            dia = "03";
        }
        if (dia.equals("4")) {
            dia = "04";
        }
        if (dia.equals("5")) {
            dia= "05";
        }
        if (dia.equals("6")) {
            dia = "06";
        }
        if (dia.equals("7")) {
            dia = "07";
        }
        if (dia.equals("8")) {
            dia = "08";
        }
        if (dia.equals("9")) {
            dia = "09";
        }

    }
}
