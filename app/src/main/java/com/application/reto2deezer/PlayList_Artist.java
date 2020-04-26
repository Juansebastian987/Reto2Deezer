package com.application.reto2deezer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class PlayList_Artist extends AppCompatActivity implements View.OnClickListener, Adapter_Artist.OnNoteListener{

    ArrayList<Artist> listaPersonajes;
    RecyclerView recyclerPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = (RecyclerView) findViewById(R.id.RecyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        recyclerPersonajes.setOnClickListener(this);

        llenarPersonajes();

        Adapter_Artist adapterArtist = new Adapter_Artist(listaPersonajes, this);
        recyclerPersonajes.setAdapter(adapterArtist);
    }

    private void llenarPersonajes() {
        listaPersonajes.add(new Artist("Krusty", "Herschel Shmoikel Pinkus Yerocham","2",  R.drawable.burns));
        listaPersonajes.add(new Artist("Homero", "Homer Jay Simpson                ","2", R.drawable.bart));
        listaPersonajes.add(new Artist("Marge", "Marjorie Mara                     ","3", R.drawable.burns));
        listaPersonajes.add(new Artist("Bart", "Bartholomew JoJo","4", R.drawable.bart));
        listaPersonajes.add(new Artist("Lisa", "Lisa Marie Simpson","1", R.drawable.burns));
        listaPersonajes.add(new Artist("Magie", "Margaret Evelyn.","3", R.drawable.burns));
        listaPersonajes.add(new Artist("Flanders", "Nedward «Ned» Flanders","10", R.drawable.bart));
        listaPersonajes.add(new Artist("Milhouse", "Milhouse Mussolini","23", R.drawable.burns));
        listaPersonajes.add(new Artist("Mr. Burns", "Charles Montgomery Burn.","32", R.drawable.burns));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void OnNoteClick(int position) {
        Log.d(">>>", "CLICKEEEEEEEADO"+ position);
    }
}
