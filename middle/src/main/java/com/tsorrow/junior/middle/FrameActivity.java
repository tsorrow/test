package com.tsorrow.junior.middle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class FrameActivity extends AppCompatActivity implements View .OnClickListener {
    private FrameLayout fl_content;
    private int[] mColorArray = {Color.BLACK, Color.WHITE, Color.RED, Color.YELLOW, Color.GREEN,
            Color.BLUE, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.DKGRAY};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        findViewById(R.id.btn_add_frame).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_frame){
            View view = new View(this);
            int random = (int) (Math.random()*10 % 10);
            view.setBackgroundColor(mColorArray[random]);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,(random+1)*50);
            view.setLayoutParams(params);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    fl_content.removeView(v);
                    return true;
                }
            });
            fl_content.addView(view);
        }
    }
}
