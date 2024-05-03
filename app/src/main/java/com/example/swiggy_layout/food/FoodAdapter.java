package com.example.swiggy_layout.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiggy_layout.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.foodViewHolder> {

    private List<FoodModel> mylist;

    private Context context;

    public FoodAdapter(List<FoodModel> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false);
        return new FoodAdapter.foodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull foodViewHolder holder, int position) {
        holder.desc.setText(mylist.get(position).getDescription());
        holder.ratingtxt.setText(mylist.get(position).getRating());
        holder.priceTxt.setText(mylist.get(position).getPrice());
        holder.Dish_nametxt.setText(mylist.get(position).getDish_name());
        Picasso.get().load(mylist.get(position).getPost()).placeholder(R.drawable.errorpic).into(holder.food_pic);

        if (mylist.get(position).isBestsellerTxt() == false) {
            holder.bestsellerTxt.setVisibility(View.GONE);
        } else {
            holder.bestsellerTxt.setVisibility(View.VISIBLE);
        }

        if (mylist.get(position).isVeg_sign() == true) {
            holder.veg_sign.setVisibility(View.VISIBLE);
            holder.nonveg_sign.setVisibility(View.INVISIBLE);
        } else {
            holder.veg_sign.setVisibility(View.INVISIBLE);
            holder.nonveg_sign.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class foodViewHolder extends RecyclerView.ViewHolder {

        private ImageButton veg_sign, nonveg_sign;
        private TextView bestsellerTxt, Dish_nametxt, priceTxt, ratingtxt, desc;
        private ImageView food_pic;

        public foodViewHolder(@NonNull View itemView) {
            super(itemView);

            veg_sign = itemView.findViewById(R.id.veg_sign);
            nonveg_sign = itemView.findViewById(R.id.nonveg_sign);
            bestsellerTxt = itemView.findViewById(R.id.bestsellerTxt);
            Dish_nametxt = itemView.findViewById(R.id.Dish_nametxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
            ratingtxt = itemView.findViewById(R.id.ratingtxt);
            desc = itemView.findViewById(R.id.desc);
            food_pic = itemView.findViewById(R.id.food_pic);

        }
    }
}
