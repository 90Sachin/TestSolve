package com.sachin.testsolve.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by window on 19/7/17.
 */

public class ServiceGenerator
{
    public static final String API_BASE_URL = "http://api.themoviedb.org/3/discover/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson));



    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }





    public static Retrofit getRetrofit()
    {
        return builder.client(httpClient.build()).build();
    }
}
