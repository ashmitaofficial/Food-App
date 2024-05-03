package com.example.swiggy_layout.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiggy_layout.food.FoodActivity;
import com.example.swiggy_layout.R;
import com.example.swiggy_layout.restaurant.RestaurantModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<RestaurantModel> myList;

    private Context context;

    public HomeAdapter(List<RestaurantModel> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_item, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.desc.setText(myList.get(position).getDesc());
        holder.restaurant_name.setText(myList.get(position).getRname());
        holder.rating.setText(myList.get(position).getRating());
        Picasso.get().load(myList.get(position).getPic()).placeholder(R.drawable.errorpic).into(holder.restaurant_pic);
        if(!myList.get(position).isFreeDelivery()){
            holder.free_delivery.setVisibility(View.GONE);
        }
        else {
            holder.free_delivery.setVisibility(View.VISIBLE);
        }

        holder.cardview_resturant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, FoodActivity.class);
                //adapter se jab bhi intent lagta h tab ye line add hoti h zarur
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id",myList.get(position).getRid());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView restaurant_name, rating, desc;
        private ImageView restaurant_pic,free_delivery;
        private CardView cardview_resturant;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            restaurant_pic = itemView.findViewById(R.id.restaurant_pic);
            restaurant_name = itemView.findViewById(R.id.restaurant_name);
            rating = itemView.findViewById(R.id.Rating);
            desc = itemView.findViewById(R.id.desc);
            free_delivery = itemView.findViewById(R.id.free_delivery);
            cardview_resturant=itemView.findViewById(R.id.cardview_resturant);


        }
    }
}
