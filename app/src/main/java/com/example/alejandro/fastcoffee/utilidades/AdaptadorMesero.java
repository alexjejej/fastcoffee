package com.example.alejandro.fastcoffee.utilidades;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alejandro.fastcoffee.R;

import java.util.List;

public class AdaptadorMesero extends RecyclerView.Adapter<AdaptadorMesero.meseroRvviewHolder>implements View.OnClickListener{

    List<meseroRv> meserorv;

    private View.OnClickListener listener;

    public AdaptadorMesero(List<meseroRv> meserorv) {
        this.meserorv = meserorv;
    }

    @NonNull
    @Override
    public meseroRvviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_productos_mesero,parent, false);
        meseroRvviewHolder holder = new meseroRvviewHolder(v);
        v.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMesero.meseroRvviewHolder holder, int position) {
        meseroRv meseroR = meserorv.get(position);
        holder.textViewMesa.setText(meseroR.getEstado());
        holder.textViewProductos.setText(meseroR.getProducto());
        holder.textViewidp.setText(meseroR.getMesa());
        holder.textViewid.setText(String.valueOf(meseroR.getIdp()));
        holder.textViewkey.setText(meseroR.getId());

    }

    @Override
    public int getItemCount() {
        return meserorv.size();
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

    public static class meseroRvviewHolder extends RecyclerView.ViewHolder{

        TextView textViewMesa, textViewProductos, textViewidp, textViewid, textViewkey;

        public meseroRvviewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMesa = (TextView) itemView.findViewById(R.id.textViewEstadomesero);
            textViewProductos = (TextView) itemView.findViewById(R.id.textViewProductomesero);
            textViewidp = (TextView) itemView.findViewById(R.id.textViewMesamesero);
            textViewid = (TextView) itemView.findViewById(R.id.textViewidmesero);
            textViewkey = (TextView) itemView.findViewById(R.id.textViewkey);

        }
    }
}