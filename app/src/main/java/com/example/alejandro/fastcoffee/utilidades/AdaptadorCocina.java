package com.example.alejandro.fastcoffee.utilidades;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alejandro.fastcoffee.R;

import java.util.List;

public class AdaptadorCocina extends RecyclerView.Adapter<AdaptadorCocina.cocinaRvviewHolder>implements View.OnClickListener{

    List<cocinaRv> cocinarv;

    private View.OnClickListener listener;

    public AdaptadorCocina(List<cocinaRv> cocinarv) {
        this.cocinarv = cocinarv;
    }

    @NonNull
    @Override
    public cocinaRvviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_productos,parent, false);
        cocinaRvviewHolder holder = new cocinaRvviewHolder(v);
        v.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull cocinaRvviewHolder holder, int position) {
        cocinaRv cocinaR = cocinarv.get(position);
        holder.textViewMesa.setText(cocinaR.getEstado());
        holder.textViewProductos.setText(cocinaR.getProducto());
        holder.textViewidp.setText(cocinaR.getMesa());
        holder.textViewid.setText(cocinaR.getId());

    }

    @Override
    public int getItemCount() {
        return cocinarv.size();
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

    public static class cocinaRvviewHolder extends RecyclerView.ViewHolder{

        TextView textViewMesa, textViewProductos, textViewidp, textViewid;

        public cocinaRvviewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMesa = (TextView) itemView.findViewById(R.id.textViewEstado);
            textViewProductos = (TextView) itemView.findViewById(R.id.textViewProducto);
            textViewidp = (TextView) itemView.findViewById(R.id.textViewMesa);
            textViewid = (TextView) itemView.findViewById(R.id.textViewid);

        }
    }
}