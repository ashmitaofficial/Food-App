package com.example.swiggy_layout.my_orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swiggy_layout.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<OrderModel> orderModelList;

    private Context context;

    public OrderAdapter(List<OrderModel> orderModelList, Context context) {
        this.orderModelList = orderModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        holder.restaurantName.setText(orderModelList.get(position).getRestaurantName());
        holder.address.setText(orderModelList.get(position).getAddress());
        holder.price.setText(orderModelList.get(position).getPrice());
        holder.dish_name.setText(orderModelList.get(position).getDish_name());
        holder.date.setText(orderModelList.get(position).getDate());
        holder.rating_txt.setText(orderModelList.get(position).getRating_txt());

        if(orderModelList.get(position).isDelivered()==true)
        {
            holder.Delivered_sign.setVisibility(View.VISIBLE);
            holder.delivered_msg.setVisibility(View.VISIBLE);
            holder.cancelled_sign.setVisibility(View.INVISIBLE);
            holder.cancel_msg.setVisibility(View.INVISIBLE);
         } else {
            holder.Delivered_sign.setVisibility(View.INVISIBLE);
            holder.delivered_msg.setVisibility(View.INVISIBLE);
            holder.cancelled_sign.setVisibility(View.VISIBLE);
            holder.cancel_msg.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return orderModelList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{

        private TextView restaurantName,address,price, delivered_msg, cancel_msg, dish_name, date, rating_txt;
        private ImageView Delivered_sign,cancelled_sign;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            restaurantName=itemView.findViewById(R.id.restaurantName);
            address=itemView.findViewById(R.id.address);
            price=itemView.findViewById(R.id.price);
            delivered_msg=itemView.findViewById(R.id.delivered_msg);
            cancel_msg=itemView.findViewById(R.id.cancel_msg);
            dish_name=itemView.findViewById(R.id.dish_name);
            date=itemView.findViewById(R.id.date);
            rating_txt=itemView.findViewById(R.id.rating_txt);
            Delivered_sign=itemView.findViewById(R.id.Delivered_sign);
            cancelled_sign=itemView.findViewById(R.id.cancelled_sign);


        }
    }
}
