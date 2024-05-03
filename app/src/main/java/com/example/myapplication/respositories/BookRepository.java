package com.example.myapplication.respositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.myapplication.AppDatabase;
import com.example.myapplication.api.BookSearchService;
import com.example.myapplication.dao.RequestResultDAO;
import com.example.myapplication.models.RequestResult;
import com.example.myapplication.models.Result;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//https://www.googleapis.com/books/v1/volumes?q=1
public class BookRepository {
    private static final String BASE_URL = "https://www.googleapis.com";//необходимо вписать
    private BookSearchService bookSearchService;
    private RequestResultDAO requestResultDAO;
    private MutableLiveData<Result> resultLiveData;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public BookRepository(Context context) {
        AppDatabase appDatabase = Room.databaseBuilder(context,AppDatabase.class,"MyRequestResult").build();
        requestResultDAO = appDatabase.requestResultDAO();

        resultLiveData = new MutableLiveData<>();
        bookSearchService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookSearchService.class);
    }

    public LiveData<Result> getResultLiveData() {
        return resultLiveData;
    }

    public void searchResult(String keyword) {
        executorService.execute(()-> {
            Result results = getResultBySearchText(keyword);
            if (results != null) {
                resultLiveData.postValue(results);
            } else {
                fetchBooks(keyword);
            }
        });


    }

    public void fetchBooks(String keyword){
        bookSearchService.searchBooks(keyword).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.body() != null) {
                    resultLiveData.postValue(response.body());
                    insertRequestResult(new RequestResult(keyword,response.body()));
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("RRR", t.getMessage());
                resultLiveData.postValue(null);
            }
        });
    }

    public Result getResultBySearchText(String searchText){
        RequestResult rr = requestResultDAO.getRequestResultBySearchText(searchText);
        if(rr!=null){
            return requestResultDAO.getRequestResultBySearchText(searchText).getResult();
        }
        return null;
    }
    public void insertRequestResult(RequestResult requestResult){
        executorService.execute(()-> {
                requestResultDAO.insertRequestResult(requestResult);
            });

    }
}
