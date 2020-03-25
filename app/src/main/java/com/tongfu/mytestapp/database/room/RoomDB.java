package com.tongfu.mytestapp.database.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RoomUser.class} , version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    public abstract RoomUserDao getRoomUserDao();
    public static RoomDB getInstance(Context context){
        return Room.databaseBuilder(context , RoomDB.class , "database_room").allowMainThreadQueries().build();
    }
}
