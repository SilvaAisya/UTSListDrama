package com.silvaaisya.listdrama.Entities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Drama extends AppCompatActivity {

    private int id;
    private String nama;
    private String nomor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

}