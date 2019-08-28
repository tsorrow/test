package com.tsorrow.junior.thirdsdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_map_baidu).setOnClickListener(this);
        findViewById(R.id.btn_map_gaode).setOnClickListener(this);
        findViewById(R.id.btn_share_qq).setOnClickListener(this);
        findViewById(R.id.btn_share_wx).setOnClickListener(this);
        findViewById(R.id.btn_alipay).setOnClickListener(this);
        findViewById(R.id.btn_wxpay).setOnClickListener(this);
        findViewById(R.id.btn_voice_recognize).setOnClickListener(this);
        findViewById(R.id.btn_voice_compose).setOnClickListener(this);
        findViewById(R.id.btn_rating_bar).setOnClickListener(this);
        findViewById(R.id.btn_take_tax).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_map_baidu) {
            Intent intent = new Intent(this, MapBaiduActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_map_gaode) {
            Intent intent = new Intent(this, MapGaodeActivity.class);
            startActivity(intent);
        }
    }
}
