package com.application.reto2deezer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.application.reto2deezer.model.Artist;
import com.application.reto2deezer.model.TracksContainer;
import com.application.reto2deezer.util.Constants;
import com.application.reto2deezer.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

import java.util.ArrayList;

public class PlayList_Album extends AppCompatActivity implements View.OnClickListener, Adapter_Album.OnArtistListener,
    HTTPSWebUtilDomi.OnResponseListener{

    ArrayList<Album> listAlbum;
    RecyclerView recyclerPersonajes;
    private EditText editText;
    private ImageButton btn_artist;
    private HTTPSWebUtilDomi httpsWebUtilDomi;
    private Adapter_Album adapter_album;

    public PlayList_Album() {
        httpsWebUtilDomi = new HTTPSWebUtilDomi();
        httpsWebUtilDomi.setListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAlbum = new ArrayList<>();
        recyclerPersonajes = (RecyclerView) findViewById(R.id.RecyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        editText = findViewById(R.id.idEditText_artist);
        btn_artist = findViewById(R.id.btn_artist);

        btn_artist.setOnClickListener(this);
        recyclerPersonajes.setOnClickListener(this);

        llenarPersonajes();

        adapter_album = new Adapter_Album(listAlbum, this);
        recyclerPersonajes.setAdapter(adapter_album);
    }

    private void llenarPersonajes() {
      //  listAlbum.add(new Album("Prueba1", "12", "https://api.deezer.com/playlist/3016655/image", new TracksContainer(), new Artist()));
    }

    @Override
    public void onClick(View v) {
        if(btn_artist==v){
            String elementoAbuscar = editText.getText().toString();
            Log.d(">>>", "BTN IMAGEN CLICKEAOD"+""+elementoAbuscar);

            new Thread(
                    ()->{
                        ///CAMBIAR ESTE LINK POR EL DE PLAYLIST https://api.deezer.com/playlist/908622995
                        httpsWebUtilDomi.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/album/302127");
                    }
            ).start();
        }
    }

    @Override
    public void OnArtistClick(int position) {
        Log.d(">>>", "CLICKEEEEEEEADO"+ position);

        Intent i = new Intent(getApplicationContext(), PlayList_Song.class);
        i.putExtra("nombre", "PRUEBA");
        startActivity(i);
    }

    public ArrayList<Album> getListAlbum() {
        return listAlbum;
    }

    public void setListAlbum(ArrayList<Album> listAlbum) {
        this.listAlbum = listAlbum;
    }

    public RecyclerView getRecyclerPersonajes() {
        return recyclerPersonajes;
    }

    public void setRecyclerPersonajes(RecyclerView recyclerPersonajes) {
        this.recyclerPersonajes = recyclerPersonajes;
    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                Album album = gson.fromJson(response, Album.class);


                runOnUiThread(
                        ()->{
                            listAlbum.add(new Album(album.getTitle(), album.getNb_tracks(), album.getCover(), new TracksContainer(), new Artist()));
                        }
                );

                for(int i = 0; i<album.getTracksContainer().getData().length; i++){
                    Log.e(">>>", album.getTracksContainer().getData()[i].getTitle());
                }

                break;

        }
    }
}
