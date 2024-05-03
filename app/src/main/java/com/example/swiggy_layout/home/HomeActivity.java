package com.example.swiggy_layout.home;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.swiggy_layout.my_orders.OrderFragment;
import com.example.swiggy_layout.profile.ProfileFragment;
import com.example.swiggy_layout.R;
import com.example.swiggy_layout.restaurant.RestaurantFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        bottomNavigationView = findViewById(R.id.bottom_nav);



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.Explore_txt) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.container, RestaurantFragment.class, null)
                            .commit();
                    return true;
                } else if (menuItem.getItemId() == R.id.order_txt) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.container, OrderFragment.class, null)
                            .commit();
                    return true;
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.container, ProfileFragment.class, null)
                            .commit();
                    return true;
                }

            }
        });
        bottomNavigationView.setSelectedItemId(R.id.Explore_txt);

    }




}