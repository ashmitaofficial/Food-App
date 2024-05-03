package com.example.swiggy_layout.restaurant;

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

public class RestaurantViewModel extends ViewModel {
    private Retrofit retrofit=null;

    public MutableLiveData<List<RestaurantModel>> liveData= new MutableLiveData<>();

    //yaha pe retrofit se data layege api me or main activity me observe ko bhejenge jisse ki vo trigger ho jayegi...or context andar sirf toast k liye liya h lena h to lo warna mat lo
    public void getData(Context context)
    {
        retrofit= RetrofitBuilder.buildObject();
        retrofit.create(ApiInterface.class).getRestaurants().enqueue(new Callback<List<RestaurantModel>>() {
            @Override
            public void onResponse(Call<List<RestaurantModel>> call, Response<List<RestaurantModel>> response) {
                List<RestaurantModel> listnew=response.body();
                liveData.postValue(listnew);

            }

            @Override
            public void onFailure(Call<List<RestaurantModel>> call, Throwable t) {
                Toast.makeText(context,"Unable to connect with server",Toast.LENGTH_LONG).show();

            }
        });

    }


}
