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

    public Item(Parcel in) {
        icon = in.readString();
        title = in.readString();
        subTitle = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        imageURLs = in.createTypedArrayList(ItemDetail.CREATOR);
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

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(icon);
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeTypedList(imageURLs);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }
}
