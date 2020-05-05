package com.application.reto2deezer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.reto2deezer.R;
import com.application.reto2deezer.model.Playlist;
import com.application.reto2deezer.model.Track;
import com.bumptech.glide.Glide;

public class InfoSongActivity extends AppCompatActivity {

    private ImageView imgTrackSong;
    private TextView txtNameTrackSong;
    private TextView txtNameArtistTrack;
    private TextView txtAlbumNameTrack;
    private EditText editText_TimeSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__song);

        imgTrackSong = findViewById(R.id.imgTrackSong);
        txtNameTrackSong = findViewById(R.id.txtNameTrackSong);
        txtNameArtistTrack = findViewById(R.id.txtNameArtistTrack);
        txtAlbumNameTrack = findViewById(R.id.txtAlbumNameTrack);
        editText_TimeSong = findViewById(R.id.editText_TimeSong);

        Intent datos = getIntent();
        Bundle objetoTrack = datos.getExtras();

        if(objetoTrack!=null){
            Track track = (Track) datos.getSerializableExtra("trackSelect");
            txtAlbumNameTrack.setText(track.getAlbum().getTitle());
            txtNameArtistTrack.setText(track.getArtist().getName());
            txtNameTrackSong.setText(track.getTitle());
            editText_TimeSong.setText(track.getDuration()+" segundos");
            Glide.with(this).load(track.getAlbum().getCover()).into(imgTrackSong);
        }

    }
}
