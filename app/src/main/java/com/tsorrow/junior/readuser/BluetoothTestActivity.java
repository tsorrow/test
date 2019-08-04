package com.tsorrow.junior.readuser;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BluetoothTestActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int REQUEST_ENABLE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_test);

        //获取本地蓝牙适配器
        BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!mAdapter.isEnabled()){
            //提示窗口是否打开
            Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enabler,REQUEST_ENABLE);
            //强行打开，需要权限
            //mAdapter.enable();
        }

    }
}
