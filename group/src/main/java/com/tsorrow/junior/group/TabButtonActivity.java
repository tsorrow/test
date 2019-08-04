package com.tsorrow.junior.group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class TabButtonActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private TextView tv_tab_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_button);

        tv_tab_button = (TextView)findViewById(R.id.tv_tab_button);
        ((CheckBox)findViewById(R.id.ck_select)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.ck_select){
            tv_tab_button.setSelected(isChecked);
        }
    }
}
