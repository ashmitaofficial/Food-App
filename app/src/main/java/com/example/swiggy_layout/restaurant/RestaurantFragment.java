package com.example.swiggy_layout.restaurant;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
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
import com.example.swiggy_layout.home.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantFragment extends Fragment {

    private RecyclerView recyclerView;

    private ProgressBar progressBar;

    private SearchView searchView;
    private RestaurantViewModel restaurantViewModel;
    List<RestaurantModel> originalList =new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_restaurant, container, false);

        setupLayout(view);
        return view.getRootView();
    }
    private void setupLayout(View view)
    {

        recyclerView = view.findViewById(R.id.myRecycler_View);
        progressBar=view.findViewById(R.id.progress_bar);
        searchView=view.findViewById(R.id.search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);


        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        restaurantViewModel.getData(getContext());
        restaurantViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<List<RestaurantModel>>() {
            @Override
            public void onChanged(List<RestaurantModel> models) {
                originalList = models;
                recyclerView.setAdapter(new HomeAdapter(originalList, getContext()));
                recyclerView.getAdapter().notifyDataSetChanged();

                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

            }
        });

    }
    //filter list on based of search results...
    private void filterList(String text)
    {
        List<RestaurantModel> filteredList=new ArrayList<>();
        for(RestaurantModel model: originalList) {
            if (model.getRname().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(model);
            }
        }
        //setting adapter with filtered list......
        recyclerView.setAdapter(new HomeAdapter(filteredList, getContext()));
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}