package com.tsorrow.junior.custom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tsorrow.junior.custom.service.MusicService;

public class NotifyServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_song;
    private Button btn_send_service;
    private boolean bPlay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_service);

        et_song = (EditText)findViewById(R.id.et_song);
        btn_send_service = (Button)findViewById (R.id.btn_send_service);
        btn_send_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_send_service){
            Intent intent = new Intent(this,MusicService.class);
            intent.putExtra("is_play",bPlay);
            intent.putExtra("song",et_song.getText().toString());
            if (bPlay == true){
                startService(intent);
                btn_send_service.setText("停止播放音乐");
            } else {
                stopService(intent);
                btn_send_service.setText("开始播放音乐");
            }
            bPlay = !bPlay;
        }
    }
}
