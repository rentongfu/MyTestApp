package com.tongfu.mytestapp.database.dbsqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(Context context){
        super(context, ("db_sqliteopenhelper"), null , 7 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String sql_user = "create table if not exists my_user(id integer primary key autoincrement,name varchar(50)) " ;
        db.execSQL(sql_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
