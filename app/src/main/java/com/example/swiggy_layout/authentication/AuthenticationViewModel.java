package com.example.swiggy_layout.authentication;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.swiggy_layout.dao.ApiInterface;
import com.example.swiggy_layout.dao.RetrofitBuilder;

import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthenticationViewModel extends ViewModel {
    private Retrofit retrofit = null;
    public MutableLiveData<UserModel> liveData = new MutableLiveData<>();

    public void signUp(Context context, HashMap object) {
        //making retrofit obj by retrofit builder
        retrofit = RetrofitBuilder.buildObject();

        retrofit.create(ApiInterface.class).signup(object).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.body() == true) {
                    Toast.makeText(context, "Account created successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Account already exists", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(context, "Unable to connect with server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void login(Context context, HashMap map) {
        retrofit = RetrofitBuilder.buildObject();
        retrofit.create(ApiInterface.class).login(map).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.body() == null) {
                    Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show();
                } else {
                    //send response to activity/fragment......
                    liveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
