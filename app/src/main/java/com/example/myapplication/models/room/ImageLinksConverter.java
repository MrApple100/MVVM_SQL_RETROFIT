package com.example.myapplication.models.room;

import androidx.room.TypeConverter;

import com.example.myapplication.models.ImageLinks;
import com.example.myapplication.models.Item;
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

