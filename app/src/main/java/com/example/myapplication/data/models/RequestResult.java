package com.example.myapplication.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.myapplication.data.models.room.ResultConverter;

@Entity(tableName = "request_result_Table")
@TypeConverters({ResultConverter.class})
public class RequestResult {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo(name = "search_text")
    private String searchText;
    @ColumnInfo(name = "result")
    private Result result;
    public RequestResult(String searchText, Result result) {
        this.searchText = searchText;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
