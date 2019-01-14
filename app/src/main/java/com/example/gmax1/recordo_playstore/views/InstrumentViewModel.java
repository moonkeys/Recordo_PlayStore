package com.example.gmax1.recordo_playstore.views;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.example.gmax1.recordo_playstore.models.Instrument;
import com.example.gmax1.recordo_playstore.models.Preset;
import com.example.gmax1.recordo_playstore.repository.InstrumentDataRepository;
import com.example.gmax1.recordo_playstore.repository.PresetDataRepository;

import java.util.List;
import java.util.concurrent.Executor;


public class InstrumentViewModel extends ViewModel {

    // REPOSITORIES
    private final InstrumentDataRepository instrumentDataSource;
    private final PresetDataRepository presetDataSource;
    private final Executor executor;

    // DATA
    @Nullable
    private LiveData<Preset> currentPreset;

    public InstrumentViewModel(InstrumentDataRepository itemDataSource, PresetDataRepository userDataSource, Executor executor) {
        this.instrumentDataSource = itemDataSource;
        this.presetDataSource = userDataSource;
        this.executor = executor;
    }

    public void init(long presetId) {
        if (this.currentPreset != null) {
            return;
        }
        currentPreset = presetDataSource.getPreset(presetId);
    }

    // -------------
    // FOR USER
    // -------------

    public LiveData<Preset> getPreset(long presetId) { return this.currentPreset;  }

    // -------------
    // FOR ITEM
    // -------------

    public LiveData<List<Instrument>> getInstruments(long presetId) {
        return instrumentDataSource.getInstruments(presetId);
    }

    public void createInstrument(Instrument instrument) {
        executor.execute(() -> {
            instrumentDataSource.createInstrument(instrument);
        });
    }

    public void deleteInstrument(long instrumentId) {
        executor.execute(() -> {
            instrumentDataSource.deleteInstrument(instrumentId);
        });
    }

    public void updateInstrument(Instrument instrument) {
        executor.execute(() -> {
            instrumentDataSource.updateInstrument(instrument);
        });
    }
}