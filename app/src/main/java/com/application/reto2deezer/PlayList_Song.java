package com.application.reto2deezer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class PlayList_Song extends AppCompatActivity implements View.OnClickListener, Adapter_Song.OnSongListener {

    ArrayList<Song> listSong;
    RecyclerView recyclerSong;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);


        listSong = new ArrayList<>();
        recyclerSong = (RecyclerView) findViewById(R.id.idRecyclerViewSong);
        recyclerSong.setLayoutManager(new LinearLayoutManager(this));
        recyclerSong.setOnClickListener(this);
        intent = getIntent();
        llenarPersonajes();

        Adapter_Song adapter_song = new Adapter_Song(listSong, this);
        recyclerSong.setAdapter(adapter_song);
    }

    private void llenarPersonajes() {
        listSong.add(new Song(intent.getStringExtra("nombre")+"", "Juan sebastian", "25/04/2020", R.drawable.bart));
        listSong.add(new Song("I love you yenifer", "Juan sebastian", "25/04/2020", R.drawable.bart));
        listSong.add(new Song("I love you yenifer", "Juan sebastian", "25/04/2020", R.drawable.bart));
        listSong.add(new Song("I love you yenifer", "Juan sebastian", "25/04/2020", R.drawable.bart));
        listSong.add(new Song("I love you yenifer", "Juan sebastian", "25/04/2020", R.drawable.bart));
        listSong.add(new Song("I love you yenifer", "Juan sebastian", "25/04/2020", R.drawable.bart));
        listSong.add(new Song("I love you yenifer", "Juan sebastian", "25/04/2020", R.drawable.bart));
        listSong.add(new Song("I love you yenifer", "Juan sebastian", "25/04/2020", R.drawable.bart));
        listSong.add(new Song("I love you yenifer", "Juan sebastian", "25/04/2020", R.drawable.bart));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void OnSongClick(int position) {

        Intent i = new Intent(getApplicationContext(), Info_Song.class);
        startActivity(i);
        Log.d(">>>", "CLICKEEEEEEEADO"+ position);
    }
}
