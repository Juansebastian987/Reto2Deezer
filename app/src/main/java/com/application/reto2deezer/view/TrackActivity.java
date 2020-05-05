package com.application.reto2deezer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.reto2deezer.R;
import com.application.reto2deezer.control.AdapterTrack;
import com.application.reto2deezer.control.TracksController;
import com.application.reto2deezer.model.Playlist;
import com.application.reto2deezer.model.Track;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity implements AdapterTrack.OnItemListener {

    private TextView namePlaylistTrack;
    private TextView descripcionPlaylistTrack;
    private TextView numberSongsPlaylistTrack;
    private TextView numberFansPlaylistTrack;
    private RecyclerView recyclerViewTrack;
    private AdapterTrack adapterTrack;
    private ImageView imgPlayListTrack;
    private TracksController tracksController;
    private ArrayList<Track> tracks;
    private String id_playlist;
    private Playlist playlistSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        namePlaylistTrack = findViewById(R.id.namePlaylistTrack);
        descripcionPlaylistTrack = findViewById(R.id.descripcionPlaylistTrack);
        numberSongsPlaylistTrack = findViewById(R.id.numberSongsPlaylistTrack);
        numberFansPlaylistTrack = findViewById(R.id.numberFansPlaylistTrack);
        recyclerViewTrack = findViewById(R.id.recyclerViewTrack);
        imgPlayListTrack = findViewById(R.id.imgPlayListTrack);

        tracks = new ArrayList<>();
        recyclerViewTrack.setLayoutManager(new LinearLayoutManager(this));
        adapterTrack = new AdapterTrack(this,this);
        recyclerViewTrack.setAdapter(adapterTrack);

        Intent datos = getIntent();

        Bundle objetoPlaylist = datos.getExtras();
        if(objetoPlaylist!=null){
            playlistSelect = (Playlist) datos.getSerializableExtra("playlistSelect");
            id_playlist = playlistSelect.getId();
            namePlaylistTrack.setText(playlistSelect.getTitle());
            descripcionPlaylistTrack.setText(playlistSelect.getDescription());
            numberSongsPlaylistTrack.setText("(Con: # "+playlistSelect.getNb_tracks()+" canciones)");
            numberFansPlaylistTrack.setText("(Con: # "+playlistSelect.getFans()+" fans)");
            Glide.with(this).load(playlistSelect.getPicture()).into(imgPlayListTrack);

          //  Log.e(">>>", playlistSelect.getDescription());

        }

        tracksController = new TracksController(this);
    }

    public String getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(String id_playlist) {
        this.id_playlist = id_playlist;
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

    @Override
    public void OnItemListener(int position) {

        Intent i = new Intent(this, InfoSongActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("trackSelect", getAdapterTrack().getTracks().get(position));
        i.putExtras(bundle);

        startActivity(i);

    }
}
