package com.tsorrow.junior.middle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerIconActivity extends AppCompatActivity {
    private String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};
    private int[] iconArray = {R.drawable.shuixing, R.drawable.jinxing, R.drawable.diqiu,
            R.drawable.huoxing, R.drawable.muxing, R.drawable.tuxing};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_icon);

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i=0;i<iconArray.length;i++){
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("icon",iconArray[i]);
            item.put("name",starArray[i]);
            list.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.item_simple,new String[]{"icon","name"},new int[]{R.id.iv_icon,R.id.tv_name});
        adapter.setDropDownViewResource(R.layout.item_simple);

        Spinner sp_icon = (Spinner)findViewById(R.id.sp_icon);
        sp_icon.setPrompt("请选择行星");
        sp_icon.setAdapter(adapter);
        sp_icon.setSelection(0);
        sp_icon.setOnItemSelectedListener(new MyItemSelectedListener());
    }

    private class MyItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(SpinnerIconActivity.this,"您选择的是"+starArray[position],Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
