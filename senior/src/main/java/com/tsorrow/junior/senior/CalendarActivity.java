package com.tsorrow.junior.senior;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tsorrow.junior.senior.adapter.CalendarPagerAdapter;
import com.tsorrow.junior.senior.util.DateUtil;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {
    private static final String TAG = "CalendarActivity";
    private ViewPager vp_calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        vp_calendar = (ViewPager)findViewById(R.id.vp_calendar);
        CalendarPagerAdapter adapter = new CalendarPagerAdapter(getSupportFragmentManager());
        vp_calendar.setAdapter(adapter);
        vp_calendar.setCurrentItem(DateUtil.getNowMonth() - 1);
    }
}
