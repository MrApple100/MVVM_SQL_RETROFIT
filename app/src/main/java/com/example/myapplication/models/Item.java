package com.example.myapplication.models;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.myapplication.models.room.ItemConverter;
import com.example.myapplication.models.room.VolumeInfoConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@TypeConverters({VolumeInfoConverter.class})
public class Item {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("volumeInfo")
    @Expose

    private VolumeInfo volumeInfo;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public Item() {
    }
}


