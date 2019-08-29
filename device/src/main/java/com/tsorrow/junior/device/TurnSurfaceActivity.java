package com.tsorrow.junior.device;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.tsorrow.junior.device.widget.TurnSurfaceView;

public class TurnSurfaceActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private TurnSurfaceView tsv_circle;
    private CheckBox ck_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_surface);

        tsv_circle = (TurnSurfaceView)findViewById(R.id.tsv_circle);
        ck_control = (CheckBox) findViewById(R.id.ck_control);
        ck_control.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.ck_control) {
            if (isChecked == true) {
                ck_control.setText("停止");
                tsv_circle.start();
            } else {
                ck_control.setText("转动");
                tsv_circle.stop();
            }
        }
    }
}
