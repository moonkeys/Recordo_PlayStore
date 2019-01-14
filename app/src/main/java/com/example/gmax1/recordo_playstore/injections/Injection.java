package com.example.gmax1.recordo_playstore.injections;

import android.content.Context;

import com.example.gmax1.recordo_playstore.dao.SaveMyPresetsDatabase;
import com.example.gmax1.recordo_playstore.repository.InstrumentDataRepository;
import com.example.gmax1.recordo_playstore.repository.PresetDataRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Injection {
    public static InstrumentDataRepository provideInstrumentDataSource(Context context) {
        SaveMyPresetsDatabase database = SaveMyPresetsDatabase.getInstance(context);
        return new InstrumentDataRepository(database.instrumentDao());
    }

    public static PresetDataRepository providePresetDataSource(Context context) {
        SaveMyPresetsDatabase database = SaveMyPresetsDatabase.getInstance(context);
        return new PresetDataRepository(database.presetsDao());
    }

    public static Executor provideExecutor(){ return Executors.newSingleThreadExecutor(); }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        InstrumentDataRepository dataSourceInstrument = provideInstrumentDataSource(context);
        PresetDataRepository dataSourcePreset = providePresetDataSource(context);
        Executor executor = provideExecutor();
        return new ViewModelFactory(dataSourceInstrument, dataSourcePreset, executor);
    }
}