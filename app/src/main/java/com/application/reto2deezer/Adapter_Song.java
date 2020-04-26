package com.application.reto2deezer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Song extends RecyclerView.Adapter<Adapter_Song.ViewHolderSongs> implements View.OnClickListener {

    ArrayList<Song> listSong;
    private View.OnClickListener listener;
    private OnSongListener onSongListener;

    public Adapter_Song(ArrayList<Song> listSong, OnSongListener onSongListener) {
        this.listSong = listSong;
        this.onSongListener = onSongListener;
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
        return new ViewHolderSongs(view, onSongListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSongs holder, int position) {
        holder.nombreSong.setText(listSong.get(position).getNameSong());
        holder.nameArtist.setText(listSong.get(position).getNameArtist());
        holder.foto.setImageResource(listSong.get(position).getPhotoSong());
        holder.releaseDate.setText(listSong.get(position).getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return listSong.size();
    }

    public class ViewHolderSongs extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nombreSong,nameArtist, releaseDate;
        ImageView foto;
        OnSongListener onSongListener;

        public ViewHolderSongs(View itemView, OnSongListener onSongListener) {
            super(itemView);
            nombreSong= (TextView) itemView.findViewById(R.id.idNombreSong);
            nameArtist= (TextView) itemView.findViewById(R.id.idArtistSong);
            releaseDate = (TextView) itemView.findViewById(R.id.idDateSong);
            foto= (ImageView) itemView.findViewById(R.id.idImagenSong);
            this.onSongListener = onSongListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSongListener.OnSongClick(getAdapterPosition());
        }
    }

    public interface OnSongListener{
        void OnSongClick(int position);
    }

}
