package com.tsorrow.junior.middle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeCodeActivity extends AppCompatActivity implements View.OnClickListener{
    private RelativeLayout rl_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_code);

        rl_content = (RelativeLayout)findViewById(R.id.rl_content);
        findViewById(R.id.btn_add_left).setOnClickListener(this);
        findViewById(R.id.btn_add_above).setOnClickListener(this);
        findViewById(R.id.btn_add_right).setOnClickListener(this);
        findViewById(R.id.btn_add_below).setOnClickListener(this);
        findViewById(R.id.btn_add_center).setOnClickListener(this);
        findViewById(R.id.btn_add_parent_left).setOnClickListener(this);
        findViewById(R.id.btn_add_parent_top).setOnClickListener(this);
        findViewById(R.id.btn_add_parent_right).setOnClickListener(this);
        findViewById(R.id.btn_add_parent_bottom).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_left){
            addNewView(RelativeLayout.LEFT_OF,RelativeLayout.ALIGN_TOP,v.getId());
        }else if (v.getId() == R.id.btn_add_above){
            addNewView(RelativeLayout.ABOVE,RelativeLayout.ALIGN_LEFT,v.getId());
        }else if (v.getId() == R.id.btn_add_right){
            addNewView(RelativeLayout.RIGHT_OF,RelativeLayout.ALIGN_BOTTOM,v.getId());
        }else if (v.getId() == R.id.btn_add_below){
            addNewView(RelativeLayout.BELOW,RelativeLayout.ALIGN_RIGHT,v.getId());
        }else if (v.getId() == R.id.btn_add_center){
            addNewView(RelativeLayout.CENTER_IN_PARENT,-1,rl_content.getId());
        }else if (v.getId() == R.id.btn_add_parent_left){
            addNewView(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.CENTER_VERTICAL,rl_content.getId());
        }else if (v.getId() == R.id.btn_add_parent_top){
            addNewView(RelativeLayout.ABOVE,RelativeLayout.CENTER_HORIZONTAL,rl_content.getId());
        }else if (v.getId() == R.id.btn_add_parent_right){
            addNewView(RelativeLayout.ALIGN_PARENT_RIGHT,-1,rl_content.getId());
        }else if (v.getId() == R.id.btn_add_parent_bottom){
            addNewView(RelativeLayout.ALIGN_PARENT_BOTTOM,-1,rl_content.getId());
        }
    }

    private void addNewView(int firstAlign, int secondAlign, int referId) {
        View view = new View(this);
        view.setBackgroundColor(0xaa66ff66);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100,100);
        layoutParams.addRule(firstAlign,referId);
        if (secondAlign > 0){
            layoutParams.addRule(secondAlign,referId);
        }
        view.setLayoutParams(layoutParams);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                rl_content.removeView(v);
                return true;
            }
        });
        rl_content.addView(view);
    }
}
