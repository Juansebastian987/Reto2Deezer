package com.application.reto2deezer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Artist extends RecyclerView.Adapter<Adapter_Artist.ViewHolderArtist> implements View.OnClickListener{

    ArrayList<Artist> listArtist;
    private View.OnClickListener listener;
    private OnArtistListener onArtistListener;

    public Adapter_Artist(ArrayList<Artist> listArtist, OnArtistListener onArtistListener) {
        this.listArtist = listArtist;
        this.onArtistListener = onArtistListener;
    }

    @Override
    public ViewHolderArtist onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iem_list_personajes,null,false);
        return new ViewHolderArtist(view, onArtistListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderArtist holder, int position) {
        holder.etiNombre.setText(listArtist.get(position).getNombre());
        holder.etiInformacion.setText(listArtist.get(position).getInfo());
        holder.foto.setImageResource(listArtist.get(position).getFoto());
        holder.numberItems.setText(listArtist.get(position).getnItems());
    }

    @Override
    public int getItemCount() {
        return listArtist.size();
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

        TextView etiNombre,etiInformacion, numberItems;
        ImageView foto;
        OnArtistListener onArtistListener;

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

}
