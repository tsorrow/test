package com.tsorrow.junior.senior.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.tsorrow.junior.senior.R;

import java.util.ArrayList;

public class BroadcastFragment extends Fragment {
    private static final String TAG = "BroadcastFragment";
    public static final String EVENT = "com.tsorrow.junior.senior.fragment.BroadcastFragment";
    private View mView;
    private Context mContext;
    private int mPosition;
    private int mImageId;
    private String mDesc;
    private int mSeq = 0;
    private Spinner sp_bg;
    private boolean bFirst = true;

    public static BroadcastFragment newInstance(int position,int image_id,String desc) {
        BroadcastFragment fragment = new BroadcastFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        bundle.putInt("image_id",image_id);
        bundle.putString("desc",desc);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        if (getArguments() != null){
            mPosition = getArguments().getInt("position",0);
            mImageId = getArguments().getInt("image_id",0);
            mDesc = getArguments().getString("desc");
        }
        mView = inflater.inflate(R.layout.fragment_broadcast,container,false);
        ImageView iv_pic = (ImageView) mView.findViewById(R.id.iv_pic);
        TextView tv_desc = (TextView) mView.findViewById(R.id.tv_desc);
        iv_pic.setImageResource(mImageId);
        tv_desc.setText(mDesc);
        return mView;
    }

    @Override
    public void onStart(){
        super.onStart();
        initSpinner();
        bgChangeReceiver = new BgChangeReceiver();
        IntentFilter intentFilter = new IntentFilter(BroadcastFragment.EVENT);
        LocalBroadcastManager.getInstance(mContext).registerReceiver(bgChangeReceiver,intentFilter);
    }

    private String[] mColorNameArray = {"红色", "黄色", "绿色", "青色", "蓝色"};
    private int[] mColorIdArray= {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE};

    private void initSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,R.layout.item_select,mColorNameArray);
        sp_bg = (Spinner) mView.findViewById(R.id.sp_bg);
        sp_bg.setPrompt("请选择页面背景色");
        sp_bg.setAdapter(adapter);
        sp_bg.setSelection(mSeq);
        sp_bg.setOnItemSelectedListener(new ColorSelectedListener());
    }

    @Override
    public void onStop(){
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(bgChangeReceiver);
        super.onStop();
    }

    private class ColorSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (!bFirst || mSeq != position){
                mSeq = position;
                Intent intent = new Intent(BroadcastFragment.this.EVENT);
                intent.putExtra("seq",position);
                intent.putExtra("color",mColorIdArray[position]);
                LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
            }
            bFirst = false;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private BgChangeReceiver bgChangeReceiver;
    private class BgChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null){
                mSeq = intent.getIntExtra("seq",0);
                sp_bg.setSelection(mSeq);
            }
        }
    }
}
