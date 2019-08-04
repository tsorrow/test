package com.tsorrow.junior.senior.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tsorrow.junior.senior.R;

import java.util.ArrayList;

public class LaunchSimpleAdapter extends PagerAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<View> mViewList = new ArrayList<View>();

    public LaunchSimpleAdapter(Context context,int[] imageArray){
        mInflater = LayoutInflater.from(context);
        mContext = context;
        for (int i=0;i<imageArray.length;i++){
            View view = mInflater.inflate(R.layout.item_launch,null);
            ImageView iv_launch = (ImageView)view.findViewById(R.id.iv_launch);
            RadioGroup rg_indicate = (RadioGroup)view.findViewById(R.id.rg_indicate);
            Button btn_start = (Button)view.findViewById(R.id.btn_start);
            iv_launch.setImageResource(imageArray[i]);
            for (int j=0;j<imageArray.length;j++){
                RadioButton radioButton = new RadioButton(mContext);
                radioButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                radioButton.setButtonDrawable(R.drawable.launch_guide);
                radioButton.setPadding(10,10,10,10);
                rg_indicate.addView(radioButton);
            }
            ((RadioButton)rg_indicate.getChildAt(i)).setChecked(true);
            if (i == imageArray.length - 1){
                btn_start.setVisibility(View.VISIBLE);
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"欢迎您开启美好生活",Toast.LENGTH_SHORT).show();
                    }
                });
            }
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
}
