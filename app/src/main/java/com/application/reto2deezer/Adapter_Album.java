package com.application.reto2deezer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter_Album extends RecyclerView.Adapter<Adapter_Album.ViewHolderArtist> implements View.OnClickListener{

    ArrayList<Album> listAlbum;
    private View.OnClickListener listener;
    private OnArtistListener onArtistListener;
    private View view;

    public Adapter_Album(ArrayList<Album> listAlbum, OnArtistListener onArtistListener) {
        this.listAlbum = listAlbum;
        this.onArtistListener = onArtistListener;
    }

    @Override
    public ViewHolderArtist onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iem_list_personajes,null,false);
        return new ViewHolderArtist(view, onArtistListener);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void onBindViewHolder(ViewHolderArtist holder, int position) {
        holder.etiNombre.setText(listAlbum.get(position).getTitle());
        holder.etiInformacion.setText(listAlbum.get(position).getArtist().getName());
     //   holder.foto.setImageResource(Integer.parseInt(listAlbum.get(position).getCover()+""));
        holder.numberItems.setText(listAlbum.get(position).getNb_tracks());
        Glide.with(holder.foto.getContext()).load(listAlbum.get(position).getCover()).into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return listAlbum.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderArtist extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView etiNombre,etiInformacion, numberItems;
        private ImageView foto;
        private OnArtistListener onArtistListener;

        public ViewHolderArtist(View itemView, OnArtistListener onArtistListener) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
            etiInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            numberItems = (TextView) itemView.findViewById(R.id.idItems);
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
            this.onArtistListener = onArtistListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onArtistListener.OnArtistClick(getAdapterPosition());
        }
    }

    public interface OnArtistListener{
        void OnArtistClick(int position);
    }

    public ArrayList<Album> getListAlbum() {
        return listAlbum;
    }

    public void setListAlbum(ArrayList<Album> listAlbum) {
        this.listAlbum = listAlbum;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public OnArtistListener getOnArtistListener() {
        return onArtistListener;
    }

    public void setOnArtistListener(OnArtistListener onArtistListener) {
        this.onArtistListener = onArtistListener;
    }
}
