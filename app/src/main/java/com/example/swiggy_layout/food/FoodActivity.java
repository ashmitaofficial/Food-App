package com.example.swiggy_layout.food;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiggy_layout.R;

import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ProgressBar progressBar;
    private FoodViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //purani activity se id get karayi hai
        String rid=getIntent().getStringExtra("id");

        recyclerView=findViewById(R.id.food_recycler_view);
        progressBar=findViewById(R.id.progress_bar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);


        viewModel=new ViewModelProvider(this).get(FoodViewModel.class);
        viewModel.getData(this,rid);
        viewModel.liveData.observe(this, new Observer<List<FoodModel>>() {
            @Override
            public void onChanged(List<FoodModel> foodModels) {
                recyclerView.setAdapter(new FoodAdapter(foodModels,getApplicationContext()));
                recyclerView.getAdapter().notifyDataSetChanged();

                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });




    }
}