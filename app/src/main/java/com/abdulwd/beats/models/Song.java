package com.abdulwd.beats.models;

import android.graphics.Bitmap;

/**
 * Created by abdul on 24/5/17.
 */

public class Song {
    private String mSong, mAlbum, mArtist;
    private Bitmap mAlbumArt;

    public Song(String song, String album, String artist, Bitmap albumArt) {
        mSong = song;
        mAlbum = album;
        mArtist = artist;
        mAlbumArt = albumArt;
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


    public Bitmap getAlbumArt() {
        return mAlbumArt;
    }
}
