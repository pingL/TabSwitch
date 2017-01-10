package com.example.tab1text;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * ViewPage 的 Tab 切换页面的实现
 */

public class MainActivity01 extends Activity implements View.OnClickListener {
    private PagerAdapter mAdapter;
    private List<View> mViews = new ArrayList<View>();

    @BindView(R.id.viewpager_0) ViewPager mViewPager;
    @BindView(R.id.tab_wechat_ll) LinearLayout mTabWeChat;
    @BindView(R.id.tab_friend_ll) LinearLayout mTabFriend;
    @BindView(R.id.tab_address_ll) LinearLayout mTabAddress;
    @BindView(R.id.tab_settings_ll) LinearLayout mTabSetting;

    @BindView(R.id.tab_wechat_btn) ImageButton mBtnWeChat;
    @BindView(R.id.tab_friend_btn) ImageButton mBtnFriend;
    @BindView(R.id.tab_address_btn) ImageButton mBtnAddress;
    @BindView(R.id.tab_settings_btn) ImageButton mBtnSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity01);
        ButterKnife.bind(this);
        initView();
        initEvents();
    }

    private void initView() {

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.tab1_main, null);
        View tab02 = mInflater.inflate(R.layout.tab2_main, null);
        View tab03 = mInflater.inflate(R.layout.tab3_main, null);
        View tab04 = mInflater.inflate(R.layout.tab4_main, null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);


        mAdapter = new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));// 移除view
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position); // 初始view
                container.addView(view);
                return view;

            }

            @Override
            public int getCount() {
                return mViews.size(); // 获取view大小
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

        };

        mViewPager.setAdapter(mAdapter);
    }


    private void initEvents() {


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                resetImage();
                switch (currentItem) {
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

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick({R.id.tab_wechat_ll,R.id.tab_friend_ll,R.id.tab_address_ll,R.id.tab_settings_ll})
    @Override
    public void onClick(View view) {

        resetImage();

        switch (view.getId()) {
            case R.id.tab_wechat_ll:
                mViewPager.setCurrentItem(0);
                mBtnWeChat.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.tab_friend_ll:
                mViewPager.setCurrentItem(1);
                mBtnFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.tab_address_ll:
                mViewPager.setCurrentItem(2);
                mBtnAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.tab_settings_ll:
                mViewPager.setCurrentItem(3);
                mBtnSetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
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
