package com.application.reto2deezer.control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.reto2deezer.R;
import com.application.reto2deezer.model.Song;
import com.application.reto2deezer.model.Track;
import com.application.reto2deezer.view.TrackActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterTrack extends RecyclerView.Adapter<AdapterTrack.ViewHolderSongs> implements View.OnClickListener {

    private ArrayList<Track> tracks;
    private View.OnClickListener listener;
    private TrackActivity trackActivity;

    public AdapterTrack(TrackActivity trackActivity) {
        this.trackActivity = trackActivity;
        tracks = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public ViewHolderSongs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iem_list_songs,null,false);
        view.setOnClickListener(this);
        return new ViewHolderSongs(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSongs holder, int position) {
        holder.nombreSong.setText(tracks.get(position).getTitle());
        holder.nameArtist.setText(tracks.get(position).getArtist().getName());
        holder.releaseDate.setText(tracks.get(position).getRelease_date());
        Glide.with(holder.foto.getContext()).load(tracks.get(position).getLink()).into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public class ViewHolderSongs extends RecyclerView.ViewHolder{
        TextView nombreSong,nameArtist, releaseDate;
        ImageView foto;

        public ViewHolderSongs(View itemView) {
            super(itemView);
            nombreSong= (TextView) itemView.findViewById(R.id.idNombreSong);
            nameArtist= (TextView) itemView.findViewById(R.id.idArtistSong);
            releaseDate = (TextView) itemView.findViewById(R.id.idDateSong);
            foto= (ImageView) itemView.findViewById(R.id.idImagenSong);
        }
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public TrackActivity getTrackActivity() {
        return trackActivity;
    }

    public void setTrackActivity(TrackActivity trackActivity) {
        this.trackActivity = trackActivity;
    }
}
