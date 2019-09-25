package com.tsorrow.junior.device;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CameraInfoActivity extends AppCompatActivity {
    private final static String TAG = "CameraInfoActivity";
    private ListView lv_camera;
    private String mDesc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_info);

        lv_camera = (ListView)findViewById(R.id.lv_camera);
        checkCamera();
    }

    private void checkCamera() {


    }
}
