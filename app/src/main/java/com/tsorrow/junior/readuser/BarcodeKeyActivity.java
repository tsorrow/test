package com.tsorrow.junior.readuser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

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
        intentFilter.addAction("com.scanner.scancontext");
        barcodeKeyReceiver = new BarcodeKeyReceiver();
        registerReceiver(barcodeKeyReceiver,intentFilter);
    }

    class BarcodeKeyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            mBarcodeKey = intent.getStringExtra("Scan.context");
            mKeyValue.setText(mBarcodeKey);
        }
    }
}
