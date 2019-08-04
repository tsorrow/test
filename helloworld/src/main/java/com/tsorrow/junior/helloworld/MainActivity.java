package com.tsorrow.junior.helloworld;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_hello = (TextView)findViewById(R.id.tv_hello);
        tv_hello.setText("今天天气真热啊，火辣辣的");
        tv_hello.setTextColor(Color.RED);
        tv_hello.setTextSize(30);
    }
}
