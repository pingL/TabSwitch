package com.example.tab1text;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by pingL on 2017/1/9,下午2:52.
 */

public class TabAdapter extends FragmentPagerAdapter {

    public static String[] TABNAME = new String[] {
            "课程", "问答", "学习", "计划"
    };

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment fragment = new TabFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return TABNAME.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TABNAME[position];
    }
}
