package com.ibm.restaurants.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ItemDetail implements Parcelable {
    @SerializedName("imagePath")
    private String imagePath;

    public ItemDetail(String imagePath) {
        this.imagePath = imagePath;
    }

    private ItemDetail(Parcel in) {
        imagePath = in.readString();
    }

    public static final Creator<ItemDetail> CREATOR = new Creator<ItemDetail>() {
        @Override
        public ItemDetail createFromParcel(Parcel in) {
            return new ItemDetail(in);
        }

        @Override
        public ItemDetail[] newArray(int size) {
            return new ItemDetail[size];
        }
    };

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagePath);
    }
}
