package com.abdulwd.beats.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.abdulwd.beats.fragments.SongsFragment;

import static com.abdulwd.beats.utilities.Constants.LIBRARY_TABS;

/**
 * Created by abdul on 20/5/17.
 */

public class LibraryPagerAdapter extends FragmentStatePagerAdapter {
    public LibraryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new SongsFragment();
    }

    @Override
    public int getCount() {
        return LIBRARY_TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return LIBRARY_TABS[position];
    }
}
