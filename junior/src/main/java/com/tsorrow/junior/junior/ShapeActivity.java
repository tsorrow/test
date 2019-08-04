package com.tsorrow.junior.junior;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShapeActivity extends AppCompatActivity implements View.OnClickListener{
    private View v_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        v_content = (View) findViewById(R.id.v_content);

        findViewById(R.id.btn_rect).setOnClickListener(this);
        findViewById(R.id.btn_oval).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_rect){
            v_content.setBackgroundResource(R.drawable.shape_rect_gold);
        }else if (v.getId() == R.id.btn_oval){
            v_content.setBackgroundResource(R.drawable.shape_oval_rose);
        }
    }
}
