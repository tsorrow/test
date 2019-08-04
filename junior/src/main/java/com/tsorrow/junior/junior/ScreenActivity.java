package com.tsorrow.junior.junior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tsorrow.junior.junior.util.DisplayUtil;

public class ScreenActivity extends AppCompatActivity {
    private TextView tv_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        tv_screen = (TextView) findViewById(R.id.tv_screen);
        showScreenInfo();
    }

    private void showScreenInfo() {
        int width = DisplayUtil.getScreenWidth(this);
        int height = DisplayUtil.getScreenHeight(this);
        float density = DisplayUtil.getScreenDensity(this);
        String info = String.format("当前屏幕的宽度是%s，高度是%s，像素密度是%f",width,height,density);
        tv_screen.setText(info);
    }
}
