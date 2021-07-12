package com.deepakkumarinc.newsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    public static Retrofit retrofit;

    public  static ApiInterface getApiInterface()
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ApiInterface.class);
    }

}
