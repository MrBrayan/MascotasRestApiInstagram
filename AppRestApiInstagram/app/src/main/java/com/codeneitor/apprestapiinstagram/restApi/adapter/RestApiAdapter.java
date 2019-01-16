package com.codeneitor.apprestapiinstagram.restApi.adapter;

import com.codeneitor.apprestapiinstagram.restApi.ConstRestApi;
import com.codeneitor.apprestapiinstagram.restApi.EndpointsApi;
import com.codeneitor.apprestapiinstagram.restApi.deserializador.MascotaDeserializador;
import com.codeneitor.apprestapiinstagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by b41n on 15/01/19.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstRestApi.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson consytruirGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }
}
