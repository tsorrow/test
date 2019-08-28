package com.tsorrow.junior.device;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class TurnViewActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private CheckBox ck_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_view);

        ck_control = (CheckBox) findViewById(R.id.ck_control);
        ck_control.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.ck_control) {
            if (isChecked == true) {
                ck_control.setText("停止");

            } else {
                ck_control.setText("转动");

            }
        }
    }
}
