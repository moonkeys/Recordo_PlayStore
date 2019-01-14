package com.example.gmax1.recordo_playstore.repository;

import android.arch.lifecycle.LiveData;

import com.example.gmax1.recordo_playstore.dao.InstrumentDao;
import com.example.gmax1.recordo_playstore.models.Instrument;

import java.util.List;

public class InstrumentDataRepository {

    private final InstrumentDao instrumentDao;

    public InstrumentDataRepository(InstrumentDao instrumentDao) { this.instrumentDao = instrumentDao; }

    // --- GET ---

    public LiveData<List<Instrument>> getInstruments(long presetId){ return this.instrumentDao.getInstruments(presetId); }

    // --- CREATE ---

    public void createInstrument(Instrument item){ instrumentDao.insertInstrument(item); }

    // --- DELETE ---
    public void deleteInstrument(long itemId){ instrumentDao.deleteInstrument(itemId); }

    // --- UPDATE ---
    public void updateInstrument(Instrument item){ instrumentDao.updateInstrument(item); }
}
