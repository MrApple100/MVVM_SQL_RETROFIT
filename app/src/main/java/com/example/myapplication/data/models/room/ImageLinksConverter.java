package com.example.myapplication.data.models.room;

import androidx.room.TypeConverter;

import com.example.myapplication.data.models.ImageLinks;
import com.google.gson.Gson;

public class ImageLinksConverter {
    Gson gson = new Gson();
    @TypeConverter
    public String fromImageLinks(ImageLinks imageLinks) {

        return gson.toJson(imageLinks);
    }

    @TypeConverter
    public ImageLinks toImageLinks(String data) {
        return gson.fromJson(data,ImageLinks.class);
    }
}

