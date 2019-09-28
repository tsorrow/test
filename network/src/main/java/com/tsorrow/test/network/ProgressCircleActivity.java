package com.tsorrow.test.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tsorrow.test.network.widget.TextProgressCircle;

public class ProgressCircleActivity extends AppCompatActivity {
    private TextProgressCircle tpc_progress;
    private String[] progressArray = {"0","10","20","30","40","50","60","70","80","90","100"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_circle);

        tpc_progress = (TextProgressCircle)findViewById(R.id.tpc_progress);

        ArrayAdapter<String> progressAdapter = new ArrayAdapter<String>(this,
                R.layout.item_select, progressArray);
        Spinner sp_progress = (Spinner) findViewById(R.id.sp_progress);
        sp_progress.setPrompt("请选择进度值");
        sp_progress.setAdapter(progressAdapter);
        sp_progress.setOnItemSelectedListener(new DividerSelectedListener());
        sp_progress.setSelection(0);
    }

    private class DividerSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int progress = Integer.parseInt(progressArray[position]);
            tpc_progress.setProgress(progress,-1);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
