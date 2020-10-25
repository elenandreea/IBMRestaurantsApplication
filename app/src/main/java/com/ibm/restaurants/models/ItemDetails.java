package com.ibm.restaurants.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDetails {

    @SerializedName("name")
    private String title;

    @SerializedName("description")
    private String subTitle;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("photos")
    private List<String> photos;

    public ItemDetails(String title, String subTitle, double latitude, double longitude, List<String> photos) {
        this.title = title;
        this.subTitle = subTitle;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photos = photos;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
