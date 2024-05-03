package com.example.myapplication.data.models.room;

import androidx.room.TypeConverter;

import com.example.myapplication.data.models.Result;
import com.google.gson.Gson;

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
