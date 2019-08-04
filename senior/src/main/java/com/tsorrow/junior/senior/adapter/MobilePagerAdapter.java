package com.tsorrow.junior.senior.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tsorrow.junior.senior.bean.GoodsInfo;
import com.tsorrow.junior.senior.fragment.DynamicFragment;

import java.util.ArrayList;

public class MobilePagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<GoodsInfo> mGoodsList = new ArrayList<GoodsInfo>();

    public MobilePagerAdapter(FragmentManager fm,ArrayList<GoodsInfo> goodsList){
        super(fm);
        mGoodsList = goodsList;
    }

    @Override
    public Fragment getItem(int i) {
        return DynamicFragment.newInstance(i,mGoodsList.get(i).pic,mGoodsList.get(i).desc);
    }

    @Override
    public int getCount() {
        return mGoodsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mGoodsList.get(position).name;
    }

}
