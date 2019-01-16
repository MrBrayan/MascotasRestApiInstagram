package com.codeneitor.apprestapiinstagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codeneitor.apprestapiinstagram.MascotaDetalle;
import com.codeneitor.apprestapiinstagram.R;
import com.codeneitor.apprestapiinstagram.db.ConstructorMascotas;
import com.codeneitor.apprestapiinstagram.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by b41n on 3/01/19.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        //Imagen para implementar con Picaso
        //mascotaViewHolder.imvMascota.setImageResource(mascota.getUrlFoto());
        Picasso.get()
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.gyo2)
                .into(mascotaViewHolder.imvMascota);
        //mascotaViewHolder.tvMascotaNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvMascotaLikes.setText(String.valueOf(mascota.getLikes())+ " ");

        mascotaViewHolder.imvMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombreCompleto(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, MascotaDetalle.class);
                intent.putExtra("url", mascota.getUrlFoto());
                //intent.putExtra(activity.getResources().getString(R.string.pnombre), mascota.getNombre());
                intent.putExtra("like", mascota.getLikes());
                activity.startActivity(intent);

            }
        });

        /*
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();
                // en este caso nuestro activity representa el context
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvMascotaLikes.setText(constructorMascotas.obtenerLikesMascota(mascota)+" "+ activity.getString(R.string.plikes));

            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imvMascota;
        //private TextView tvMascotaNombre;
        //private ImageButton btnLike;
        private TextView tvMascotaLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imvMascota = (ImageView) itemView.findViewById(R.id.imvMascota);
            //tvMascotaNombre = (TextView) itemView.findViewById(R.id.tvMascotaNombre);
            tvMascotaLikes =(TextView) itemView.findViewById(R.id.tvMascotaLikes);
            //btnLike = (ImageButton) itemView.findViewById(R.id.imgBone1);
        }
    }
}
