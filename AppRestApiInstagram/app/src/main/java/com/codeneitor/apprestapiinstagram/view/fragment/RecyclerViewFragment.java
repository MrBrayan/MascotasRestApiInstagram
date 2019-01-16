package com.codeneitor.apprestapiinstagram.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeneitor.apprestapiinstagram.R;
import com.codeneitor.apprestapiinstagram.adapter.MascotaAdapter;
import com.codeneitor.apprestapiinstagram.pojo.Mascota;
import com.codeneitor.apprestapiinstagram.presenter.IRecyclerViewFragmentPresenter;
import com.codeneitor.apprestapiinstagram.presenter.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by b41n on 3/01/19.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    /*
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

    }
    */

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        rvMascotas.setLayoutManager(glm);
    }

    @Override
    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, getActivity()  );
        return adapter;
    }

    @Override
    public void inicializarAdapterRV(MascotaAdapter adapter) {
        rvMascotas.setAdapter(adapter);
    }
}
