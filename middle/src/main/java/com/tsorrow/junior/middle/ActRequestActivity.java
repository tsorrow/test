package com.tsorrow.junior.middle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tsorrow.junior.middle.util.DateUtil;

public class ActRequestActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_request;
    private TextView tv_request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_request);

        et_request = (EditText)findViewById(R.id.et_request);
        tv_request = (TextView)findViewById(R.id.tv_request);
        findViewById(R.id.btn_act_request).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_act_request){
            Intent intent = new Intent(this,ActResponseActivity.class);
            intent.putExtra("request_time", DateUtil.getNowTime());
            intent.putExtra("request_content",et_request.getText().toString());
            startActivityForResult(intent,0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int result_code,Intent data){
        if (data != null){
            String response_time = data.getStringExtra("response_time");
            String response_content = data.getStringExtra("response_content");
            String desc = String.format("收到返回信息：\n应答时间为%s\n应答内容为：%s",response_time,response_content);
            tv_request.setText(desc);
        }
    }
}
