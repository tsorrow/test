package com.tsorrow.junior.group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TabThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_third);

        String desc = String.format("我是%s页面，来自%s",
                "购物车", getIntent().getExtras().getString("tag"));
        TextView tv_first = (TextView) findViewById(R.id.tv_third);
        Log.d("TabFirstActivity", "getId="+tv_first.getId());
        tv_first.setText(desc);
    }
}
