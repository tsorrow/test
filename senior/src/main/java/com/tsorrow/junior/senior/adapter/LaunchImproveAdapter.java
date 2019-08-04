package com.tsorrow.junior.senior.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tsorrow.junior.senior.fragment.LaunchFragment;

import java.util.ArrayList;

public class LaunchImproveAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Integer> mImageList = new ArrayList<Integer>();

    public LaunchImproveAdapter(FragmentManager fm,int[] imageArray){
        super(fm);
        for (int i=0;i<imageArray.length;i++){
            mImageList.add(imageArray[i]);
        }
    }

    @Override
    public Fragment getItem(int i) {
        return LaunchFragment.newInstance(i,mImageList.get(i));
    }

    @Override
    public int getCount() {
        return mImageList.size();
    }
}
