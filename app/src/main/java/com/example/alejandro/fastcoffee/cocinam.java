package com.example.alejandro.fastcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alejandro.fastcoffee.cocina.Cocinero;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cocinam extends AppCompatActivity {
    private ListView lv1;
    private FirebaseDatabase database;
    public String mesaref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocinam);
        lv1= (ListView)findViewById(R.id.list1);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mesaref = ref.child("productos");


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item,
                    getResources().getStringArray(R.array.mesas));

            lv1.setAdapter(adapter);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(cocinam.this, Cocinero.class);
                    startActivity(intent);
                }
            });

    }
}
