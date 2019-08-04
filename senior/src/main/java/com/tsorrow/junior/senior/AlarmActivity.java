package com.tsorrow.junior.senior;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.tsorrow.junior.senior.util.DateUtil;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "AlarmActivity";
    private static TextView tv_alarm;
    private int mDelay;

    private int[] delayArray = {5,10,15,20,25,30};
    private String[] delayDescArray = {"5秒","10秒","15秒","20秒","25秒","30秒"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_select,delayDescArray);
        Spinner sp_delay = (Spinner)findViewById(R.id.sp_delay);
        sp_delay.setPrompt("请选择闹钟延迟");
        sp_delay.setAdapter(adapter);
        sp_delay.setSelection(0);
        sp_delay.setOnItemSelectedListener(new DelaySelectedListener());

        tv_alarm = (TextView)findViewById(R.id.tv_alarm);
        findViewById(R.id.btn_alarm).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_alarm){
            Intent intent = new Intent(ALARM_EVENT);
            PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmMgr = (AlarmManager) getSystemService(ALARM_SERVICE);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(Calendar.SECOND, mDelay);
            alarmMgr.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pIntent);
            mDesc = DateUtil.getNowTime() + " 设置闹钟";
            tv_alarm.setText(mDesc);
        }
    }

    public static class AlarmReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent!=null) {
                Log.d(TAG, "AlarmReceiver onReceive");
                if (tv_alarm!=null && bArrived==false) {
                    bArrived = true;
                    mDesc = String.format("%s\n%s 闹钟时间到达", mDesc, DateUtil.getNowTime());
                    tv_alarm.setText(mDesc);
                }
            }
        }
    }

    private String ALARM_EVENT = "com.tsorrow.junior.senior.AlarmActivity.AlarmReceiver";
    private static String mDesc = "";
    private static boolean bArrived = false;

    private class DelaySelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mDelay = delayArray[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
