package com.example.gmax1.recordo_playstore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gmax1.recordo_playstore.R;


public class RecordingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sonometre, container, false);
    }

    //Click sur sauvegarder --> Ajouter à la BDD et renvoyer sur Presets
    //Clicksur ajouter instrument --> Ajouter un champ PlainText avec les bonnes références et tout (compliqué non ? on peut juste amener une nouvelle fenêtre pour enregistrer un nouvel instrument en
    //se basant sur la première fenêtre Sonomètre)
}