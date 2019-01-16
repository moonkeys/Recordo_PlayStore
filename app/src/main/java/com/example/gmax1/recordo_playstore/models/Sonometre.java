package com.example.gmax1.recordo_playstore.models;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gmax1.recordo_playstore.R;

import java.io.IOException;

public class Sonometre extends AppCompatActivity {

    final String TAG = "RecordManager";
    MediaRecorder mMediaRecorder;
    long startTime;
    long endTime;

    public void startRecord(){
        // To start recording
        if (mMediaRecorder == null)
            mMediaRecorder = new MediaRecorder();
        try {
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
            mMediaRecorder.prepare();
            mMediaRecorder.start();
            startTime = System.currentTimeMillis();
            updateMicStatus();
            Log.i("ACTION_START", "startTime" + startTime);
        } catch (IllegalStateException e) {
            Log.i(TAG,
                    "call startAmr(File mRecAudioFile) failed!"
                            + e.getMessage());
        } catch (IOException e) {
            Log.i(TAG,
                    "call startAmr(File mRecAudioFile) failed!"
                            + e.getMessage());
        }
    }


    public long stopRecord() {
        if (mMediaRecorder == null)
            return 0L;
        endTime = System.currentTimeMillis();
        Log.i("ACTION_END", "endTime" + endTime);
        mMediaRecorder.stop();
        mMediaRecorder.reset();
        mMediaRecorder.release();
        mMediaRecorder = null;
        Log.i("ACTION_LENGTH", "Time" + (endTime - startTime));
        return endTime - startTime;
    }

    private final Handler mHandler = new Handler();
    private Runnable mUpdateMicStatusTimer = new Runnable() {
        public void run() {
            updateMicStatus();
        }
    };

    private int BASE = 600;
    private int SPACE = 200;// Sampling time

    private void updateMicStatus() {
        if (mMediaRecorder != null) {
            int ratio = mMediaRecorder.getMaxAmplitude() / BASE;
            int db = 0;// DB
            if (ratio > 1)
                db = (int) (20 * Math.log10(ratio));
            System.out.println("Decibel value: "+db+"     "+Math.log10(ratio)); //A changer pour afficher direct dans SonometreFragment
            mHandler.postDelayed(mUpdateMicStatusTimer, SPACE);
        }
    }
}
