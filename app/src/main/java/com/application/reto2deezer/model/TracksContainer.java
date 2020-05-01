package com.application.reto2deezer.model;

public class TracksContainer {

    private Track[] data;

    public TracksContainer() {
    }

    public TracksContainer(Track[] data) {
        this.data = data;
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }
}
