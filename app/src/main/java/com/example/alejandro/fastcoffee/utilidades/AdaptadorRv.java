package com.example.alejandro.fastcoffee.utilidades;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.alejandro.fastcoffee.R;
import java.util.List;

public class AdaptadorRv extends RecyclerView.Adapter<AdaptadorRv.entradas>implements View.OnClickListener{

    List<entradasRv> listaentradas;

    private View.OnClickListener listener;


    public AdaptadorRv(List<entradasRv> listaentradas) {
        this.listaentradas = listaentradas;
    }

    @NonNull
    @Override
    public entradas onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.vistarv, parent, false);
        entradas entradas = new entradas(v);
        v.setOnClickListener(this);
        return entradas;
    }

    @Override
    public void onBindViewHolder(@NonNull entradas entradas, int position) {
        entradas.imagenent.setImageResource(listaentradas.get(position).getImageEntradas());
        entradas.titulo.setText(listaentradas.get(position).getTitulo());
        entradas.descripcion.setText(listaentradas.get(position).getDescripcion());
        entradas.precio.setText(listaentradas.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return listaentradas.size();
    }

    public void setOnClickListener(View.OnClickListener v){
        this.listener=v;
    }

    @Override
    public void onClick(View v) {

        if (listener!=null){
            listener.onClick(v);
        }
    }


    public static class entradas extends RecyclerView.ViewHolder{

        ImageView imagenent;
        TextView titulo, descripcion, precio;

        public entradas(@NonNull View itemView) {
            super(itemView);
            imagenent = (ImageView)itemView.findViewById(R.id.imagen);
            titulo = (TextView)itemView.findViewById(R.id.tvTipo);
            descripcion = (TextView)itemView.findViewById(R.id.tvDescripcion);
            precio = (TextView) itemView.findViewById(R.id.tvPrecio);
        }
    }
}
