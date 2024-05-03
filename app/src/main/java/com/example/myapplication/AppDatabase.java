package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.local.dao.RequestResultDAO;
import com.example.myapplication.data.models.RequestResult;

@Database(entities = {RequestResult.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RequestResultDAO requestResultDAO();
}
