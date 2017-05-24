package com.abdulwd.beats.fragments;

import android.os.Bundle;
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

import static com.abdulwd.beats.utilities.Constants.temp;

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
        initDataSet();
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

    void initDataSet() {
        for (int i = 0; i < temp.length; i++)
            mSongList.add(new Song(temp[i], temp[i], temp[i]));
    }
}
