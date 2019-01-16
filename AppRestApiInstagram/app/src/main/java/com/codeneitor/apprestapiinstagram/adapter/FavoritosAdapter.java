package com.codeneitor.apprestapiinstagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codeneitor.apprestapiinstagram.MascotaDetalle;
import com.codeneitor.apprestapiinstagram.R;
import com.codeneitor.apprestapiinstagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by b41n on 14/01/19.
 */

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.FavoritosViewHolder> {
    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public FavoritosAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public FavoritosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new FavoritosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FavoritosViewHolder favoritosViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        //favoritosViewHolder.imvMascota.setImageResource(mascota.getUrlFoto());
        favoritosViewHolder.tvMascotaNombre.setText(mascota.getNombreCompleto());
        favoritosViewHolder.tvMascotaLikes.setText(String.valueOf(mascota.getLikes()));

        favoritosViewHolder.imvMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, MascotaDetalle.class);
                intent.putExtra(activity.getResources().getString(R.string.pfoto), mascota.getUrlFoto());
                intent.putExtra(activity.getResources().getString(R.string.pnombre), mascota.getNombreCompleto());
                intent.putExtra(activity.getResources().getString(R.string.plikes), mascota.getLikes());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class FavoritosViewHolder extends RecyclerView.ViewHolder{

        private ImageView imvMascota;
        private TextView tvMascotaNombre;
        private TextView tvMascotaLikes;

        public FavoritosViewHolder(View itemView) {
            super(itemView);
            imvMascota = (ImageView) itemView.findViewById(R.id.imvMascota);
            tvMascotaNombre = (TextView) itemView.findViewById(R.id.tvMascotaNombre);
            tvMascotaLikes =(TextView) itemView.findViewById(R.id.tvMascotaLikes);
        }
    }
}