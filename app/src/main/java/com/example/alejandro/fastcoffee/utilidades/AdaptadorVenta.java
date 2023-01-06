package com.example.alejandro.fastcoffee.utilidades;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.alejandro.fastcoffee.R;

import java.util.List;

public class AdaptadorVenta extends RecyclerView.Adapter<AdaptadorVenta.ViewHolderDatos> {

    List <ventaRv> ventarv;

    public AdaptadorVenta(List<ventaRv> ventarv) {
        this.ventarv = ventarv;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gananciasrv, null, false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int i) {
        ventaRv venta = ventarv.get(i);
        holder.txtcantidad.setText(String.valueOf(venta.getCantidad())+" gr/ml");
        holder.txtproducto.setText(venta.getProducto());
        holder.txtcosto.setText("$"+String.valueOf(venta.getCosto()));

    }

    @Override
    public int getItemCount() {
        return ventarv.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txtproducto, txtcosto, txtcantidad;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtproducto = (TextView) itemView.findViewById(R.id.txtproducto);
            txtcosto = (TextView) itemView.findViewById(R.id.txtcosto);
            txtcantidad = (TextView) itemView.findViewById(R.id.txtcantidad);

        }
    }
}
