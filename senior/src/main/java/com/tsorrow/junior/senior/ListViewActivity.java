package com.tsorrow.junior.senior;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.tsorrow.junior.senior.adapter.PlanetAdapter;
import com.tsorrow.junior.senior.bean.Planet;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private final static String TAG = "ListViewActivity";
    private ListView lv_planet;
    private ArrayList<Planet> planetList;
    private Drawable drawable;
    private int dividerHeight = 5;


    private String[] dividerArray={
            "不显示分隔线(分隔线高度为0)",
            "不显示分隔线(分隔线为null)",
            "只显示内部分隔线(先设置分隔线高度)",
            "只显示内部分隔线(后设置分隔线高度)",
            "显示底部分隔线(高度是wrap_content)",
            "显示底部分隔线(高度是match_parent)",
            "显示顶部分隔线(别瞎折腾了，显示不了)",
            "显示全部分隔线(看我用padding大法)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayAdapter<String> dividerAdapter = new ArrayAdapter<String>(this,R.layout.item_select,dividerArray);
        Spinner sp_list = (Spinner)findViewById(R.id.sp_list);
        sp_list.setPrompt("请选择分隔线显示方式");
        sp_list.setAdapter(dividerAdapter);
        sp_list.setSelection(0);
        sp_list.setOnItemSelectedListener(new DividerSelectedListener());

        planetList = Planet.getDefaultList();
        PlanetAdapter adapter = new PlanetAdapter(this,R.layout.item_list,planetList, Color.WHITE);
        lv_planet = (ListView)findViewById(R.id.lv_planet);
        lv_planet.setAdapter(adapter);
        lv_planet.setOnItemClickListener(adapter);
        lv_planet.setOnItemLongClickListener(adapter);
        drawable = getResources().getDrawable(R.drawable.divider_red2);
    }

    private class DividerSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lv_planet.setDivider(drawable);
            lv_planet.setDividerHeight(dividerHeight);
            lv_planet.setPadding(0, 0, 0, 0);
            lv_planet.setBackgroundColor(Color.TRANSPARENT);
            if (position == 0) {
                lv_planet.setDividerHeight(0);
            } else if (position == 1) {
                lv_planet.setDivider(null);
                lv_planet.setDividerHeight(dividerHeight);
            } else if (position == 2) {
                lv_planet.setDividerHeight(dividerHeight);
                lv_planet.setDivider(drawable);
            } else if (position == 3) {
                lv_planet.setDivider(drawable);
                lv_planet.setDividerHeight(dividerHeight);
            } else if (position == 4) {
                lv_planet.setFooterDividersEnabled(true);
            } else if (position == 5) {
                params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
                lv_planet.setFooterDividersEnabled(true);
            } else if (position == 6) {
                params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
                lv_planet.setFooterDividersEnabled(true);
                lv_planet.setHeaderDividersEnabled(true);
            } else if (position == 7) {
                lv_planet.setPadding(0, dividerHeight, 0, dividerHeight);
                lv_planet.setBackgroundDrawable(drawable);
            }
            lv_planet.setLayoutParams(params);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
