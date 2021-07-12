package com.deepakkumarinc.newsapp;

import com.deepakkumarinc.newsapp.Models.MainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

        String BASEURL ="https://newsapi.org/v2/";

        @GET("top-headlines")
        Call<MainNews> getNews(
                @Query("country") String Country,
                @Query("pageSize") int pageSize,
                @Query("apiKey") String apiKey

        );
    @GET("top-headlines")
    Call<MainNews> getCategoryNews(
            @Query("country") String Country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey

    );
    }

