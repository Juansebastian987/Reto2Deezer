package com.application.reto2deezer;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_Song extends RecyclerView.Adapter<Adapter_Song.ViewHolderSongs> implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public ViewHolderSongs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSongs holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderSongs extends RecyclerView.ViewHolder {
        public ViewHolderSongs(@NonNull View itemView) {
            super(itemView);
        }
    }
}
