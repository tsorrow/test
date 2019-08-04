package com.tsorrow.junior.middle;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AlertActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        findViewById(R.id.btn_alert).setOnClickListener(this);
        tv_alert = (TextView)findViewById(R.id.tv_alert);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_alert){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("尊敬的用户");
            builder.setMessage("你真的要卸载我吗？");
            builder.setPositiveButton("残忍卸载", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tv_alert.setText("虽然依依不舍，还是只能离开了");
                }
            });
            builder.setNegativeButton("我再想想", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tv_alert.setText("让我再陪你三百六十五个日夜");
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
