package com.tsorrow.junior.group;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.tsorrow.junior.group.util.DateUtil;
import com.tsorrow.junior.group.util.Utils;
import com.tsorrow.junior.group.widget.CustomDateDialog;

import java.util.Calendar;

public class ToolbarCustomActivity extends AppCompatActivity implements View.OnClickListener, CustomDateDialog.OnDateSetListener {
    private final static String TAG = "ToolbarCustomActivity";
    private TextView tv_day;
    private TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_custom);

        tv_day = (TextView)findViewById(R.id.tv_day);
        tv_desc = (TextView)findViewById(R.id.tv_desc);
        Toolbar tl_head = (Toolbar)findViewById(R.id.tl_head);
        setSupportActionBar(tl_head);
        String day = DateUtil.getNowDateTime("yyyy年MM月dd日");
        tv_day.setText(day);
        tv_day.setOnClickListener(this);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Utils.setOverflowIconVisible(featureId,menu);
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        } else if (id == R.id.menu_refresh) {
            tv_desc.setText("当前刷新时间: "+Utils.getNowDateTime("yyyy-MM-dd HH:mm:ss"));
            return true;
        } else if (id == R.id.menu_about) {
            Toast.makeText(this, "这个是工具栏的演示demo", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.menu_quit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance();
        CustomDateDialog dialog = new CustomDateDialog(this);
        dialog.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), this);
        dialog.show();
    }

    @Override
    public void onDateSet(int year, int monthOfYear, int dayOfMonth) {
        String date = String.format("%d年%d月%d日", year, monthOfYear, dayOfMonth);
        tv_day.setText(date);
        tv_desc.setText("您选择的日期是"+date);
    }
}
