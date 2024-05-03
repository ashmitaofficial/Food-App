package com.example.swiggy_layout.my_orders;

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

public class OrderViewModel extends ViewModel {

    private Retrofit retrofit=null;
    public MutableLiveData<List<OrderModel>> liveData=new MutableLiveData<>();

    public void getData(Context context,String mobile) {

        retrofit = RetrofitBuilder.buildObject();

        // Linking Api by retrofit....
        retrofit.create(ApiInterface.class).getOrder(mobile).enqueue(new Callback<List<OrderModel>>() {
            //when the data is successfully fetched from API....
            @Override
            public void onResponse(Call<List<OrderModel>> call, Response<List<OrderModel>> response) {
                List<OrderModel> listnew = response.body();
                liveData.postValue(listnew);

            }

            //when the data is  not fetched from API....
            @Override
            public void onFailure(Call<List<OrderModel>> call, Throwable t) {
                Toast.makeText(context,"Unable to connect with server",Toast.LENGTH_LONG).show();
            }

        });

    }

}
