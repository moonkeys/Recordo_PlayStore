package com.example.gmax1.recordo_playstore.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gmax1.recordo_playstore.R;
import com.example.gmax1.recordo_playstore.models.Instrument;

import java.util.ArrayList;
import java.util.List;

public class InstrumentAdapter extends RecyclerView.Adapter<InstrumentViewHolder>{

    // CALLBACK
    public interface Listener { void onClickDeleteButton(int position); }
    private final Listener callback;

    //FOR DATA
    private List<Instrument> instruments;

    // CONSTRUCTOR
    public InstrumentAdapter(Listener callback) {
        this.instruments = new ArrayList<>();
        this.callback = callback;
    }

    @Override
    public InstrumentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.presets, parent, false);

        return new InstrumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InstrumentViewHolder viewHolder, int position) {
        viewHolder.updateWithInstrument(this.instruments.get(position), this.callback);
    }

    @Override
    public int getItemCount() {
        return this.instruments.size();
    }

    public Instrument getInstrument(int position){
        return this.instruments.get(position);
    }

    public void updateData(List<Instrument> instruments){
        this.instruments = instruments;
        this.notifyDataSetChanged();
    }


}
