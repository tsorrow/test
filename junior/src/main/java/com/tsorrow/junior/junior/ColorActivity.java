package com.tsorrow.junior.junior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        findViewById(R.id.tv_code_six).setBackgroundColor(0x00ff00);
        findViewById(R.id.tv_code_eight).setBackgroundColor(0xff00ff00);
    }
}
