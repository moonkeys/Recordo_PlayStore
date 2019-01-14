package com.example.gmax1.recordo_playstore.repository;

import android.arch.lifecycle.LiveData;

import com.example.gmax1.recordo_playstore.dao.PresetsDao;
import com.example.gmax1.recordo_playstore.models.Preset;

public class PresetDataRepository {

    private final PresetsDao presetDao;

    public PresetDataRepository(PresetsDao presetDao) { this.presetDao = presetDao; }

    // --- GET USER ---
    public LiveData<Preset> getPreset(long presetId) { return this.presetDao.getPreset(presetId); }
}
