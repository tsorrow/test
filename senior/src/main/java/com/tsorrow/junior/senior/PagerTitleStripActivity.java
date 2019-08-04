package com.tsorrow.junior.senior;

import android.graphics.Color;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Toast;

import com.tsorrow.junior.senior.adapter.ImagePagerAdapter;
import com.tsorrow.junior.senior.bean.GoodsInfo;

import java.util.ArrayList;

public class PagerTitleStripActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ArrayList<GoodsInfo> goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_title_strip);

        ViewPager vp_content = (ViewPager) findViewById(R.id.vp_content);
        goodsList = GoodsInfo.getDefaultList();
        ImagePagerAdapter adapter = new ImagePagerAdapter(this, goodsList);
        vp_content.setAdapter(adapter);
        vp_content.setCurrentItem(0);
        vp_content.addOnPageChangeListener(this);

        PagerTitleStrip pts_title = (PagerTitleStrip)findViewById(R.id.pts_title);
        pts_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        pts_title.setTextColor(Color.BLUE);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Toast.makeText(this, "您翻到的手机品牌是："+goodsList.get(i).name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
