package com.tsorrow.junior.custom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tsorrow.junior.custom.service.NormalService;
import com.tsorrow.junior.custom.util.DateUtil;

public class ServiceNormalActivity extends AppCompatActivity implements View.OnClickListener {
    private static TextView tv_normal;
    private Intent mIntent;
    private static String mDesc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_normal);

        tv_normal = (TextView)findViewById(R.id.tv_normal);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        mIntent = new Intent(this,NormalService.class);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_start){
            startService(mIntent);
        } else if (v.getId() == R.id.btn_stop){
            stopService(mIntent);
        }
    }

    public static void showText(String desc){
        if (tv_normal != null){
            mDesc = String.format("%s%s %s\n",mDesc,DateUtil.getNowDateTime("HH:mm:ss"),desc);
            tv_normal.setText(mDesc);
        }
    }
}
