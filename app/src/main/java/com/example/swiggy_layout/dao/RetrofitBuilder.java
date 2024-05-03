package com.example.swiggy_layout.dao;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private RetrofitBuilder() {
    }

    static Retrofit retrofit = null;

    public static Retrofit buildObject() {
        if (retrofit != null) {
            return retrofit;
        }
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
