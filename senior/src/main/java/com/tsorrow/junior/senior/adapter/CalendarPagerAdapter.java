package com.tsorrow.junior.senior.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tsorrow.junior.senior.calendar.Constant;
import com.tsorrow.junior.senior.fragment.CalendarFragment;

public class CalendarPagerAdapter extends FragmentStatePagerAdapter {

    public CalendarPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return CalendarFragment.newInstance(i + 1);
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return new String(Constant.xuhaoArray[position+1] + "月");
    }
}
