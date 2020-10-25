package com.ibm.restaurants.models;

import android.os.Parcel;
import android.os.Parcelable;


public class ItemDetail implements Parcelable {

    private String imagePath;

    public ItemDetail(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imagePath);
    }

    protected ItemDetail(Parcel in) {
        this.imagePath = in.readString();
    }

    public static final Creator<ItemDetail> CREATOR = new Creator<ItemDetail>() {
        @Override
        public ItemDetail createFromParcel(Parcel source) {
            return new ItemDetail(source);
        }

        @Override
        public ItemDetail[] newArray(int size) {
            return new ItemDetail[size];
        }
    };

}
