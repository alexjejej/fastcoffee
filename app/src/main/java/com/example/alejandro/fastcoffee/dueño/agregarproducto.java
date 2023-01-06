package com.example.alejandro.fastcoffee.dueño;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;
import com.example.alejandro.fastcoffee.utilidades.ConexionSQLiteHelper;
import com.example.alejandro.fastcoffee.utilidades.Utilidades;

public class agregarproducto extends AppCompatActivity {

    private String titulo, descripcion, tipo;
    private int precio;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarproducto);
        Button btn = (Button) findViewById(R.id.btnregistrar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeerValores();
                registrarMenu();
                limpiarActivity();
            }

        });

    }



    public void LeerValores() {
        EditText etTitulo = (EditText) findViewById(R.id.etTitulo);
        EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        EditText etPrecio = (EditText) findViewById(R.id.etPrecio);
        Spinner spinnertipo = (Spinner) findViewById(R.id.spinnerTipo);
        titulo = etTitulo.getText().toString();
        descripcion = etDescripcion.getText().toString();
        precio = Integer.parseInt(etPrecio.getText().toString());
        tipo = spinnertipo.getSelectedItem().toString();
    }

    private void registrarMenu(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "bd_orden",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();

        ContentValues values=new ContentValues();
        int id = 1;
        values.put(Utilidades.CAMPO_ID,id);
        values.put(Utilidades.CAMPO_TITULO,titulo);
        values.put(Utilidades.CAMPO_DESCRIPCION,descripcion);
        values.put(Utilidades.CAMPO_PRECIO,precio);
        values.put(Utilidades.CAMPO_TIPO,tipo);
        Long idResultante = db.insert(Utilidades.TABLA_ORDEN,Utilidades.CAMPO_ID,values);
        db.close();
        Toast.makeText(getApplicationContext(),"Agregado al menú con éxito",Toast.LENGTH_SHORT).show();

    }
    private void limpiarActivity() {
        EditText etTitulo = (EditText) findViewById(R.id.etTitulo);
        EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        EditText etPrecio = (EditText) findViewById(R.id.etPrecio);
        etTitulo.setText("");
        etDescripcion.setText("");
        etPrecio.setText("");
    }

}


