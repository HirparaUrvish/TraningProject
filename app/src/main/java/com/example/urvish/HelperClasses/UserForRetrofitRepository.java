package com.example.urvish.HelperClasses;

import com.example.urvish.InterfaceClasses.RetrofitAPIRequestInterfaceClass;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class UserForRetrofitRepository {

    public static RetrofitAPIRequestInterfaceClass callmyapi(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gorest.co.in/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPIRequestInterfaceClass commentsService = retrofit.create(RetrofitAPIRequestInterfaceClass.class);
        return commentsService;
    }
}