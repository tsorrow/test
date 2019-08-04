package com.tsorrow.junior.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tsorrow.junior.custom.widget.OffsetLayout;

public class OnLayoutActivity extends AppCompatActivity {
    private String[] descArray={"无偏移", "向左偏移100", "向右偏移100", "向上偏移100", "向下偏移100"};
    private int[] offsetArray={0, -100, 100, -100, 100};
    private static final String TAG = "OnLayoutActivity";
    private OffsetLayout ol_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_layout);

        ol_content = (OffsetLayout)findViewById(R.id.ol_content);

        Spinner sp_offset = (Spinner)findViewById(R.id.sp_offset);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_select,descArray);
        sp_offset.setPrompt("请选择偏移大小");
        sp_offset.setAdapter(adapter);
        sp_offset.setSelection(0);
        sp_offset.setOnItemSelectedListener(new OffsetSelectedListener());
    }

    private class OffsetSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int offset = offsetArray[position];
            if (position == 0 || position ==1 || position ==2){
                ol_content.setOffsetHorizontal(offset);
            } else if (position == 3 || position ==4){
                ol_content.setOffsetVertical(offset);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
