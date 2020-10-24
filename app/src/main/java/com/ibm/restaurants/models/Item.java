package com.ibm.restaurants.models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item {
    @SerializedName("imagePath")
    private String icon;

    @SerializedName("name")
    private String title;

    @SerializedName("description")
    private String subTitle;
//    private ArrayList<String> imageURLs;

    public Item(String icon, String title, String subTitle){ //, ArrayList<String> imageURLs) {
        this.icon = icon;
        this.title = title;
        this.subTitle = subTitle;
        //this.imageURLs = imageURLs;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

//    public ArrayList<String> getImageURLs() {
//        return imageURLs;
//    }
//
//    public void setImageURLs(ArrayList<String> imageURLs) {
//        this.imageURLs = imageURLs;
//    }
}
