package com.application.reto2deezer.control;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.application.reto2deezer.model.Song;
import com.application.reto2deezer.model.Track;
import com.application.reto2deezer.model.TracksContainer;
import com.application.reto2deezer.util.Constants;
import com.application.reto2deezer.util.HTTPSWebUtilDomi;
import com.application.reto2deezer.view.TrackActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class TracksController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener, AdapterView.OnItemClickListener{

    private  ArrayList<Song> listSong;
    private TrackActivity trackActivity;
    private HTTPSWebUtilDomi utilDomi;

    public TracksController(TrackActivity trackActivity) {
        this.trackActivity = trackActivity;
        listSong = new ArrayList<>();
        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);
        searchTracks();
    }

    public void searchTracks() {
        new Thread(() -> {
            String getRequest = "https://api.deezer.com/playlist/"+trackActivity.getId_playlist()+"/"+"tracks";
            utilDomi.GETrequest(Constants.TACK_CALLBACK, getRequest);
        }).start();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID) {
            case Constants.TACK_CALLBACK:
                Gson gson = new Gson();
                TracksContainer track = gson.fromJson(response, TracksContainer.class);
                ArrayList<Track> tracks = new ArrayList<>();
                Collections.addAll(tracks, track.getData());

                trackActivity.runOnUiThread(() -> {
                    trackActivity.getAdapterTrack().setTracks(tracks);
                    trackActivity.getAdapterTrack().notifyDataSetChanged();
                });
                break;

        }
    }
}
