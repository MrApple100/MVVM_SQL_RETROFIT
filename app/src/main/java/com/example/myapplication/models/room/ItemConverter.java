package com.example.myapplication.models.room;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.myapplication.models.Item;
import com.example.myapplication.models.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ItemConverter {
    Gson gson = new Gson();
    @TypeConverter
    public String fromItem(List<Item> items) {

        return gson.toJson(items);
    }

    @TypeConverter
    public List<Item> toItem(String data) {
        Type listType = new TypeToken<List<Item>>() {}.getType();
        return gson.fromJson(data,listType);
    }
}

