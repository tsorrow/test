package com.tsorrow.junior.storage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

public class SQLiteReadActivity extends AppCompatActivity {
    private TextView tv_sqlite;
    private SharedPreferences mShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_read);

        tv_sqlite = (TextView)findViewById(R.id.tv_sqlite);
        readSharedPreferences();
    }

    private void readSharedPreferences() {

    }
}
