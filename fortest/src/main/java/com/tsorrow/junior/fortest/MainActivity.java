package com.tsorrow.junior.fortest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_version).setOnClickListener(this);
        findViewById(R.id.btn_encrypt).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_version){
            Intent intent = new Intent(this,VersionActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_encrypt){
            Intent intent = new Intent(this,EncryptActivity.class);
            startActivity(intent);
        }
    }
}
