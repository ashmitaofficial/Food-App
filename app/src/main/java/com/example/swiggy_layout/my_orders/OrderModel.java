package com.example.swiggy_layout.my_orders;

public class OrderModel {

    private String restaurantName;
    private String address;
    private String price;
    private String date;
    private String rating_txt;
    private String dish_name;
    private String delivered_msg;
    private String cancel_msg;
    private boolean delivered;
    private boolean cancelled_sign;

    public OrderModel(String restaurantName, String address,String dish_name, String price, String date, String rating_txt, String delivered_msg, String cancel_msg, boolean delivered, boolean cancelled_sign) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.price = price;
        this.date = date;
        this.rating_txt = rating_txt;
        this.delivered_msg = delivered_msg;
        this.cancel_msg = cancel_msg;
        this.delivered = delivered;
        this.cancelled_sign = cancelled_sign;
        this.dish_name=dish_name;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRating_txt() {
        return rating_txt;
    }

    public void setRating_txt(String rating_txt) {
        this.rating_txt = rating_txt;
    }

    public String getDelivered_msg() {
        return delivered_msg;
    }

    public void setDelivered_msg(String delivered_msg) {
        this.delivered_msg = delivered_msg;
    }

    public String getCancel_msg() {
        return cancel_msg;
    }

    public void setCancel_msg(String cancel_msg) {
        this.cancel_msg = cancel_msg;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isCancelled_sign() {
        return cancelled_sign;
    }

    public void setCancelled_sign(boolean cancelled_sign) {
        this.cancelled_sign = cancelled_sign;
    }
}
