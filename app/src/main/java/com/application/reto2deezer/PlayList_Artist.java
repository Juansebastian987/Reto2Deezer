package com.application.reto2deezer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class PlayList_Artist extends AppCompatActivity implements View.OnClickListener, Adapter_Artist.OnArtistListener{

    ArrayList<Artist> listArtist;
    RecyclerView recyclerPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listArtist = new ArrayList<>();
        recyclerPersonajes = (RecyclerView) findViewById(R.id.RecyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        recyclerPersonajes.setOnClickListener(this);

        llenarPersonajes();

        Adapter_Artist adapterArtist = new Adapter_Artist(listArtist, this);
        recyclerPersonajes.setAdapter(adapterArtist);
    }

    private void llenarPersonajes() {
        listArtist.add(new Artist("Krusty", "Herschel Shmoikel Pinkus Yerocham","2",  R.drawable.burns));
        listArtist.add(new Artist("Homero", "Homer Jay Simpson                ","2", R.drawable.bart));
        listArtist.add(new Artist("Marge", "Marjorie Mara                     ","3", R.drawable.burns));
        listArtist.add(new Artist("Bart", "Bartholomew JoJo","4", R.drawable.bart));
        listArtist.add(new Artist("Lisa", "Lisa Marie Simpson","1", R.drawable.burns));
        listArtist.add(new Artist("Magie", "Margaret Evelyn.","3", R.drawable.burns));
        listArtist.add(new Artist("Flanders", "Nedward «Ned» Flanders","10", R.drawable.bart));
        listArtist.add(new Artist("Milhouse", "Milhouse Mussolini","23", R.drawable.burns));
        listArtist.add(new Artist("Mr. Burns", "Charles Montgomery Burn.","32", R.drawable.burns));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void OnArtistClick(int position) {
        Log.d(">>>", "CLICKEEEEEEEADO"+ position);

        Intent i = new Intent(getApplicationContext(), PlayList_Song.class);
        i.putExtra("nombre", "PRUEBA");
        startActivity(i);
    }

    public ArrayList<Artist> getListArtist() {
        return listArtist;
    }

    public void setListArtist(ArrayList<Artist> listArtist) {
        this.listArtist = listArtist;
    }

    public RecyclerView getRecyclerPersonajes() {
        return recyclerPersonajes;
    }

    public void setRecyclerPersonajes(RecyclerView recyclerPersonajes) {
        this.recyclerPersonajes = recyclerPersonajes;
    }
}
