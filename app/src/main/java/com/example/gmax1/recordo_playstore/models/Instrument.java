package com.example.gmax1.recordo_playstore.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.content.ContentValues;

@Entity(foreignKeys = @ForeignKey(entity = Preset.class,
        parentColumns = "id",
        childColumns = "presetId"))

public class Instrument {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nomInstrument;
    private float nbdB;
    private boolean isSelected;
    private long presetId;

    public Instrument(){}

    public Instrument(String nomInstruments, float nbdB, long presetId) {
        this.presetId = presetId;
        this.nomInstrument = nomInstruments;
        this.nbdB = nbdB;
        this.isSelected = false;
    }

    public float getNbdB() {return nbdB;}
    public String getNomInstrument() {return nomInstrument;}
    public boolean getSelected() {return isSelected;}
    public long getId() {return id;}
    public long getPresetId() {return presetId;}

    public void setPresetId(long idPreset) {this.presetId = idPreset;}
    public void setId(long idPreset) {this.id = idPreset;}
    public void setNomInstrument(String nomInstruments) {this.nomInstrument = nomInstruments; }
    public void setNbdB(float nbdB) {this.nbdB = nbdB;}
    public void setSelected(boolean isSelected) {this.isSelected = isSelected;}

    // --- UTILS ---
    public static Instrument fromContentValues(ContentValues values) {
        final Instrument instrument = new Instrument();
        if (values.containsKey("text")) instrument.setNomInstrument(values.getAsString("nomInstrument"));
        if (values.containsKey("category")) instrument.setNbdB(values.getAsInteger("0"));
        if (values.containsKey("isSelected")) instrument.setSelected(values.getAsBoolean("isSelected"));
        if (values.containsKey("userId")) instrument.setPresetId(values.getAsLong("presetId"));
        return instrument;
    }
}
