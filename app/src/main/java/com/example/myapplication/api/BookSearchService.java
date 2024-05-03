package com.example.myapplication.api;

import com.example.myapplication.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookSearchService {
    @GET("/books/v1/volumes")//необходимо вписать
    Call<Result> searchBooks(
        @Query("q") String query
    );
}
