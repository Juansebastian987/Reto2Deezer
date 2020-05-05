package com.application.reto2deezer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

import com.application.reto2deezer.R;
import com.application.reto2deezer.control.AdapterPlaylist;
import com.application.reto2deezer.control.MainController;
import com.application.reto2deezer.model.Playlist;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterPlaylist.OnItemListener {

    private ArrayList<Playlist> listPlaylist;
    private RecyclerView recyclerPlaylist;
    private AdapterPlaylist adapterPlaylist;
    private MainController mainController;
    private ImageButton imageButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.btnPlaylist);
        editText = findViewById(R.id.editPlaylist);

        listPlaylist = new ArrayList<>();
        recyclerPlaylist = (RecyclerView) findViewById(R.id.RecyclerId);
        recyclerPlaylist.setLayoutManager(new LinearLayoutManager(this));

        adapterPlaylist = new AdapterPlaylist(this, this);
        recyclerPlaylist.setAdapter(adapterPlaylist);
        mainController = new MainController(this);
    }

    public ArrayList<Playlist> getListPlaylist() {
        return listPlaylist;
    }

    public void setListPlaylist(ArrayList<Playlist> listPlaylist) {
        this.listPlaylist = listPlaylist;
    }

    public RecyclerView getRecyclerPlaylist() {
        return recyclerPlaylist;
    }

    public void setRecyclerPlaylist(RecyclerView recyclerPlaylist) {
        this.recyclerPlaylist = recyclerPlaylist;
    }

    public AdapterPlaylist getAdapterPlaylist() {
        return adapterPlaylist;
    }

    public void setAdapterPlaylist(AdapterPlaylist adapterPlaylist) {
        this.adapterPlaylist = adapterPlaylist;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void OnItemListener(int position) {
        Intent i = new Intent(this, TrackActivity.class);
        i.putExtra("id", getAdapterPlaylist().getListPlaylist().get(position).getId());
        startActivity(i);
    }
}