package com.example.tab1text;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pingL on 2017/1/9,上午10:09.
 */

public class MainActivityViewPagerFragmentPagerAdapter extends FragmentActivity implements View.OnClickListener {




    private ViewPager mViewPager;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private List<Fragment> mFragments;

    private LinearLayout mLlWeChat;
    private LinearLayout mLlFriend;
    private LinearLayout mLlAddress;
    private LinearLayout mLlSetting;

    private ImageButton mBtnWeChat;
    private ImageButton mBtnFriend;
    private ImageButton mBtnAddress;
    private ImageButton mBtnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpg_fgpgapt);

        initView();
        initEver();
        select(0);
    }

    private void select(int i) {

        setTab(i);
        mViewPager.setCurrentItem(i);

    }

    private void setTab(int i) {
        resetImage();
        switch (i) {
            case 0:
                mBtnWeChat.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                mBtnFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                mBtnAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                mBtnSetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }



    private void initView() {



        mViewPager = (ViewPager) findViewById(R.id.viewpager_1);
        mLlWeChat = (LinearLayout) findViewById(R.id.tab_wechat_ll);
        mLlFriend = (LinearLayout) findViewById(R.id.tab_friend_ll);
        mLlAddress = (LinearLayout) findViewById(R.id.tab_address_ll);
        mLlSetting = (LinearLayout) findViewById(R.id.tab_settings_ll);
        mBtnWeChat = (ImageButton) findViewById(R.id.tab_wechat_btn);
        mBtnFriend = (ImageButton) findViewById(R.id.tab_friend_btn);
        mBtnAddress = (ImageButton) findViewById(R.id.tab_address_btn);
        mBtnSetting = (ImageButton) findViewById(R.id.tab_settings_btn);

        mFragments = new ArrayList<Fragment>();
        Fragment tab1 = new FragmentWechat();
        Fragment tab2 = new FragmentFriend();
        Fragment tab3 = new FragmentAddress();
        Fragment tab4 = new FragmentSettings();
        mFragments.add(tab1);
        mFragments.add(tab2);
        mFragments.add(tab3);
        mFragments.add(tab4);

        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        mViewPager.setAdapter(mFragmentPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void initEver() {

        mLlWeChat.setOnClickListener(this);
        mLlFriend.setOnClickListener(this);
        mLlAddress.setOnClickListener(this);
        mLlSetting.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_wechat_ll:
                select(0);
                break;
            case R.id.tab_friend_ll:
                select(1);
                break;
            case R.id.tab_address_ll:
                select(2);
                break;
            case R.id.tab_settings_ll:
                select(3);
                break;
        }
    }

    private void resetImage() {
        mBtnWeChat.setImageResource(R.drawable.tab_weixin_normal);
        mBtnFriend.setImageResource(R.drawable.tab_find_frd_normal);
        mBtnAddress.setImageResource(R.drawable.tab_address_normal);
        mBtnSetting.setImageResource(R.drawable.tab_settings_normal);
    }
}
