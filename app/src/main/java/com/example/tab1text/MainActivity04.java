package com.example.tab1text;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.viewpagerindicator.TabPageIndicator;

/**
 * Created by pingL on 2017/1/9,下午2:46.
 */

public class MainActivity04 extends FragmentActivity {

    private ViewPager mViewPager;
    private TabAdapter mAdapter;
    private TabPageIndicator mTabPageIndicator;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity04);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_viewpager);
        mAdapter = new TabAdapter(getSupportFragmentManager());
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.indicator);
        mViewPager.setAdapter(mAdapter);
        mTabPageIndicator.setViewPager(mViewPager, 0);
    }


}
