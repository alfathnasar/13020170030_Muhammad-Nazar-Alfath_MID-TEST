package com.example.projek4;

public class FilmDetails {
    private String nama;
    private int photocast;

    public FilmDetails(String nama, int photocast) {
        this.nama = nama;
        this.photocast = photocast;
    }

    public String getNama() {
        return nama;
    }

    public int getPhotocast() {
        return photocast;
    }
}
