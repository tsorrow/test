package com.tsorrow.junior.custom;

import com.tsorrow.junior.custom.CustomDateDialog.OnDateSetListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DialogDateActivity extends AppCompatActivity implements View.OnClickListener,OnDateSetListener {
    private TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_date);

        tv_date = (TextView)findViewById(R.id.tv_date);
        findViewById(R.id.btn_date).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_date){
            Calendar calendar = Calendar.getInstance();
            CustomDateDialog dialog = new CustomDateDialog(this);
            dialog.setDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),this);
            dialog.show();
        }
    }

    @Override
    public void onDateSet(int year, int month, int dayOfMonth) {
        String desc = String.format("您选择的日期是%d年%d月%d日",year,month,dayOfMonth);
        tv_date.setText(desc);
    }
}
