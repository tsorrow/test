package com.tsorrow.junior.storage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tsorrow.junior.storage.util.DateUtil;

public class ShareWriteActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    private SharedPreferences mShared;
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private  EditText et_weight;
    private boolean bMarried = false;
    private String[] typeArray = {"未婚", "已婚"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_write);

        et_name = (EditText)findViewById(R.id.et_name);
        et_age = (EditText)findViewById(R.id.et_age);
        et_height = (EditText)findViewById(R.id.et_height);
        et_weight = (EditText)findViewById(R.id.et_weight);
        findViewById(R.id.btn_save).setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_select,typeArray);
        adapter.setDropDownViewResource(R.layout.item_dropdown);
        Spinner sp_married = (Spinner) findViewById(R.id.sp_married);
        sp_married.setPrompt("请选择婚姻状况");
        sp_married.setAdapter(adapter);
        sp_married.setSelection(0);
        sp_married.setOnItemSelectedListener(this);

        mShared = getSharedPreferences("share",MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_save){
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();
            if (name == null || name.length() <= 0){
                showToast("请先输入姓名");
                return;
            }
            if (age == null || age.length() <= 0){
                showToast("请先输入年龄");
                return;
            }
            if (height == null || height.length() <= 0){
                showToast("请先输入身高");
                return;
            }
            if (weight == null || weight.length() <= 0){
                showToast("请先输入体重");
                return;
            }
            SharedPreferences.Editor editor = mShared.edit();
            editor.putString("name",name);
            editor.putInt("age", Integer.parseInt(age));
            editor.putLong("height",Long.parseLong(height));
            editor.putFloat("weight",Float.parseFloat(weight));
            editor.putBoolean("married",bMarried);
            editor.putString("update_time", DateUtil.getNowDateTime());
            editor.commit();
            showToast("数据已写入共享参数");
        }
    }

    private void showToast(String desc) {
        Toast.makeText(this,desc,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        bMarried = (position == 0)?false:true;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
