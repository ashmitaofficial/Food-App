package com.example.swiggy_layout.food;

public class FoodModel {
    private String dish_name ;
    private String price;
    private String rating;
    private String description;
    private String post;
    private boolean bestSeller;
    private boolean veg;


    public FoodModel(String dish_name, String price, String rating, String description, String post,boolean bestSeller, boolean veg)
    {
        this.post=post;
        this.description=description;
        this.dish_name=dish_name;
        this.price=price;
        this.rating=rating;
        this.bestSeller=bestSeller;
        this.veg=veg;


    }

    public boolean isBestsellerTxt() {
        return bestSeller;
    }

    public void setBestsellerTxt(boolean bestsellerTxt) {
        this.bestSeller = bestsellerTxt;
    }

    public boolean isVeg_sign() {
        return veg;
    }

    public void setVeg_sign(boolean veg_sign) {
        this.veg = veg;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
