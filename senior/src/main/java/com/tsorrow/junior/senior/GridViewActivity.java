package com.tsorrow.junior.senior;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.tsorrow.junior.senior.adapter.PlanetAdapter;
import com.tsorrow.junior.senior.bean.Planet;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    private final static String TAG = "GridViewActivity";
    private GridView gv_planet;
    private ArrayList<Planet> planetList;
    private int dividerPad = 2;

    private String[] dividerArray={
            "不显示分隔线",
            "只显示内部分隔线(NO_STRETCH)",
            "只显示内部分隔线(COLUMN_WIDTH)",
            "只显示内部分隔线(STRETCH_SPACING)",
            "只显示内部分隔线(SPACING_UNIFORM)",
            "显示全部分隔线(看我用padding大法)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        planetList = Planet.getDefaultList();
        PlanetAdapter adapter = new PlanetAdapter(this,R.layout.item_grid,planetList, Color.WHITE);
        gv_planet = (GridView) findViewById(R.id.gv_planet);
        gv_planet.setAdapter(adapter);
        gv_planet.setOnItemClickListener(adapter);
        gv_planet.setOnItemLongClickListener(adapter);

        ArrayAdapter<String> dividerAdapter = new ArrayAdapter<String>(this,R.layout.item_select,dividerArray);
        Spinner sp_grid = (Spinner)findViewById(R.id.sp_grid);
        sp_grid.setPrompt("请选择分隔线显示方式");
        sp_grid.setAdapter(dividerAdapter);
        sp_grid.setSelection(0);
        sp_grid.setOnItemSelectedListener(new DividerSelectedListener());
    }

    private class DividerSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            gv_planet.setBackgroundColor(Color.RED);
            gv_planet.setHorizontalSpacing(dividerPad);
            gv_planet.setVerticalSpacing(dividerPad);
            gv_planet.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
            gv_planet.setColumnWidth(250);
            gv_planet.setPadding(0, 0, 0, 0);
            if (position == 0) {
                gv_planet.setBackgroundColor(Color.WHITE);
                gv_planet.setHorizontalSpacing(0);
                gv_planet.setVerticalSpacing(0);
            } else if (position == 1) {
                gv_planet.setStretchMode(GridView.NO_STRETCH);
            } else if (position == 2) {
                gv_planet.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
            } else if (position == 3) {
                gv_planet.setStretchMode(GridView.STRETCH_SPACING);
            } else if (position == 4) {
                gv_planet.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
            } else if (position == 5) {
                gv_planet.setPadding(dividerPad, dividerPad, dividerPad, dividerPad);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
