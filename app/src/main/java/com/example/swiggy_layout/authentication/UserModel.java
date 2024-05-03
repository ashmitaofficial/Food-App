package com.example.swiggy_layout.authentication;

public class UserModel {
    private String name;
    private String email;
    private String password;
    private String mobile;
    private String dob;
    private String profile_pic;
    private String gender;


    public UserModel(String name, String email, String password, String mobile, String dob, String profile_pic,String gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.dob = dob;
        this.profile_pic = profile_pic;
        this.gender=gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }
}
