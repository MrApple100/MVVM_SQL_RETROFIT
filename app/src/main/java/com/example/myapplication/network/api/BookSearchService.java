package com.example.myapplication.network.api;

import com.example.myapplication.data.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookSearchService {
    @GET("???")//необходимо вписать
    Call<Result> searchBooks(
        @Query("q") String query
    );
}
