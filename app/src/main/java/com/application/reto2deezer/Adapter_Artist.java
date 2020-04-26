package com.application.reto2deezer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Artist extends RecyclerView.Adapter<Adapter_Artist.ViewHolderArtist> implements View.OnClickListener{

    ArrayList<Artist> listaPersonajes;
    private View.OnClickListener listener;
    private OnNoteListener onNoteListener;

    public Adapter_Artist(ArrayList<Artist> listaPersonajes, OnNoteListener onNoteListener) {
        this.listaPersonajes = listaPersonajes;
        this.onNoteListener = onNoteListener;
    }

    @Override
    public ViewHolderArtist onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iem_list_personajes,null,false);
        return new ViewHolderArtist(view, onNoteListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderArtist holder, int position) {
        holder.etiNombre.setText(listaPersonajes.get(position).getNombre());
        holder.etiInformacion.setText(listaPersonajes.get(position).getInfo());
        holder.foto.setImageResource(listaPersonajes.get(position).getFoto());
        holder.numberItems.setText(listaPersonajes.get(position).getnItems());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
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
        OnNoteListener onNoteListener;

        public ViewHolderArtist(View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
            etiInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            numberItems = (TextView) itemView.findViewById(R.id.idItems);
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.OnNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void OnNoteClick(int position);
    }

}
