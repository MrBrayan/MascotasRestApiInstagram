package com.codeneitor.apprestapiinstagram.restApi.model;

import com.codeneitor.apprestapiinstagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by b41n on 15/01/19.
 */

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
