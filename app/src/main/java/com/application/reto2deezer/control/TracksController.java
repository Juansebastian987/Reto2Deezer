package com.application.reto2deezer.control;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.application.reto2deezer.model.Song;
import com.application.reto2deezer.view.InfoSongActivity;
import com.application.reto2deezer.view.TrackActivity;

import java.util.ArrayList;

public class TracksController implements View.OnClickListener, AdapterTrack.OnTrackListener {

    private  ArrayList<Song> listSong;
    private Intent intent;
    private TrackActivity trackActivity;

    public TracksController(TrackActivity trackActivity) {
        this.trackActivity = trackActivity;
        listSong = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void OnTrackClick(int position) {

    }

}
