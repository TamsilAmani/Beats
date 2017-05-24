package com.abdulwd.beats.models;

/**
 * Created by abdul on 24/5/17.
 */

public class Song {
    private String mSong, mAlbum, mArtist;

    public Song(String song, String album, String artist) {
        mSong = song;
        mAlbum = album;
        mArtist = artist;
    }

    public String getSong() {
        return mSong;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String getArtist() {
        return mArtist;
    }
}
