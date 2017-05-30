package com.example.kuanglin.ochatsukierp.CustomView.ViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by KuangLin on 2017/3/23.
 */


// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.

public class OchaPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;

    public OchaPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Bundle bundle = fragments.get(position).getArguments();
        bundle.getString("title");

        return bundle.getString("title");
    }
}