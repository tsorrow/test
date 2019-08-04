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

public class SpinnerDropdownActivity extends AppCompatActivity {
    private String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_dropdown);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_select,starArray);
        adapter.setDropDownViewResource(R.layout.item_dropdown);

        Spinner sp_dropdown = (Spinner)findViewById(R.id.sp_dropdown);
        sp_dropdown.setPrompt("请选择行星");
        sp_dropdown.setAdapter(adapter);
        sp_dropdown.setSelection(0);
        sp_dropdown.setOnItemSelectedListener(new MyItemSelectedListener());
    }


    private class MyItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(SpinnerDropdownActivity.this,"您选择的是"+starArray[position],Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
