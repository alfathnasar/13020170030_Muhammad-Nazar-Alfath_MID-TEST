package com.example.projek4;

public class Film {
    String judul, desc, genre, durasi, sutradara, tahun;
    int photo;

    public Film(String judul, String desc, String genre, String durasi, String sutradara, String tahun, int photo) {
        this.judul = judul;
        this.desc = desc;
        this.genre = genre;
        this.durasi = durasi;
        this.sutradara = sutradara;
        this.tahun = tahun;
        this.photo = photo;
    }

    public String getJudul() {
        return judul;
    }

    public String getDesc() {
        return desc;
    }

    public String getGenre() {
        return genre;
    }

    public String getDurasi() {
        return durasi;
    }

    public String getSutradara() {
        return sutradara;
    }

    public String getTahun() {
        return tahun;
    }

    public int getPhoto() {
        return photo;
    }
}
