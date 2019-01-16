package com.codeneitor.apprestapiinstagram.restApi;

/**
 * Created by b41n on 15/01/19.
 */

public final class ConstRestApi {

    public static final String VERSION = "/v1/";
    //https://api.instagram.com/v1/
    // Esta URL la trabajamos con retrofit
    public static final String URL_BASE = "https://api.instagram.com"+VERSION;
    public static final String ACCESS_TOKEN = "3537875915.a78b20b.5d3c1fa38ccf47b8938fad740d5e9303";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_MEDIA_RECENT = "users/self/media/recent/";

    public static final String URL_MEDIA_RECENT =KEY_MEDIA_RECENT+KEY_ACCESS_TOKEN+ACCESS_TOKEN;

    //URL para obtener las fotos recientes.
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=
}
