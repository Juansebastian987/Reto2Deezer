package com.application.reto2deezer.model;

public class PlaylistContainer {

    private Playlist[] data;

    public PlaylistContainer() {
    }

    public PlaylistContainer(Playlist[] data) {
        this.data = data;
    }

    public Playlist[] getData() {
        return data;
    }

    public void setData(Playlist[] data) {
        this.data = data;
    }
}
