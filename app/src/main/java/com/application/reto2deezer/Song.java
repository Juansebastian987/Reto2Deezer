package com.application.reto2deezer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Song{
    private String nameSong;
    private String nameArtist;
    private String releaseDate;
    private int photoSong;

    public Song(){
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPhotoSong() {
        return photoSong;
    }

    public void setPhotoSong(int photoSong) {
        this.photoSong = photoSong;
    }
}
