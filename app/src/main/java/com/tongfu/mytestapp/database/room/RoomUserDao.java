package com.tongfu.mytestapp.database.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RoomUserDao {
    @Query("select * from user")
    List<RoomUser> select();
    @Delete
    void deleteById(RoomUser roomUser);
    @Insert
    void insert(RoomUser roomUser);
    @Update
    void update(RoomUser roomUser);
}
