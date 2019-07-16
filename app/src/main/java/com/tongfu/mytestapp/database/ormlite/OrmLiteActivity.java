package com.tongfu.mytestapp.database.ormlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

public class OrmLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsqlite_open_helper);
        setTitle("DBSqliteOpenHelper");
    }
}
