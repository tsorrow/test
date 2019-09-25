package com.tsorrow.junior.readuser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView local_time;
    private Button local_refresh;
    private EditText local_time_set;
    private Button set_local;

    private TextView net_time;
    private Button net_refresh;
    private EditText net_time_set;
    private Button set_net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        local_time = (TextView) findViewById(R.id.tv_local_time);
        local_time_set = (EditText)findViewById(R.id.et_local_time);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        local_time.setText(simpleDateFormat.format(date));
        local_time_set.setText(simpleDateFormat.format(date));

        local_refresh = (Button)findViewById(R.id.btn_local_refresh);
        local_refresh.setOnClickListener(this);


        set_local = (Button)findViewById(R.id.btn_set_local);
        set_local.setOnClickListener(this);

        net_time = (TextView) findViewById(R.id.tv_net_time);
        net_time_set = (EditText)findViewById(R.id.et_net_time);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                long time = getNetTime();
                Date date1 = new Date(time);
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                net_time.setText(simpleDateFormat1.format(date1));
                net_time_set.setText(simpleDateFormat1.format(date1));
            }
        });


        net_refresh = (Button)findViewById(R.id.btn_net_refresh);
        net_refresh.setOnClickListener(this);


        set_net = (Button)findViewById(R.id.btn_set_net);
        set_net.setOnClickListener(this);
    }

    private long getNetTime() {
        URL url = null;//取得资源对象
        long id = 0L;
        try {
            url = new URL("http://www.baidu.com");
            //url = new URL("http://www.ntsc.ac.cn");//中国科学院国家授时中心
            //url = new URL("http://www.bjtime.cn");
            URLConnection uc = url.openConnection();//生成连接对象
            uc.setReadTimeout(5000);
            uc.setConnectTimeout(5000);
            uc.connect(); //发出连接
            id = uc.getDate(); //取得网站日期时间
        } catch (Exception e) {
            //e.printStackTrace();
            return new Date().getTime();
        }
        return id;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_local_refresh){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            local_time.setText(simpleDateFormat.format(date));
            local_time_set.setText(simpleDateFormat.format(date));
        }else if (v.getId() == R.id.btn_set_local){
            String desc = local_time_set.getText().toString();
            setSystemTime(this,desc);
        }else if (v.getId() == R.id.btn_net_refresh){
            long time = getNetTime();
            Date date1 = new Date(time);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            net_time.setText(simpleDateFormat1.format(date1));
            net_time_set.setText(simpleDateFormat1.format(date1));
            String aaa = Long.toString(time);
            Toast.makeText(this,aaa,Toast.LENGTH_SHORT).show();
        }else if (v.getId() == R.id.btn_set_net){
            String desc = net_time_set.getText().toString();
            setSystemTime(this,desc);
        }
    }

    public void setSystemTime(Context context, String time){
        if(time==null || time.isEmpty())return;
        try{
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(time);
            c.setTime(date);

            int YEAR= c.get(Calendar.YEAR);    //获取年
            int MONTH= c.get(Calendar.MONTH);    //获取月
            int DAY_OF_MONTH=c.get(Calendar.DAY_OF_MONTH);    //获取日
            int HOUR_OF_DAY=c.get(Calendar.HOUR_OF_DAY);    //获取时
            int MINUTE=c.get(Calendar.MINUTE);    //获取分
            int SECOND=c.get(Calendar.SECOND);    //获取秒
            int MILLISECOND=c.get(Calendar.MILLISECOND);    //获取毫秒


            Intent intent = new Intent();
            intent.setAction("com.rscja.android.updateSystemTime");
            intent.putExtra("YEAR", YEAR);
            intent.putExtra("MONTH", MONTH);
            intent.putExtra("DAY_OF_MONTH", DAY_OF_MONTH);
            intent.putExtra("HOUR_OF_DAY", HOUR_OF_DAY);
            intent.putExtra("MINUTE", MINUTE);
            intent.putExtra("SECOND", SECOND);
            intent.putExtra("MILLISECOND", MILLISECOND);
            //intent.setPackage("com.rscja.reboot");
            context.sendBroadcast(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
