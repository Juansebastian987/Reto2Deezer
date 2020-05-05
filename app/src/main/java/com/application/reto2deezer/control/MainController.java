package com.application.reto2deezer.control;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.application.reto2deezer.model.Playlist;
import com.application.reto2deezer.model.PlaylistContainer;
import com.application.reto2deezer.util.Constants;
import com.application.reto2deezer.util.HTTPSWebUtilDomi;
import com.application.reto2deezer.view.MainActivity;
import com.application.reto2deezer.view.TrackActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener, AdapterView.OnItemClickListener {

    private MainActivity mainActivity;
    private HTTPSWebUtilDomi utilDomi;
    private Intent intent;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        mainActivity.getImageButton().setOnClickListener(this);
        mainActivity.getAdapterPlaylist().setOnClickListener(this);

        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID) {
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                PlaylistContainer playlist = gson.fromJson(response, PlaylistContainer.class);
                ArrayList<Playlist> playlists = new ArrayList<>();
                Collections.addAll(playlists, playlist.getData());

                mainActivity.runOnUiThread(() -> {
                    mainActivity.getAdapterPlaylist().setListPlaylist(playlists);
                    mainActivity.getAdapterPlaylist().notifyDataSetChanged();
                });
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(v==mainActivity.getImageButton()){
           searchPlaylist();
        }
    }

    public void searchPlaylist() {
        String playlist = mainActivity.getEditText().getText().toString();
        if (!playlist.isEmpty()) {
            new Thread(() -> {
                utilDomi.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/search/playlist?q="+playlist);
            }).start();
        } else {
            Toast.makeText(mainActivity.getApplicationContext(), "Debes ingresar un Playlist", Toast.LENGTH_SHORT).show();
        }
    }
}
