package com.example.alejandro.fastcoffee.dueño;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.service.autofill.Dataset;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alejandro.fastcoffee.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class graficas extends AppCompatActivity {

    private int a=15;
    private String dia, mes, ano;
    private BarChart barchart;
    private String[]dias=new String[]{"Ventas","Ganancias"};
    private int[]ganancia;
    private int[]color=new int[]{Color.RED,Color.GREEN,Color.GREEN,Color.RED,Color.YELLOW};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas);
        barchart=(BarChart)findViewById(R.id.barra);


        SharedPreferences pref = getSharedPreferences("contadores", Context.MODE_PRIVATE);
        int ganancias = pref.getInt("ganancia", 0);
        int ventas = pref.getInt("venta",0);

        ganancia=new int[]{ventas,ganancias};



        createCharts();

    }
    private Chart getSameChart(Chart chart,String description,int textcolor, int background, int animateY){
        chart.getDescription().setText(description);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
        return chart;
    }
    private void legend (Chart chart){
        Legend legend=chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ArrayList<LegendEntry>entries=new ArrayList<>();
        for ( int i=0;i<dias.length;i++){
            LegendEntry entry=new LegendEntry();
            entry.formColor=color[i];
            entry.label=dias[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }
    private ArrayList<BarEntry>getBarEntries(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i=0; i< ganancia.length;i++)
            entries.add(new BarEntry(i,ganancia[i]));
        return entries;

    }
    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(dias));
    }
    private void axisLeft(YAxis axis){
        axis.setSpaceTop(30);
        axis.setAxisMinimum(0);
    }
    private  void axisRight(YAxis axis){
        axis.setEnabled(false);
    }
    public void createCharts(){
        barchart=(BarChart)getSameChart(barchart,"",Color.BLACK,Color.WHITE,3000);
        barchart.setDrawGridBackground(true);
        barchart.setDrawBarShadow(true);
        barchart.setData(getBarData());
        barchart.invalidate();
        axisX(barchart.getXAxis());
        axisLeft(barchart.getAxisLeft());
        axisRight(barchart.getAxisRight());

    }
    private DataSet getData(DataSet dataSet){
        dataSet.setColors(color);
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(15);
        return dataSet;

    }
    private BarData getBarData(){
        BarDataSet barDataSet=(BarDataSet)getData(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.WHITE);
        BarData barData= new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }

}
