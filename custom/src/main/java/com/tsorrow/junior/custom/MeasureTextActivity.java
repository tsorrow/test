package com.tsorrow.junior.custom;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.tsorrow.junior.custom.util.MeasureUtil;

public class MeasureTextActivity extends AppCompatActivity {
    private String[] descArray={"12sp", "15sp", "17sp", "20sp", "22sp", "25sp", "27sp", "30sp"};
    private int[] sizeArray={12, 15, 17, 20, 22, 25, 27, 30};
    private TextView tv_desc;
    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_text);

        tv_desc = (TextView)findViewById(R.id.tv_desc);
        tv_text = (TextView)findViewById(R.id.tv_text);
        Spinner sp_size = (Spinner)findViewById(R.id.sp_size);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_select,descArray);
        sp_size.setAdapter(adapter);
        sp_size.setPrompt("请选择文字大小");
        sp_size.setSelection(0);
        sp_size.setOnItemSelectedListener(new MyItemSelectedListener());
    }

    private class MyItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String text = tv_text.getText().toString();
            int textSize = sizeArray[position];
            tv_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
            int width = (int) MeasureUtil.getTextWidth(text, textSize);
            int height = (int) MeasureUtil.getTextHeight(text, textSize);
            String desc = String.format("下面文字的宽度是%s ,高度是%d", width, height);
            tv_desc.setText(desc);

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
