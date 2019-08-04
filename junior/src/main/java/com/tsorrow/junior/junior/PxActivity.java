package com.tsorrow.junior.junior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tsorrow.junior.junior.util.Utils;

public class PxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_px);

        int dip_10 = Utils.dip2px(this,10L);
        TextView tv_padding = (TextView) findViewById(R.id.tv_padding);
        tv_padding.setPadding(dip_10,dip_10,dip_10,dip_10);
    }
}
