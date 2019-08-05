package com.tsorrow.junior.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class WindowActivity extends AppCompatActivity {
    private TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setContentView(R.layout.activity_window);
        getWindow().setLayout(800, 800);
		getWindow().setBackgroundDrawableResource(R.drawable.icon_header);

        tv_info = (TextView)getWindow().findViewById(R.id.tv_info);
        tv_info.setText("我在直接操作窗口啦");
    }
}
