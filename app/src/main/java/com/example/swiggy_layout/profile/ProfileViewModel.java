package com.example.swiggy_layout.profile;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.swiggy_layout.authentication.UserModel;
import com.example.swiggy_layout.dao.ApiInterface;
import com.example.swiggy_layout.dao.RetrofitBuilder;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfileViewModel extends ViewModel {
    private Retrofit retrofit = null;
    public MutableLiveData<UserModel> liveData = new MutableLiveData<>();

    //user details ki post API wala kaam ho rha h yaha
    public void update(Context context, HashMap obj) {
        //pehle retrofit ka obj banaya through retrofit builder
        retrofit = RetrofitBuilder.buildObject();
        //fir use link kiya update api se
        retrofit.create(ApiInterface.class).update(obj).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                //agar response aaya h to ye dikhega
                if (response.body() == true) {
                    Toast.makeText(context, "Profile updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Oops error occurred", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(context, "Unable to connect with server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getData(Context context, String mobile) {

        retrofit = RetrofitBuilder.buildObject();

        retrofit.create(ApiInterface.class).getProfile(mobile).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                UserModel userModel = response.body();
                liveData.postValue(userModel);

            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(context, "Unable to connect with server", Toast.LENGTH_LONG).show();

            }
        });


    }
}
