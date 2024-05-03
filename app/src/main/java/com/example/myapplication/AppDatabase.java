package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.dao.RequestResultDAO;
import com.example.myapplication.models.ImageLinks;
import com.example.myapplication.models.Item;
import com.example.myapplication.models.RequestResult;
import com.example.myapplication.models.Result;
import com.example.myapplication.models.VolumeInfo;

@Database(entities = {RequestResult.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RequestResultDAO requestResultDAO();
}
