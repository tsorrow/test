package com.tsorrow.junior.senior;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.tsorrow.junior.senior.adapter.BroadcastPagerAdapter;
import com.tsorrow.junior.senior.bean.GoodsInfo;
import com.tsorrow.junior.senior.fragment.BroadcastFragment;

import java.util.ArrayList;

public class BroadTempActivity extends AppCompatActivity {
    private static final String TAG = "BroadTempActivity";
    private LinearLayout ll_brd_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_temp);

        ll_brd_temp = (LinearLayout)findViewById(R.id.ll_brd_temp);
        ViewPager vp_content = (ViewPager)findViewById(R.id.vp_content);
        ArrayList<GoodsInfo> goodsList = GoodsInfo.getDefaultList();
        BroadcastPagerAdapter adapter = new BroadcastPagerAdapter(getSupportFragmentManager(),goodsList);
        vp_content.setAdapter(adapter);
        vp_content.setCurrentItem(0);

    }

    @Override
    public void onStart() {
        super.onStart();
        bgChangeReceiver = new BgChangeReceiver();
        IntentFilter filter = new IntentFilter(BroadcastFragment.EVENT);
        LocalBroadcastManager.getInstance(this).registerReceiver(bgChangeReceiver, filter);
    }

    @Override
    public void onStop() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(bgChangeReceiver);
        super.onStop();
    }

    private BgChangeReceiver bgChangeReceiver;
    private class BgChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int color = intent.getIntExtra("color", Color.WHITE);
                ll_brd_temp.setBackgroundColor(color);
            }
        }
    }
}
