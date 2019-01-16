package com.codeneitor.apprestapiinstagram.view.fragment;

import com.codeneitor.apprestapiinstagram.pojo.Mascota;
import com.codeneitor.apprestapiinstagram.adapter.MascotaAdapter;

import java.util.ArrayList;

/**
 * Created by b41n on 3/01/19.
 */

public interface IRecyclerViewFragmentView {
    //public void generarLinearLayoutVertical();
    public void generarGridLayout();

    public MascotaAdapter crearAdapter(ArrayList<Mascota> contactos);

    public void inicializarAdapterRV(MascotaAdapter adaptador);
}
