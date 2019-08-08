package com.tsorrow.junior.custom;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NotifySimpleActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_title;
    private EditText et_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_simple);

        et_title = (EditText)findViewById(R.id.et_title);
        et_message = (EditText)findViewById(R.id.et_message);
        findViewById(R.id.btn_send_simple).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_send_simple){
            String title = et_title.getText().toString();
            String message = et_message.getText().toString();
            sendSimpleNotify(title,message);
        }
    }

    private void sendSimpleNotify(String title, String message) {
        Intent clickIntent = new Intent(this,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,R.string.app_name,clickIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(this);
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        builder.setAutoCancel(true);
        builder.setContentIntent(contentIntent);
        builder.setSmallIcon(R.drawable.ic_app);
        builder.setContentTitle(title);
        builder.setContentText(message);
        builder.setSubText("这里是副本");
        builder.setTicker("提示消息来了");
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_app));
        builder.setWhen(System.currentTimeMillis());

        Notification notify = builder.build();
        manager.notify(R.string.app_name,notify);
    }
}
