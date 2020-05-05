package com.application.reto2deezer.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Playlist implements Serializable {

    private String id;
    private String title;
    private User user;
    private String description;
    private String nb_tracks;
    private int fans;
    private String picture;
    private String tracklist;

    public Playlist(){
    }

    public Playlist(String id, String title, User user, String description, String nb_tracks, int fans, String picture, String tracklist) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.description = description;
        this.nb_tracks = nb_tracks;
        this.fans = fans;
        this.picture = picture;
        this.tracklist = tracklist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(String nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    protected Playlist(Parcel in) {
        id = in.readString();
        title = in.readString();
        user = (User) in.readValue(User.class.getClassLoader());
        description = in.readString();
        nb_tracks = in.readString();
        fans = in.readInt();
        picture = in.readString();
        tracklist = in.readString();
    }

}