package com.tongfu.mytestapp.database.room;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongfu.mytestapp.R;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsqlite_open_helper);
        setTitle("DBSqliteOpenHelper");
    }
}
