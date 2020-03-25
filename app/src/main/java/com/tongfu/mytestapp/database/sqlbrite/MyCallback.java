package com.tongfu.mytestapp.database.sqlbrite;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public class MyCallback extends SupportSQLiteOpenHelper.Callback {
    public MyCallback(int version) {
        super(version);
    }

    @Override
    public void onCreate(SupportSQLiteDatabase db) {
        final String sql_user = "create table if not exists my_user(id integer primary key autoincrement,name varchar(50)) " ;
        db.execSQL(sql_user);
    }

    @Override
    public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
