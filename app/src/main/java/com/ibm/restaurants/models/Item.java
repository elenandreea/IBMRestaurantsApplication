package com.ibm.restaurants.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item implements Parcelable {
    @SerializedName("imagePath")
    private String icon;

    @SerializedName("name")
    private String title;

    @SerializedName("description")
    private String subTitle;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("photos")
    private List<ItemDetail> imageURLs;


    public Item(String icon, String title, String subTitle, double latitude, double longitude, List<ItemDetail> imageURLs) {
        this.icon = icon;
        this.title = title;
        this.subTitle = subTitle;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageURLs = imageURLs;
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

    public void setImageURLs(List<ItemDetail> imageURLs) {
        this.imageURLs = imageURLs;
    }

    public List<ItemDetail> getImageURLs() {
        return imageURLs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.icon);
        dest.writeString(this.title);
        dest.writeString(this.subTitle);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeTypedList(this.imageURLs);
    }

    protected Item(Parcel in) {
        this.icon = in.readString();
        this.title = in.readString();
        this.subTitle = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.imageURLs = in.createTypedArrayList(ItemDetail.CREATOR);
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
