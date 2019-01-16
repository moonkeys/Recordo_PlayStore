package com.example.gmax1.recordo_playstore.dao;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.gmax1.recordo_playstore.models.Instrument;
import com.example.gmax1.recordo_playstore.models.Preset;

@Database(entities = {Instrument.class, Preset.class}, version = 1, exportSchema = false)

public abstract class SaveMyPresetsDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile SaveMyPresetsDatabase INSTANCE;

    // --- DAO ---
    public abstract InstrumentDao instrumentDao();
    public abstract PresetsDao presetsDao();

    // --- INSTANCE ---
    public static SaveMyPresetsDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SaveMyPresetsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SaveMyPresetsDatabase.class, "MyDatabase.db")
                            .addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // ---

    ////// Changer valeurs insertion table
    private static Callback prepopulateDatabase(){
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                ContentValues contentValues = new ContentValues();
                contentValues.put("id", 1);
                contentValues.put("nomPreset", "Preset");

                db.insert("Preset", OnConflictStrategy.IGNORE, contentValues);
            }
        };
    }
}
