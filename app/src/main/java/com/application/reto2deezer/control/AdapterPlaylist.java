package com.application.reto2deezer.control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.application.reto2deezer.R;
import com.application.reto2deezer.model.Playlist;
import com.application.reto2deezer.view.MainActivity;
import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterPlaylist extends RecyclerView.Adapter<AdapterPlaylist.ViewHolderPlaylist> implements View.OnClickListener {

    private ArrayList<Playlist> listPlaylist;
    private View.OnClickListener listener;
    private MainActivity mainActivity;
    private OnItemListener onItemListener;

    public AdapterPlaylist(MainActivity mainActivity, OnItemListener onItemListener) {
        this.mainActivity = mainActivity;
        listPlaylist = new ArrayList<>();
        this.onItemListener = onItemListener;
    }

    @Override
    public ViewHolderPlaylist onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iem_list_personajes,null,false);
        view.setOnClickListener(this);
        return new ViewHolderPlaylist(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderPlaylist holder, int position) {
        holder.etiNombre.setText(listPlaylist.get(position).getTitle());
        holder.etiInformacion.setText(listPlaylist.get(position).getUser().getName());
        holder.numberItems.setText(listPlaylist.get(position).getNb_tracks());
        Glide.with(holder.foto.getContext()).load(listPlaylist.get(position).getPicture()).into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return listPlaylist.size();
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

    public class ViewHolderPlaylist extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView etiNombre,etiInformacion, numberItems;
        private ImageView foto;
        private OnItemListener onItemListener;

        public ViewHolderPlaylist(View itemView, OnItemListener onItemListener) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
            etiInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            numberItems = (TextView) itemView.findViewById(R.id.idItems);
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.OnItemListener(getAdapterPosition());
        }
    }

    public ArrayList<Playlist> getListPlaylist() {
        return listPlaylist;
    }

    public void setListPlaylist(ArrayList<Playlist> listPlaylist) {
        this.listPlaylist = listPlaylist;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public interface OnItemListener{
        void OnItemListener(int position);
    }
}
