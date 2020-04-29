package com.application.reto2deezer;

import com.application.reto2deezer.model.Artist;
import com.application.reto2deezer.model.TracksContainer;

public class Album {
    private String title;
    private String nb_tracks;
    private String cover;
    private TracksContainer tracks;
    private Artist artist;

    public Album(){
    }

    public Album(String title, String nb_tracks, String cover, TracksContainer tracks, Artist artist) {
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.cover = cover;
        this.tracks = tracks;
        this.artist = artist;
    }

    public String getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(String nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TracksContainer getTracksContainer() {
        return tracks;
    }

    public void setTracksContainer(TracksContainer tracksContainer) {
        this.tracks = tracksContainer;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}