package com.codeneitor.apprestapiinstagram.pojo;

/**
 * Created by b41n on 3/01/19.
 */

public class Mascota {
    private String id;
    private String urlFoto;
    private String nombreCompleto;
    private int likes = 0;

    public Mascota(){

    }
    public Mascota(String urlFoto, int likes){
        this.urlFoto = urlFoto;
        this.likes = likes;
    }

    public Mascota(String urlFoto, String nombreCompleto, int likes) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

}
