package com.example.bt_sql_room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Text.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TextDao textDao();
}
