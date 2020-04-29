package com.application.reto2deezer.model;

public class TracksContainer {

    private DataContainer[] data;

    public TracksContainer() {
    }

    public TracksContainer(DataContainer[] data) {
        this.data = data;
    }

    public DataContainer[] getData() {
        return data;
    }

    public void setData(DataContainer[] data) {
        this.data = data;
    }
}
