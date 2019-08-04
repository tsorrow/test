package com.tsorrow.junior.group;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ToolbarActivity extends AppCompatActivity {
    private final static String TAG = "ToolbarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        Toolbar tl_head = (Toolbar)findViewById(R.id.tl_head);
        tl_head.setNavigationIcon(R.drawable.ic_back);
        tl_head.setLogo(R.drawable.ic_app);
        tl_head.setTitle("工具栏页面");
        tl_head.setTitleTextColor(Color.RED);
        tl_head.setTitleTextAppearance(this,R.style.TabButton);
        tl_head.setSubtitle("Toolbar");
        tl_head.setSubtitleTextColor(Color.YELLOW);
        tl_head.setBackgroundResource(R.color.blue_light);
        setSupportActionBar(tl_head);
        tl_head.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
