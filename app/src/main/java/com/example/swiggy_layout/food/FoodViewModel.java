package com.example.swiggy_layout.food;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.swiggy_layout.dao.ApiInterface;
import com.example.swiggy_layout.dao.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FoodViewModel extends ViewModel {
    private Retrofit retrofit=null;
    public MutableLiveData<List<FoodModel>> liveData= new MutableLiveData<>();

    public void getData(Context context,String rid)
    {
        retrofit= RetrofitBuilder.buildObject();
        retrofit.create(ApiInterface.class).getFood(rid).enqueue(new Callback<List<FoodModel>>() {
            @Override
            public void onResponse(Call<List<FoodModel>> call, Response<List<FoodModel>> response) {
                List<FoodModel> list=response.body();
                liveData.postValue(list);

            }

            @Override
            public void onFailure(Call<List<FoodModel>> call, Throwable t) {
                Toast.makeText(context,"Unable to connect with server",Toast.LENGTH_LONG).show();

            }
        });
    }
}
