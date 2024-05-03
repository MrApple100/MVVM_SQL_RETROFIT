package com.example.myapplication.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.data.models.RequestResult;

@Dao
public interface RequestResultDAO {

    @Query("???")//необходимо реализовать запрос
    public RequestResult getRequestResultBySearchText(String searchText);

    @Insert
    public void insertRequestResult(RequestResult requestResult);

    @Update
    public void updateRequestResult(RequestResult requestResult);
}
