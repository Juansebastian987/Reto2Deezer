package com.application.reto2deezer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.reto2deezer.R;
import com.application.reto2deezer.control.AdapterTrack;
import com.application.reto2deezer.control.TracksController;
import com.application.reto2deezer.model.Track;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity{

    private TextView namePlaylistTrack;
    private TextView descripcionPlaylistTrack;
    private TextView numberSongsPlaylistTrack;
    private TextView numberFansPlaylistTrack;
    private RecyclerView recyclerViewTrack;
    private AdapterTrack adapterTrack;
    private ImageView imgPlayListTrack;
    private TracksController tracksController;
    private ArrayList<Track> tracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        namePlaylistTrack = findViewById(R.id.namePlaylistTrack);
        descripcionPlaylistTrack = findViewById(R.id.descripcionPlaylistTrack);
        numberSongsPlaylistTrack = findViewById(R.id.numberSongsPlaylistTrack);
        numberFansPlaylistTrack = findViewById(R.id.numberFansPlaylistTrack);

        tracks = new ArrayList<>();
        recyclerViewTrack.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTrack.setAdapter(adapterTrack);
        tracksController = new TracksController(this);
    }

    public TextView getNamePlaylistTrack() {
        return namePlaylistTrack;
    }

    public void setNamePlaylistTrack(TextView namePlaylistTrack) {
        this.namePlaylistTrack = namePlaylistTrack;
    }

    public TextView getDescripcionPlaylistTrack() {
        return descripcionPlaylistTrack;
    }

    public void setDescripcionPlaylistTrack(TextView descripcionPlaylistTrack) {
        this.descripcionPlaylistTrack = descripcionPlaylistTrack;
    }

    public TextView getNumberSongsPlaylistTrack() {
        return numberSongsPlaylistTrack;
    }

    public void setNumberSongsPlaylistTrack(TextView numberSongsPlaylistTrack) {
        this.numberSongsPlaylistTrack = numberSongsPlaylistTrack;
    }

    public TextView getNumberFansPlaylistTrack() {
        return numberFansPlaylistTrack;
    }

    public void setNumberFansPlaylistTrack(TextView numberFansPlaylistTrack) {
        this.numberFansPlaylistTrack = numberFansPlaylistTrack;
    }

    public RecyclerView getRecyclerViewTrack() {
        return recyclerViewTrack;
    }

    public void setRecyclerViewTrack(RecyclerView recyclerViewTrack) {
        this.recyclerViewTrack = recyclerViewTrack;
    }

    public AdapterTrack getAdapterTrack() {
        return adapterTrack;
    }

    public void setAdapterTrack(AdapterTrack adapterTrack) {
        this.adapterTrack = adapterTrack;
    }

    public ImageView getImgPlayListTrack() {
        return imgPlayListTrack;
    }

    public void setImgPlayListTrack(ImageView imgPlayListTrack) {
        this.imgPlayListTrack = imgPlayListTrack;
    }

    public TracksController getTracksController() {
        return tracksController;
    }

    public void setTracksController(TracksController tracksController) {
        this.tracksController = tracksController;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
}
