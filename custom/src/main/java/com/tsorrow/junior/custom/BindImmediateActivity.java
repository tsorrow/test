package com.tsorrow.junior.custom;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tsorrow.junior.custom.service.BindImmediateService;
import com.tsorrow.junior.custom.util.DateUtil;

public class BindImmediateActivity extends AppCompatActivity implements View.OnClickListener {
    private static TextView tv_immediate;
    private final static String TAG = "BindImmediateActivity";
    private static String mDesc = "";
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_immediate);

        tv_immediate = (TextView)findViewById(R.id.tv_immediate);
        findViewById(R.id.btn_start_bind).setOnClickListener(this);
        findViewById(R.id.btn_start_unbind).setOnClickListener(this);
        mIntent = new Intent(this,BindImmediateService.class);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_start_bind){
            boolean bindFlag = bindService(mIntent,mFirstConn,Context.BIND_AUTO_CREATE);
            Log.d(TAG,"bindFlag="+bindFlag);
        } else if (v.getId() == R.id.btn_start_unbind){
            if (mBindService != null){
                unbindService(mFirstConn);
                mBindService = null;
            }
        }
    }

    private BindImmediateService mBindService;
    private ServiceConnection mFirstConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBindService = ((BindImmediateService.LocalBinder) service).getService();
            Log.d(TAG,"onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBindService = null;
            Log.d(TAG,"onServiceDisconnected");
        }
    };

    public static void showText(String desc) {
        if (tv_immediate != null) {
            mDesc = String.format("%s%s %s\n", mDesc, DateUtil.getNowDateTime("HH:mm:ss"), desc);
            tv_immediate.setText(mDesc);
        }
    }
}
