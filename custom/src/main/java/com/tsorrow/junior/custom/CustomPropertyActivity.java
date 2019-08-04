package com.tsorrow.junior.custom;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tsorrow.junior.custom.bean.GoodsInfo;

import java.util.ArrayList;

public class CustomPropertyActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ArrayList<GoodsInfo> goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_property);

        ViewPager vp_content = (ViewPager)findViewById(R.id.vp_content);
        goodsList = GoodsInfo.getDefaultList();
        ImagePagerAdapter adapter = new ImagePagerAdapter(this,goodsList);
        vp_content.setAdapter(adapter);
        vp_content.setCurrentItem(0);
        vp_content.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        Toast.makeText(this, "您翻到的手机品牌是："+goodsList.get(i).name, Toast.LENGTH_SHORT).show();
    }
}
