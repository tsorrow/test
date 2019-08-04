package com.tsorrow.junior.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tsorrow.junior.custom.bean.GoodsInfo;

import java.util.ArrayList;

public class ImagePagerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<GoodsInfo> mGoodsInfo = new ArrayList<GoodsInfo>();
    private ArrayList<ImageView> mViewList = new ArrayList<ImageView>();

    public ImagePagerAdapter(Context context, ArrayList<GoodsInfo> goodsInfo){
        mContext = context;
        mGoodsInfo = goodsInfo;
        for (int i=0;i<mGoodsInfo.size();i++){
            ImageView view = new ImageView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            view.setImageResource(mGoodsInfo.get(i).pic);
            view.setScaleType(ImageView.ScaleType.FIT_CENTER);
            mViewList.add(view);
        }
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mGoodsInfo.get(position).name;
    }
}
