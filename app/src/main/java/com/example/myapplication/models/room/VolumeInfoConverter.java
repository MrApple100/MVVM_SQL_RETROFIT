package com.example.myapplication.models.room;

import androidx.room.TypeConverter;

import com.example.myapplication.models.Result;
import com.example.myapplication.models.VolumeInfo;
import com.google.gson.Gson;

public class VolumeInfoConverter {
    Gson gson = new Gson();
    @TypeConverter
    public String fromVolumeInfo(VolumeInfo volumeInfo) {

        return gson.toJson(volumeInfo);
    }

    @TypeConverter
    public VolumeInfo toVolumeInfo(String data) {
        return gson.fromJson(data,VolumeInfo.class);
    }
}

