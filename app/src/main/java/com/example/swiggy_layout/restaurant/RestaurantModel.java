package com.example.swiggy_layout.restaurant;

public class RestaurantModel {

    private String rid;

    private String pic;
    private String rname;

    private String rating;

    private String desc;

    private boolean freeDelivery;

    public RestaurantModel(String rid, String pic, String rname, String rating, String desc, boolean freeDelivery) {
        this.rid=rid;
        this.pic = pic;
        this.rname = rname;
        this.rating = rating;
        this.desc = desc;
        this.freeDelivery = freeDelivery;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFreeDelivery() {
        return freeDelivery;
    }

    public void setFreeDelivery(boolean freeDelivery) {
        this.freeDelivery = freeDelivery;
    }
}
