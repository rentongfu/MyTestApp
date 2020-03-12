package com.tongfu.mytestapp.database.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
