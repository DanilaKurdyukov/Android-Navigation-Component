package com.example.viantecapp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.Time;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class ModelData implements Parcelable {
    private LocalDateTime time;
    private String whereFound;
    private String type;

    private String additionalInformation;

    public ModelData(LocalDateTime time, String whereFound, String type, String additionalInformation) {
        this.time = time;
        this.whereFound = whereFound;
        this.type = type;
        this.additionalInformation = additionalInformation;
    }

    protected ModelData(Parcel in) {
        whereFound = in.readString();
        type = in.readString();
        additionalInformation = in.readString();
    }

    public static final Creator<ModelData> CREATOR = new Creator<ModelData>() {
        @Override
        public ModelData createFromParcel(Parcel in) {
            return new ModelData(in);
        }

        @Override
        public ModelData[] newArray(int size) {
            return new ModelData[size];
        }
    };

    public LocalDateTime getTime() {
        return time;
    }

    public String getWhereFound() {
        return whereFound;
    }

    public String getType() {
        return type;
    }


    public String getAdditionalInformation() {
        return additionalInformation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(whereFound);
        dest.writeString(type);
        dest.writeString(additionalInformation);
    }
}
