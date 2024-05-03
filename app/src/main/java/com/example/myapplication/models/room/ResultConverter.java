package com.example.myapplication.models.room;

import androidx.room.TypeConverter;

import com.example.myapplication.models.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class ResultConverter {
    Gson gson = new Gson();
    @TypeConverter
    public String fromResult(Result result) {

        return gson.toJson(result);
    }

    @TypeConverter
    public Result toResult(String data) {
        return gson.fromJson(data,Result.class);
    }
}
