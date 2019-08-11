package com.tsorrow.junior.custom;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RunnableActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "RunnableActivity";
    private Button btn_runnable;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable);

        btn_runnable = (Button)findViewById(R.id.btn_runnable);
        tv_result = (TextView)findViewById(R.id.tv_result);
        btn_runnable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_runnable){
            if (bStart == false){
                btn_runnable.setText("停止计数");
                mHandler.post(mCounter);
            } else {
                btn_runnable.setText("开始计数");
                mHandler.removeCallbacks(mCounter);
            }
            bStart = !bStart;
        }
    }

    private int mCount = 0;
    private boolean bStart = false;
    private Handler mHandler = new Handler();
    private Runnable mCounter = new Runnable() {
        @Override
        public void run() {
            mCount++;
            tv_result.setText("当前计数为：" + mCount);
            mHandler.postDelayed(this,1000);
        }
    };
}
