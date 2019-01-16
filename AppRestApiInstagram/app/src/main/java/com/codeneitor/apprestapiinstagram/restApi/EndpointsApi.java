package com.codeneitor.apprestapiinstagram.restApi;

import com.codeneitor.apprestapiinstagram.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by b41n on 15/01/19.
 */

public interface EndpointsApi {

    // Definimos la petición hacia el Enpoint
    @GET(ConstRestApi.URL_MEDIA_RECENT)
    Call<MascotaResponse> getRecentMedia();
}
