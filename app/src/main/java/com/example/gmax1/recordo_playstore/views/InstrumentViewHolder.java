package com.example.gmax1.recordo_playstore.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gmax1.recordo_playstore.R;
import com.example.gmax1.recordo_playstore.models.Instrument;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstrumentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.nomInstrument) TextView nomInstrumentTestView;
    @BindView(R.id.nbdB) TextView nbdBTestView;
    @BindView(R.id.presets_record) ImageButton imageButton;

    // FOR DATA
    private WeakReference<InstrumentAdapter.Listener> callbackWeakRef;

    public InstrumentViewHolder(View instrumentView) {
        super(instrumentView);
        ButterKnife.bind(this, instrumentView);
    }

    public void updateWithInstrument(Instrument instrument, InstrumentAdapter.Listener callback){
        this.callbackWeakRef = new WeakReference<InstrumentAdapter.Listener>(callback);
        this.nomInstrumentTestView.setText(instrument.getNomInstrument());
        this.nbdBTestView.setText(Float.toString(instrument.getNbdB()));
        this.imageButton.setOnClickListener(this); //Bouton enregistrer instument
    }


    public void onClick(View view) {
        InstrumentAdapter.Listener callback = callbackWeakRef.get();
        if (callback != null) callback.onClickDeleteButton(getAdapterPosition());
    }
}
