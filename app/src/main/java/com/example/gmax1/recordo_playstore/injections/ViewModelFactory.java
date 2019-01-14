package com.example.gmax1.recordo_playstore.injections;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.gmax1.recordo_playstore.repository.InstrumentDataRepository;
import com.example.gmax1.recordo_playstore.repository.PresetDataRepository;
import com.example.gmax1.recordo_playstore.views.InstrumentViewModel;

import java.util.concurrent.Executor;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final InstrumentDataRepository instrumentDataSource;
    private final PresetDataRepository presetDataSource;
    private final Executor executor;

    public ViewModelFactory(InstrumentDataRepository instrumentDataSource, PresetDataRepository presetDataSource, Executor executor) {
        this.instrumentDataSource = instrumentDataSource;
        this.presetDataSource= presetDataSource;
        this.executor = executor;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(InstrumentViewModel.class)) {
            return (T) new InstrumentViewModel(instrumentDataSource, presetDataSource, executor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}