package com.tsorrow.junior.senior;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tsorrow.junior.senior.adapter.LaunchImproveAdapter;
import com.tsorrow.junior.senior.adapter.LaunchSimpleAdapter;

public class LaunchImproveActivity extends AppCompatActivity {
    private int[] launchImageArray = {
        R.drawable.guide_bg1,
        R.drawable.guide_bg2,
        R.drawable.guide_bg3,
        R.drawable.guide_bg4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_improve);

        ViewPager vp_launch = (ViewPager)findViewById(R.id.vp_launch);
        LaunchImproveAdapter adapter = new LaunchImproveAdapter(getSupportFragmentManager(),launchImageArray);
        vp_launch.setAdapter(adapter);
        vp_launch.setCurrentItem(0);
    }
}
