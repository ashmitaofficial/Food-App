package com.example.swiggy_layout.dao;

import com.example.swiggy_layout.authentication.UserModel;
import com.example.swiggy_layout.restaurant.RestaurantModel;
import com.example.swiggy_layout.my_orders.OrderModel;
import com.example.swiggy_layout.food.FoodModel;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

@POST("signup")
Call<Boolean> signup(@Body HashMap object);

@POST("login")
Call<UserModel> login(@Body HashMap object);

@GET("restaurants")
Call<List<RestaurantModel>> getRestaurants();

@GET("profile/{mobile}")
Call<UserModel> getProfile(@Path("mobile")String mobile);

@GET("order/{mobile}")
    Call<List<OrderModel>> getOrder(@Path("mobile")String mobile);

@GET("food/{id}")
    Call<List<FoodModel>> getFood(@Path("id")String id);

@POST("profile")
    Call<Boolean> update(@Body HashMap obj);
}
