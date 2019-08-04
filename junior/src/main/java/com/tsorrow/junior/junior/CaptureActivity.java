package com.tsorrow.junior.junior;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tsorrow.junior.junior.util.DateUtil;

public class CaptureActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{
    private TextView tv_capture;
    private ImageView iv_capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        tv_capture = (TextView) findViewById(R.id.tv_capture);
        iv_capture = (ImageView) findViewById(R.id.iv_capture);
        tv_capture.setDrawingCacheEnabled(true);

        Button btn_chat = (Button) findViewById(R.id.btn_chat);
        btn_chat.setOnClickListener(this);
        btn_chat.setOnLongClickListener(this);
        Button btn_capture = (Button) findViewById(R.id.btn_capture);
        btn_capture.setOnClickListener(this);

    }

    private String[] mChatStr = { "你吃饭了吗？", "今天天气真好呀。",
            "我中奖啦！", "我们去看电影吧", "晚上干什么好呢？", };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_chat){
            int random = (int)(Math.random() * 10) % 5;
            String newStr = String.format("%s\n%s %s",tv_capture.getText().toString(), DateUtil.getNowDateTime(),mChatStr[random]);
            tv_capture.setText(newStr);
        }else if (v.getId() == R.id.btn_capture){
            Bitmap bitmap = tv_capture.getDrawingCache();
            iv_capture.setImageBitmap(bitmap);
            mHandler.postDelayed(mResetCache,200);

            Toast.makeText(this,"截图",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.btn_chat){
            tv_capture.setText("");
        }
        return true;
    }

    private Handler mHandler = new Handler();
    private Runnable mResetCache = new Runnable() {
        @Override
        public void run() {
            tv_capture.setDrawingCacheEnabled(false);
            tv_capture.setDrawingCacheEnabled(true);
        }
    };
}
