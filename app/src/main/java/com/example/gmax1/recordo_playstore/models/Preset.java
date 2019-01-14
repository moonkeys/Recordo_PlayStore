package com.example.gmax1.recordo_playstore.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Preset {

    @PrimaryKey
    private long id;
    private String nomPreset;


    public Preset() {}

    public Preset(long id,String nomPreset) {
        this.id = id;
        this.nomPreset = nomPreset;
    }

    // GETTER
    public String getNomPreset() {return nomPreset;}
    public long getId() {return id;}

    //SETTER
    public void setNomPreset(String nomPreset) {this.nomPreset = nomPreset;}
    public void setId(long id) {this.id = id;}
}
