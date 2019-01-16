package com.codeneitor.apprestapiinstagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.codeneitor.apprestapiinstagram.R;
import com.codeneitor.apprestapiinstagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by b41n on 14/01/19.
 */

public class ConstructorMascotas {
    // esta clase es llamada también Interactor pues interactua y sirve de intermediario con la clase que
    // consulta la base de datos. esta clase es clave para switchear entre las fuentes de datos

    public static final int LIKES = 1;
    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotas(){

        BaseDatos db = new BaseDatos(context);
        /*
        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.garfield,"Garfield",123));
        mascotas.add(new Mascota(R.drawable.oddie,"Oddie",145));
        mascotas.add(new Mascota(R.drawable.gyo2,"Garfield y Oddie",145));
        mascotas.add(new Mascota(R.drawable.gyo,"Garfield y Oddie",875));
        mascotas.add(new Mascota(R.drawable.huella_perro,"Dog",564));
        return mascotas;
        */
        insertarMascotaDB(db);
        return db.obtenerMascotasBD();
    }

    public void insertarMascotaDB(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstDB.TABLE_PETS_NOMBRE,"Brayan");
        contentValues.put(ConstDB.TABLE_PETS_FOTO,R.drawable.garfield);
        db.insertarMascotaDB(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstDB.TABLE_PETS_NOMBRE,"Mauricio");
        contentValues.put(ConstDB.TABLE_PETS_FOTO,R.drawable.gyo2);
        db.insertarMascotaDB(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstDB.TABLE_PETS_NOMBRE,"Novoa");
        contentValues.put(ConstDB.TABLE_PETS_FOTO,R.drawable.gyo);
        db.insertarMascotaDB(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstDB.TABLE_PETS_NOMBRE,"Salazar");
        contentValues.put(ConstDB.TABLE_PETS_FOTO,R.drawable.oddie);
        db.insertarMascotaDB(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstDB.TABLE_LIKES_PET_ID_PET, mascota.getId());
        contentValues.put(ConstDB.TABLE_LIKES_PET_NUMERO_LIKES,LIKES);
        db.insertarLikeMascotaDB(contentValues);

    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascotaDB(mascota);
    }

}
//OK