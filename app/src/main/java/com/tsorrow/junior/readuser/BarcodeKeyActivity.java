package com.tsorrow.junior.readuser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class BarcodeKeyActivity extends AppCompatActivity {
    private String mBarcodeKey;
    private BarcodeKeyReceiver barcodeKeyReceiver;
    private EditText mKeyValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_key);

        mKeyValue = (EditText) findViewById(R.id.key_value);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.scanner.broadcast");
        barcodeKeyReceiver = new BarcodeKeyReceiver();
        registerReceiver(barcodeKeyReceiver,intentFilter);
    }

    class BarcodeKeyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            mBarcodeKey = intent.getStringExtra("data");
            mKeyValue.setText(mBarcodeKey);
        }
    }
}
