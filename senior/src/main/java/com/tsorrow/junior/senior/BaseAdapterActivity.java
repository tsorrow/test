package com.tsorrow.junior.senior;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.tsorrow.junior.senior.adapter.PlanetAdapter;
import com.tsorrow.junior.senior.bean.Planet;

import java.util.ArrayList;

public class BaseAdapterActivity extends AppCompatActivity {
    private ArrayList<Planet> planetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);

        initSpinner();
    }

    private void initSpinner() {
        planetList = Planet.getDefaultList();
        PlanetAdapter adapter = new PlanetAdapter(this,R.layout.item_list,planetList, Color.WHITE);
        Spinner sp = (Spinner)findViewById(R.id.sp_planet);
        sp.setPrompt("请选择行星");
        sp.setAdapter(adapter);
        sp.setSelection(0);
        sp.setOnItemSelectedListener(new MySelectedListener());
    }

    private class MySelectedListener implements android.widget.AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(BaseAdapterActivity.this, "您选择的是"+planetList.get(position).name, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
