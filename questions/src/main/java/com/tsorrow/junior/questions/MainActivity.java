package com.tsorrow.junior.questions;


import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.tsorrow.junior.questions.bean.CameraInfo;


import com.tsorrow.junior.questions.adapter.CameraAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "CameraInfoActivity";
    private ListView lv_camera;
    private String mDesc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_camera = (ListView) findViewById(R.id.lv_camera);
        checkCamera();
    }

    @SuppressLint("DefaultLocale")
    private void checkCamera() {
        ArrayList<CameraInfo> cameraList = new ArrayList<CameraInfo>();
        int cameraCount = Camera.getNumberOfCameras();
        mDesc = String.format("%s摄像头个数=%d", mDesc, cameraCount);
        for (int i=0; i<cameraCount; i++) {
            CameraInfo info = new CameraInfo();
            Camera camera = Camera.open(i);
            Camera.Parameters params = camera.getParameters();
            info.camera_type = (i==0)?"前置":"后置";
            info.flash_mode = params.getFlashMode();
            info.focus_mode = params.getFocusMode();
            info.scene_mode = params.getSceneMode();
            info.color_effect = params.getColorEffect();
            info.white_balance = params.getWhiteBalance();
            info.max_zoom = params.getMaxZoom();
            info.zoom = params.getZoom();
            info.resolutionList = params.getSupportedPreviewSizes();
            camera.release();
            cameraList.add(info);
        }
        CameraAdapter adapter = new CameraAdapter(this, cameraList);
        lv_camera.setAdapter(adapter);
    }
}
