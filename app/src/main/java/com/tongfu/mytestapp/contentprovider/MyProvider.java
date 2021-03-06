package com.tongfu.mytestapp.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyProvider extends ContentProvider {
    public final static String Authority = "com.tongfu.mytestapp" ;
    SQLiteDatabase db ;
    @Override
    public boolean onCreate() {
        db = new DBHelper(getContext()).getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @NonNull String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.i("MyProvider" , "线程id：" +Thread.currentThread().getId() );
        return db.query("userinfo" , projection , selection , selectionArgs  ,null ,null ,sortOrder);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        switch (uri.getPath()){
            case "/userinfo":{
                long id = db.insert("userinfo" , null , values );
                return Uri.parse("content://com.tongfu.providertest/" + id ) ;
            }
        }

        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }


}
