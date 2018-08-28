package com.androidapps.royrga.bdapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import java.lang.reflect.Array;
import java.util.ArrayList;


public class MyAdapterConsult extends RecyclerView.Adapter<MyAdapterConsult.ViewHolderUsuarios> {

    ArrayList<String> listUsuarios;

    public MyAdapterConsult(ArrayList<String> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    @NonNull
    @Override
    public ViewHolderUsuarios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);
        return new ViewHolderUsuarios(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUsuarios holder, int position) {
//        String[] NombreEdad=listUsuarios.get(position).split(" ");
//        holder.rvnombre.setText(NombreEdad[0]);
//        holder.rvedad.setText(NombreEdad[1]);
        holder.rvactividad.setText(listUsuarios.get(position));
    }

    @Override
    public int getItemCount() {
        return listUsuarios.size();
    }

    public class ViewHolderUsuarios extends RecyclerView.ViewHolder {

//        TextView rvnombre;
//        TextView rvedad;
        TextView rvactividad;


        public ViewHolderUsuarios(View itemView) {
            super(itemView);
                rvactividad = itemView.findViewById(R.id.NombreActivity);
//            rvnombre=itemView.findViewById(R.id.Nombre);
//            rvedad=itemView.findViewById(R.id.edad);

        }
    }
}
