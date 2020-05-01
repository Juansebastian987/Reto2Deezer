package com.application.reto2deezer.control;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.application.reto2deezer.model.Playlist;
import com.application.reto2deezer.model.PlaylistContainer;
import com.application.reto2deezer.util.Constants;
import com.application.reto2deezer.util.HTTPSWebUtilDomi;
import com.application.reto2deezer.view.MainActivity;
import com.google.gson.Gson;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener, AdapterView.OnItemClickListener{

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
        new Thread(() -> {

        }).start();
    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID) {
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                PlaylistContainer playlist = gson.fromJson(response, PlaylistContainer.class);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(v==mainActivity.getImageButton()){
            Log.e(">>>", "El boton esta siendo clickeado");
        }
    }

    public void searchPlaylist() {

    }
}
