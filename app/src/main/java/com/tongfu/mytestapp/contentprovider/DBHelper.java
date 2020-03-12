package com.tongfu.mytestapp.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context ) {
        super(context, "default", null , 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table userinfo (id integer primary key autoincrement , name varchar(90) , age integer)"  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
