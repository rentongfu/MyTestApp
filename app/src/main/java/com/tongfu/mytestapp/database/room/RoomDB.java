package com.tongfu.mytestapp.database.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {RoomUser.class} , version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    public abstract RoomUserDao getRoomUserDao();
    public static RoomDB getInstance(Context context){
        return Room.databaseBuilder(context , RoomDB.class , "database_room").allowMainThreadQueries().build();
    }
}
