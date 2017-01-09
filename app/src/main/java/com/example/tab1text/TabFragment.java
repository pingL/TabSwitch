package com.example.tab1text;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pingL on 2017/1/9,下午2:52.
 */

public class TabFragment extends Fragment{

    private int pos;
    public TabFragment(int pos) {
        this.pos = pos;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.frag, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab);
        textView.setText(TabAdapter.TABNAME[pos]);
        return view;
    }
}
