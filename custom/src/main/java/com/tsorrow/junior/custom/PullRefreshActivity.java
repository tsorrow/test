package com.tsorrow.junior.custom;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.tsorrow.junior.custom.util.MeasureUtil;

public class PullRefreshActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "PullRefreshActivity";
    private LinearLayout ll_header;
    private Button btn_pull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_refresh);

        ll_header = (LinearLayout)findViewById(R.id.ll_header);
        btn_pull = (Button)findViewById(R.id.btn_pull);
        ll_header.setVisibility(View.GONE);
        btn_pull.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mHeight = (int)MeasureUtil.getRealHeight(ll_header);
        if (v.getId() == R.id.btn_pull){
            if (bStart == false){
                mOffset = -mHeight;
                btn_pull.setEnabled(false);
                mHandler.post(mRefresh);
            } else {
                btn_pull.setText("开始刷新");
                ll_header.setVisibility(View.GONE);
            }
            bStart = !bStart;
        }
    }

    private boolean bStart = false;
    private int mOffset = 0;
    private int mHeight;
    private Handler mHandler = new Handler();
    private Runnable mRefresh = new Runnable() {
        @Override
        public void run() {
            if (mOffset <= 0){
                ll_header.setPadding(0,mOffset,0,0);
                ll_header.setVisibility(View.VISIBLE);
                mOffset += 8;
                mHandler.postDelayed(this,80);
            } else {
                btn_pull.setText("恢复页面");
                btn_pull.setEnabled(true);
            }
        }
    };
}
