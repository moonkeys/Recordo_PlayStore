package com.example.gmax1.recordo_playstore.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.gmax1.recordo_playstore.models.Preset;

@Dao
public interface PresetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createPreset(Preset preset);

    @Query("SELECT * FROM Preset WHERE id = :presetId")
    LiveData<Preset> getPreset(long presetId);



}
