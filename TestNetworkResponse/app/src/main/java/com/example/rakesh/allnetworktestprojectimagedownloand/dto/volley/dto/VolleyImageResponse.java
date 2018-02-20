
package com.example.rakesh.allnetworktestprojectimagedownloand.dto.volley.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class VolleyImageResponse implements Parcelable {

    @SerializedName("name")
    public String name;

    @SerializedName("url")
    public ImageUrl url;

    @SerializedName("timestamp")
    public String timestamp;

    public String getName() {
        return name;
    }

    public ImageUrl getUrl() {
        return url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public VolleyImageResponse(Parcel in) {
        name = in.readString();
        timestamp = in.readString();
    }

    public static final Creator<VolleyImageResponse> CREATOR = new Creator<VolleyImageResponse>() {
        @Override
        public VolleyImageResponse createFromParcel(Parcel in) {
            return new VolleyImageResponse(in);
        }

        @Override
        public VolleyImageResponse[] newArray(int size) {
            return new VolleyImageResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(timestamp);
    }
}
