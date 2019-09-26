package com.tsorrow.junior.readuser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        findViewById(R.id.btn_child_file).setOnClickListener(this);

        File file = null;
        try {
            file = new File("/sdcard/bbb");
            if (!file.exists()) {
                file.mkdir();
            }
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(file);
            intent.setData(uri);
            sendBroadcast(intent);
        } catch (Exception e) {
            Log.i("error:", e+"");
        }
        Toast.makeText(this,"创建成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        File file1 = null;
        File file2 = null;
        try {
            file1 = new File("/sdcard/bbb/ccc");
            if (!file1.exists()) {
                file1.mkdir();
            }
            file2 = new File("/sdcard/bbb/aaa.txt");
            file2.createNewFile();
        } catch (Exception e) {
            Log.i("error:", e+"");
        }
    }
}
