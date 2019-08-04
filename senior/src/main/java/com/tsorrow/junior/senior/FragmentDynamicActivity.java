package com.tsorrow.junior.senior;

import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;

import com.tsorrow.junior.senior.adapter.MobilePagerAdapter;
import com.tsorrow.junior.senior.bean.GoodsInfo;

import java.util.ArrayList;

public class FragmentDynamicActivity extends AppCompatActivity {
    private static final String TAG = "FragmentDynamicActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);
        Log.d(TAG, "onCreate");

        ViewPager vp_content = (ViewPager)findViewById(R.id.vp_content);
        ArrayList<GoodsInfo> goodsList = GoodsInfo.getDefaultList();
        MobilePagerAdapter adapter = new MobilePagerAdapter(getSupportFragmentManager(),goodsList);
        vp_content.setAdapter(adapter);
        vp_content.setCurrentItem(0);

        PagerTabStrip pts = (PagerTabStrip)findViewById(R.id.pts_tab);
        pts.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
}
