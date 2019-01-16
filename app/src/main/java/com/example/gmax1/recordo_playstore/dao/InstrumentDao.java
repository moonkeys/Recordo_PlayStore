package com.example.gmax1.recordo_playstore.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;
import com.example.gmax1.recordo_playstore.models.Instrument;

import java.util.List;

@Dao
public interface InstrumentDao {

    @Query("SELECT * FROM Instrument WHERE presetId = :presetId")
    LiveData<List<Instrument>> getInstruments(long presetId);

    @Query("SELECT * FROM Instrument WHERE presetId = :presetId")
    Cursor getInstrumentsWithCursor(long presetId);

    @Insert
    long insertInstrument(Instrument instrument);

    @Update
    int updateInstrument(Instrument instrument);

    @Query("DELETE FROM Instrument WHERE id = :instrumentId")
    int deleteInstrument(long instrumentId);
}
