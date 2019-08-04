package com.tsorrow.junior.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.tsorrow.junior.custom.widget.BeforeRelativeLayout;

public class OnDrawActivity extends AppCompatActivity {
    private String[] descArray={"不画图", "画矩形", "画圆角矩形", "画圆圈", "画椭圆", "画叉叉"};
    private int[] typeArray={0, 1, 2, 3, 4, 5};
    private Button btn_center;
    private BeforeRelativeLayout brl_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_draw);

        btn_center = (Button)findViewById(R.id.btn_center);
        brl_content = (BeforeRelativeLayout)findViewById(R.id.brl_content);
        Spinner sp_draw = (Spinner)findViewById(R.id.sp_draw);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_select,descArray);
        sp_draw.setPrompt("请选择绘图方式");
        sp_draw.setAdapter(adapter);
        sp_draw.setSelection(0);
        sp_draw.setOnItemSelectedListener(new DrawSelectedListener());
    }

    private class DrawSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int type = typeArray[position];
            if (type == 5){
                btn_center.setVisibility(View.VISIBLE);
            } else {
                btn_center.setVisibility(View.GONE);
            }
            brl_content.setDrawType(type);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
