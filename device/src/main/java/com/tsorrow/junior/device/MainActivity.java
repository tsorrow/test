package com.tsorrow.junior.device;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_turn_view).setOnClickListener(this);
        findViewById(R.id.btn_turn_surface).setOnClickListener(this);
        findViewById(R.id.btn_camera_info).setOnClickListener(this);
        findViewById(R.id.btn_photograph).setOnClickListener(this);
        findViewById(R.id.btn_trun_texture).setOnClickListener(this);
        findViewById(R.id.btn_shooting).setOnClickListener(this);
        findViewById(R.id.btn_seekbar).setOnClickListener(this);
        findViewById(R.id.btn_volumn).setOnClickListener(this);
        findViewById(R.id.btn_audio).setOnClickListener(this);
        findViewById(R.id.btn_video).setOnClickListener(this);
        findViewById(R.id.btn_sensor).setOnClickListener(this);
        findViewById(R.id.btn_acceleration).setOnClickListener(this);
        findViewById(R.id.btn_light).setOnClickListener(this);
        findViewById(R.id.btn_direction).setOnClickListener(this);
        findViewById(R.id.btn_step).setOnClickListener(this);
        findViewById(R.id.btn_flash).setOnClickListener(this);
        findViewById(R.id.btn_location_setting).setOnClickListener(this);
        findViewById(R.id.btn_location_begin).setOnClickListener(this);
        findViewById(R.id.btn_wechat).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_turn_view) {
            Intent intent = new Intent(this, TurnViewActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_turn_surface) {
            Intent intent = new Intent(this, TurnSurfaceActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_camera_info) {
            Intent intent = new Intent(this, CameraInfoActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_photograph) {
            Intent intent = new Intent(this, PhotographActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_trun_texture) {
            Intent intent = new Intent(this, TurnTextureActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_shooting) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                Toast.makeText(MainActivity.this, "Andorid版本低于5.0",
                        Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, ShootingActivity.class);
                startActivity(intent);
            }
        }
    }
}
