package com.example.tab1text;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by pingL on 2017/1/8,下午12:44.
 */

public class MainActivityFragment extends FragmentActivity implements View.OnClickListener {

    private ImageButton mTabWechat_btn;
    private ImageButton mTabFriend_btn;
    private ImageButton mTabAddress_btn;
    private ImageButton mTabSetting_btn;

    private LinearLayout mTabWechat_ll;
    private LinearLayout mTabFriend_ll;
    private LinearLayout mTabAddress_ll;
    private LinearLayout mTabSettings_ll;

    private Fragment mTabWechat_fg;
    private Fragment mTabFriend_fg;
    private Fragment mTabAddress_fg;
    private Fragment mTabSettings_fg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fragment);
        initView();
        initEvent();
        setSelect(0);
    }

    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hintFragment(transaction);
        switch (i) {
            case 0:
                if (mTabWechat_fg == null) {
                    mTabWechat_fg = new FragmentWechat();
                    transaction.add(R.id.tab_fl, mTabWechat_fg);

                } else {
                    transaction.show(mTabWechat_fg);
                }
                mTabWechat_btn.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                if (mTabFriend_fg == null) {
                    mTabFriend_fg = new FragmentFriend();
                    transaction.add(R.id.tab_fl, mTabFriend_fg);
                } else {
                    transaction.show(mTabFriend_fg);

                }
                mTabFriend_btn.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                if (mTabAddress_fg == null) {
                    mTabAddress_fg = new FragmentAddress();
                    transaction.add(R.id.tab_fl, mTabAddress_fg);
                } else {
                    transaction.show(mTabAddress_fg);
                }
                mTabAddress_btn.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                if (mTabSettings_fg == null) {
                    mTabSettings_fg = new FragmentSettings();
                    transaction.add(R.id.tab_fl, mTabSettings_fg);
                } else {
                    transaction.show(mTabSettings_fg);
                }
                mTabSetting_btn.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }

        transaction.commit();

    }

    private void hintFragment(FragmentTransaction transaction) {

        if (mTabWechat_fg != null) {
            transaction.hide(mTabWechat_fg);
        }
        if (mTabFriend_fg != null) {
            transaction.hide(mTabFriend_fg);
        }
        if (mTabAddress_fg != null) {
            transaction.hide(mTabAddress_fg);
        }
        if (mTabSettings_fg != null) {
            transaction.hide(mTabSettings_fg);
        }
    }

    private void initEvent() {

        mTabWechat_ll.setOnClickListener(this);
        mTabFriend_ll.setOnClickListener(this);
        mTabAddress_ll.setOnClickListener(this);
        mTabSettings_ll.setOnClickListener(this);
    }

    private void initView() {

        mTabWechat_ll = (LinearLayout) findViewById(R.id.tab_wechat_ll);
        mTabFriend_ll = (LinearLayout) findViewById(R.id.tab_friend_ll);
        mTabAddress_ll = (LinearLayout) findViewById(R.id.tab_address_ll);
        mTabSettings_ll = (LinearLayout) findViewById(R.id.tab_settings_ll);

        mTabWechat_btn = (ImageButton) findViewById(R.id.tab_wechat_btn);
        mTabFriend_btn = (ImageButton) findViewById(R.id.tab_friend_btn);
        mTabAddress_btn = (ImageButton) findViewById(R.id.tab_address_btn);
        mTabSetting_btn = (ImageButton) findViewById(R.id.tab_settings_btn);

    }

    private void resetImage() {

        mTabWechat_btn.setImageResource(R.drawable.tab_weixin_normal);
        mTabFriend_btn.setImageResource(R.drawable.tab_find_frd_normal);
        mTabAddress_btn.setImageResource(R.drawable.tab_address_normal);
        mTabSetting_btn.setImageResource(R.drawable.tab_settings_normal);
    }

    @Override
    public void onClick(View view) {
        resetImage();
        switch (view.getId()) {
            case R.id.tab_wechat_ll:
                setSelect(0);
                break;
            case R.id.tab_friend_ll:
                setSelect(1);
                break;
            case R.id.tab_address_ll:
                setSelect(2);
                break;
            case R.id.tab_settings_ll:
                setSelect(3);
                break;
            default:
                break;
        }
    }
}
