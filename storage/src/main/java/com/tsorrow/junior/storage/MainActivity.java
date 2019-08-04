package com.tsorrow.junior.storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_share_write).setOnClickListener(this);
        findViewById(R.id.btn_share_read).setOnClickListener(this);
        findViewById(R.id.btn_login_share).setOnClickListener(this);
        findViewById(R.id.btn_sqlite_write).setOnClickListener(this);
        findViewById(R.id.btn_sqlite_read).setOnClickListener(this);
        findViewById(R.id.btn_login_sqlite).setOnClickListener(this);
        findViewById(R.id.btn_file_basic).setOnClickListener(this);
        findViewById(R.id.btn_text_write).setOnClickListener(this);
        findViewById(R.id.btn_text_read).setOnClickListener(this);
        findViewById(R.id.btn_image_write).setOnClickListener(this);
        findViewById(R.id.btn_image_read).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_share_write){
            Intent intent = new Intent(this,ShareWriteActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_share_read){
            Intent intent = new Intent(this,ShareReadActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_login_share){
            Intent intent = new Intent(this,LoginShareActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_sqlite_write){
            Intent intent = new Intent(this,SQLiteWriteActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_sqlite_read){
            Intent intent = new Intent(this,SQLiteReadActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_login_sqlite){
            Intent intent = new Intent(this,LoginSQLiteActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_file_basic){
            Intent intent = new Intent(this,FileBasicActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_text_write){
            Intent intent = new Intent(this,TextWriteActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_text_read){
            Intent intent = new Intent(this,TextReadActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_image_write){
            Intent intent = new Intent(this,ImageWriteActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_image_read){
            Intent intent = new Intent(this,ImageReadActivity.class);
            startActivity(intent);
        }
    }
}
