package com.tsorrow.test.network;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_message).setOnClickListener(this);
        findViewById(R.id.btn_progress_dialog).setOnClickListener(this);
        findViewById(R.id.btn_progress_text).setOnClickListener(this);
        findViewById(R.id.btn_progress_circle).setOnClickListener(this);
        findViewById(R.id.btn_async_task).setOnClickListener(this);
        findViewById(R.id.btn_intent_service).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_message){
            Intent intent = new Intent(MainActivity.this,MessageActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_progress_dialog){
            Intent intent = new Intent(MainActivity.this,ProgressDialogActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_progress_text){
            Intent intent = new Intent(MainActivity.this,ProgressTextActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_progress_circle){
            Intent intent = new Intent(MainActivity.this,ProgressCircleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_async_task){
            Intent intent = new Intent(MainActivity.this,AsyncTaskActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_intent_service){
            Intent intent = new Intent(MainActivity.this,IntentServiceActivity.class);
            startActivity(intent);
        }
    }
}
