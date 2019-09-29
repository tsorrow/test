package com.tsorrow.test.network;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tsorrow.test.network.service.AsyncService;
import com.tsorrow.test.network.util.DateUtil;

public class IntentServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        tv_intent = (TextView)findViewById(R.id.tv_intent);
        findViewById(R.id.btn_intent).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_intent){
            tv_intent.setText(DateUtil.getNowTime()+"您轻轻点了一下下（异步服务正在运行，不影响您在界面操作）");
        }
    }

    private Handler mHandler = new Handler();
    private Runnable mService = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(IntentServiceActivity.this,AsyncService.class);
            startService(intent);
        }
    };
}
