package com.abdulwd.beats.fragments;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdulwd.beats.R;
import com.abdulwd.beats.adapters.SongsAdapter;
import com.abdulwd.beats.models.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdul on 20/5/17.
 */

public class SongsFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected SongsAdapter mSongsAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    private List<Song> mSongList = new ArrayList<>();

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSongsList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_songs, container, false);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        mSongsAdapter = new SongsAdapter(mSongList);
        mLayoutManager = new LinearLayoutManager(getContext());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mSongsAdapter);

        return root;
    }

    void initSongsList() {
        ContentResolver contentResolver = getActivity().getContentResolver();
        Cursor musicCursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Audio.Media.TITLE,
                        MediaStore.Audio.Media.ALBUM,
                        MediaStore.Audio.Media.ARTIST,
                        MediaStore.Audio.Media.ALBUM_ID},
                null, null, MediaStore.Audio.Media.TITLE);

        if (musicCursor != null && musicCursor.moveToFirst()) {
            int titleColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.TITLE);
            int albumColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.ALBUM);
            int artistColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.ARTIST);
            int albumIdColumn = musicCursor.getColumnIndex
                    (MediaStore.Audio.Media.ALBUM_ID);
            String title, album, artist, albumId, albumArt = "";

            do {
                title = musicCursor.getString(titleColumn);
                album = musicCursor.getString(albumColumn);
                artist = musicCursor.getString(artistColumn);
                albumId = musicCursor.getString(albumIdColumn);

                Cursor albumArtCursor = contentResolver.query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                        new String[]{MediaStore.Audio.Albums._ID, MediaStore.Audio.Albums.ALBUM_ART},
                        MediaStore.Audio.Albums._ID + "=?",
                        new String[]{albumId},
                        null);

                if (albumArtCursor.moveToFirst()) {
                    albumArt = albumArtCursor.getString(albumArtCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART));
                }
                Bitmap albumArtImage;
                albumArtImage = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

                if (albumArt != null) {
                    albumArtImage = BitmapFactory.decodeFile(albumArt);
                }
                if (albumArtImage != null)
                    albumArtImage = Bitmap.createScaledBitmap(albumArtImage, 60, 60, false);

                mSongList.add(new Song(title, album, artist, albumArtImage));
                albumArtCursor.close();
            } while (musicCursor.moveToNext());
            musicCursor.close();
        }
    }
}
