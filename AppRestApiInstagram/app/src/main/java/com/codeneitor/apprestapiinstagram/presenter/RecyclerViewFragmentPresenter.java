package com.codeneitor.apprestapiinstagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.codeneitor.apprestapiinstagram.db.ConstructorMascotas;
import com.codeneitor.apprestapiinstagram.pojo.Mascota;
import com.codeneitor.apprestapiinstagram.restApi.EndpointsApi;
import com.codeneitor.apprestapiinstagram.restApi.adapter.RestApiAdapter;
import com.codeneitor.apprestapiinstagram.restApi.model.MascotaResponse;
import com.codeneitor.apprestapiinstagram.view.fragment.IRecyclerViewFragmentView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by b41n on 14/01/19.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        //obtenerMascotasDB();
        obtenerMediosRecientes();
    }


    @Override
    public void obtenerMascotasDB() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        //Definimos un objeto de tipo RestApiAdapter
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.consytruirGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                //
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Error obteniendo los datos de Instagram", Toast.LENGTH_SHORT).show();
                Log.e("FALLÓ LA CONEXIÓN",t.toString());
            }
        });


    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdapterRV(iRecyclerViewFragmentView.crearAdapter(mascotas));
        //iRecyclerViewFragmentView.generarLinearLayoutVertical();
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
