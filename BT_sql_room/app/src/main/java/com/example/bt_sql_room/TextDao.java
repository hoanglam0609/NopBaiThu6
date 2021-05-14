package com.example.bt_sql_room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TextDao {
    @Query("SELECT * FROM Text")
    List<Text> getAll();

    @Query("SELECT * FROM Text WHERE id IN (:userIds)")
    List<Text> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Text WHERE name LIKE :first LIMIT 1")
    Text findByName(String first);

    @Insert
    void insertAll(Text... users);

    @Delete
    void delete(Text user);

}
