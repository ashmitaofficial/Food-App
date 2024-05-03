package com.example.swiggy_layout.my_orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.swiggy_layout.R;
import com.example.swiggy_layout.utils.SharedPreferences;

import java.util.List;


public class OrderFragment extends Fragment {

    private RecyclerView recyclerView;

    private ProgressBar progressBar;
    private OrderViewModel orderViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_order, container, false);

        recyclerView = view.findViewById(R.id.order_recyclerview);
        progressBar = view.findViewById(R.id.progress_bar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        // linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //jab tak data ni milega tab tak jo wait h usme progress bar ghumega....
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);

        //link view model to activity
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        orderViewModel.getData(getContext(), SharedPreferences.getNumber(getContext()));
        orderViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<List<OrderModel>>() {
            @Override
            public void onChanged(List<OrderModel> orderList) {
                //setting recycler view items in adapter
                recyclerView.setAdapter(new OrderAdapter(orderList, getContext()));
                //refresh recycler view
                recyclerView.getAdapter().notifyDataSetChanged();

                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

            }
        });


        return view.getRootView();


    }
}