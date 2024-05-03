package com.example.myapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.models.RequestResult;
import com.example.myapplication.models.Result;

import java.util.List;

@Dao
public interface RequestResultDAO {

    @Query("SELECT * FROM REQUEST_RESULT_TABLE WHERE search_text=:searchText")
    public RequestResult getRequestResultBySearchText(String searchText);

    @Insert
    public void insertRequestResult(RequestResult requestResult);

    @Update
    public void updateRequestResult(RequestResult requestResult);
}
