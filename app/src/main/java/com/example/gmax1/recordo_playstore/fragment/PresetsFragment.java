package com.example.gmax1.recordo_playstore.fragment;

import android.app.ActionBar;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gmax1.recordo_playstore.R;
import com.example.gmax1.recordo_playstore.injections.Injection;
import com.example.gmax1.recordo_playstore.injections.ViewModelFactory;
import com.example.gmax1.recordo_playstore.models.Instrument;
import com.example.gmax1.recordo_playstore.models.Preset;
import com.example.gmax1.recordo_playstore.views.InstrumentAdapter;
import com.example.gmax1.recordo_playstore.views.InstrumentViewModel;
import com.example.gmax1.recordo_playstore.views.ItemClickSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

public class PresetsFragment extends BaseActivity implements InstrumentAdapter.Listener {

    // FOR DESIGN
    @BindView(R.id.preset_recyclerView) RecyclerView recyclerView; // 1 - Declare RecyclerView
    @BindView(R.id.todo_list_activity_spinner) Spinner spinner;
    @BindView(R.id.todo_list_activity_edit_text) EditText editText;
    @BindView(R.id.preset_list_fragment_header_nomPreset) TextView profileText;

    //FOR DATA
    //Declare list of presets (Presets) & Adapter
    private InstrumentViewModel instrumentViewModel;
    private InstrumentAdapter adapter;
    private static int PRESET_ID = 1;

    @Override
    public int getLayoutContentViewID() {
        return R.layout.fragment_presets;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Configure RecyclerView & ViewModel
        this.configureRecyclerView();
        this.configureViewModel();

        this.getCurrentPreset(PRESET_ID);
        this.getInstruments(PRESET_ID);

        this.configureToolbar();
        //this.configureSpinner();

    }
    /*
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();
    }

    // -----------------
    // CONFIGURATION
    // -----------------

    private void disposeWhenDestroy(){
        if (this.disposable != null && !this.disposable.isDisposed()) this.disposable.dispose();
    }*/

    // ----- ACTIONS --------


    @OnClick(R.id.buttonAddInstrument)
    public void onClickAddButton() {
        // 7 - Create item after user clicked on button
        this.createInstrument();
    }


    @Override
    public void onClickDeleteButton(int position) {
        this.deleteInstrument(this.adapter.getInstrument(position));
    }

    // -------------------
    // DATA
    // -------------------

    // Configuring ViewModel
    private void configureViewModel(){
        ViewModelFactory mViewModelFactory = Injection.provideViewModelFactory(this);
        this.instrumentViewModel = ViewModelProviders.of(this, mViewModelFactory).get(InstrumentViewModel.class);
        this.instrumentViewModel.init(PRESET_ID);
    }

    // ---

    // Get Current User
    private void getCurrentPreset(int presetId){
        this.instrumentViewModel.getPreset(presetId).observe(this, this::updateHeader);
    }

    // ---

    // 3 - Get all items for a user
    private void getInstruments(int presetId){
        this.instrumentViewModel.getInstruments(presetId).observe(this, this::updateInstrumentsList);
    }

    // Create a new item
    private void createInstrument(){
        Instrument instrument = new Instrument(
                this.editText.getText().toString(),
                this.spinner.getSelectedItemPosition(),
                PRESET_ID);
        this.editText.setText("");
        this.instrumentViewModel.createInstrument(instrument);
    }

    // Delete an instrument
    private void deleteInstrument(Instrument instrument){
        this.instrumentViewModel.deleteInstrument(instrument.getId());
    }

    // Update an instrument (selected or not)
    private void updateInstrument(Instrument instrument){
        instrument.setSelected(!instrument.getSelected());
        this.instrumentViewModel.updateInstrument(instrument);
    }

    // -------------------
    // UI
    // -------------------



    // Configure RecyclerView
    private void configureRecyclerView(){
        this.adapter = new InstrumentAdapter(this);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemClickSupport.addTo(recyclerView, R.layout.presets)
                .setOnItemClickListener((recyclerView1, position, v) -> this.updateInstrument(this.adapter.getInstrument(position)));
    }

    // Update header (username & picture)
    private void updateHeader(Preset preset){
        this.profileText.setText(preset.getNomPreset());
        //Glide.with(this).load(preset.getUrlPicture()).apply(RequestOptions.circleCropTransform()).into(this.profileImage);
    }
    //Update the list of instruments
    private void updateInstrumentsList(List<Instrument> instruments){
        this.adapter.updateData(instruments);
    }

   /* private void configureSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }*/

    /*protected void configureToolbar(){
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }*/

}
