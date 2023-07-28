package com.example.urvish.InterfaceClasses;

import com.example.urvish.modelClasses.RetrofitModal;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitAPIRequestInterfaceClass {

    @Headers({"Accept:application/json", "Content-Type:application/json", "Authorization:Bearer d91e7270b3dae69b445c70ee0fe3a22b2fe9472af239140cf0f2d94060589821"})
    @GET("public/v2/users")
    Call<List<RetrofitModal>> getRetrofitUser();

    @Headers({"Accept:application/json", "Content-Type:application/json", "Authorization:Bearer d91e7270b3dae69b445c70ee0fe3a22b2fe9472af239140cf0f2d94060589821"})
    @POST("public/v2/users")
    Call<RetrofitModal> AddNewRetrofitUser(@Body HashMap<String, String> retrofitModal);

    @Headers({"Accept:application/json", "Content-Type:application/json", "Authorization:Bearer d91e7270b3dae69b445c70ee0fe3a22b2fe9472af239140cf0f2d94060589821"})
    @DELETE("public/v2/users/{id}")
    Call<RetrofitModal> DeleteRetrofitUser(@Path("id") int url1);

    @Headers({"Accept:application/json", "Content-Type:application/json", "Authorization:Bearer d91e7270b3dae69b445c70ee0fe3a22b2fe9472af239140cf0f2d94060589821"})
    @PATCH("public/v2/users/{id}")
    Call<RetrofitModal> UpdateRetrofitUser(@Path("id") int url1, @Body HashMap<String, String> retrofitModal);

}