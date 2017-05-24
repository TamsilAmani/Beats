package com.abdulwd.beats.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdulwd.beats.R;
import com.abdulwd.beats.models.Song;

import java.util.List;

/**
 * Created by abdul on 24/5/17.
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private List<Song> mSongList;

    public SongsAdapter(List<Song> songList) {
        mSongList = songList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song song = mSongList.get(position);
        holder.song.setText(song.getSong());
        holder.album.setText(song.getAlbum());
        holder.artist.setText(song.getArtist());
    }

    @Override
    public int getItemCount() {
        return mSongList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView song, album, artist;
        public ImageView album_art;

        public ViewHolder(View itemView) {
            super(itemView);
            song = (TextView) itemView.findViewById(R.id.song);
            album = (TextView) itemView.findViewById(R.id.album);
            artist = (TextView) itemView.findViewById(R.id.artist);
            album_art = (ImageView) itemView.findViewById(R.id.album_art);
        }
    }
}
