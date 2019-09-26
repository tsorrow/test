package com.tsorrow.junior.readuser;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button mBluetooth;
    private Button mBarcode_key;
    private Button mBarcode_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBluetooth = (Button) findViewById(R.id.chainway_bluetooth);
        mBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BluetoothTestActivity.class);
                startActivity(intent);
            }
        });

        mBarcode_key = (Button) findViewById(R.id.chainway_barcode_key);
        mBarcode_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BarcodeKeyActivity.class);
                startActivity(intent);
            }
        });

        mBarcode_api = (Button) findViewById(R.id.chainway_barcode_api);
        mBarcode_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BarcodeApiActivity.class);
                startActivity(intent);
            }
        });

        mBarcode_api = (Button) findViewById(R.id.chainway_date);
        mBarcode_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DateActivity.class);
                startActivity(intent);
            }
        });

        mBarcode_api = (Button) findViewById(R.id.chainway_view);
        mBarcode_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
