package com.tsorrow.junior.fortest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tsorrow.junior.fortest.encrypt.AesUtil;
import com.tsorrow.junior.fortest.encrypt.Des3Util;
import com.tsorrow.junior.fortest.encrypt.MD5Util;
import com.tsorrow.junior.fortest.encrypt.RSAUtil;

import org.w3c.dom.Text;

public class EncryptActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = "EncryptActivity";
    private EditText et_raw;
    private TextView tv_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        et_raw = (EditText)findViewById(R.id.et_raw);
        tv_des = (TextView)findViewById(R.id.tv_des);
        findViewById(R.id.btn_md5).setOnClickListener(this);
        findViewById(R.id.btn_rsa).setOnClickListener(this);
        findViewById(R.id.btn_aes).setOnClickListener(this);
        findViewById(R.id.btn_3des).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String raw = et_raw.getText().toString();
        if (raw==null || raw.length()<=0) {
            Toast.makeText(this, "请输入待加密字符串", Toast.LENGTH_LONG).show();
            return;
        }
        if (v.getId() == R.id.btn_md5) {
            String enStr = MD5Util.encrypBy(raw);
            tv_des.setText("MD5的加密结果是:"+enStr);
        } else if (v.getId() == R.id.btn_rsa) {
            String enStr = RSAUtil.encodeRSA(null, raw);
            tv_des.setText("加密结果是:"+enStr);
        } else if (v.getId() == R.id.btn_aes) {
            try {
                String seed = "a";
                String enStr = AesUtil.encrypt(seed, raw);
                String deStr = AesUtil.decrypt(seed, enStr);
                String desc = String.format("加密结果是:%s\n解密结果是:%s", enStr, deStr);
                tv_des.setText(desc);
            } catch (Exception e) {
                e.printStackTrace();
                tv_des.setText("AES加密/解密失败");
            }
        } else if (v.getId() == R.id.btn_3des) {
            String key = "a";
            String enStr = Des3Util.encrypt(key, raw);
            String deStr = Des3Util.decrypt(key, enStr);
            String desc = String.format("加密结果是:%s\n解密结果是:%s", enStr, new String(deStr));
            tv_des.setText(desc);
        }
    }
}
