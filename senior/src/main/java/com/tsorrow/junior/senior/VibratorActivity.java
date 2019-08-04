package com.tsorrow.junior.senior;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.tsorrow.junior.senior.util.DateUtil;

import java.util.ArrayList;

public class VibratorActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_vibrator;
    private int[] durationArray={500, 1000, 2000, 3000, 4000, 5000};
    private String[] durationDescArray={"0.5秒", "1秒", "2秒", "3秒", "4秒", "5秒"};
    private int mDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator);

        Spinner sp_duration = (Spinner)findViewById(R.id.sp_duration);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_select,durationDescArray);
        sp_duration.setPrompt("请选择震动时长");
        sp_duration.setAdapter(adapter);
        sp_duration.setSelection(0);
        sp_duration.setOnItemSelectedListener(new DurationSelectedListener());

        findViewById(R.id.btn_start).setOnClickListener(this);
        tv_vibrator = (TextView)findViewById(R.id.tv_vibrator);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_start){
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(mDuration);
            String desc = String.format("%s 手机震动了%f秒", DateUtil.getNowTime(),mDuration/1000.0f);
            tv_vibrator.setText(desc);
        }
    }

    private class DurationSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mDuration = durationArray[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
