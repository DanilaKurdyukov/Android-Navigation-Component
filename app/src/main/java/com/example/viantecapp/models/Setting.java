package com.example.viantecapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Setting implements Parcelable {
    private String name;
    private boolean isTurnOn;
    private boolean isSoundOn;
    private boolean isNotify;

    public Setting(String name, boolean isTurnOn, boolean isSoundOn, boolean isNotify) {
        this.name = name;
        this.isTurnOn = isTurnOn;
        this.isSoundOn = isSoundOn;
        this.isNotify = isNotify;
    }

    protected Setting(Parcel in) {
        name = in.readString();
        isTurnOn = in.readByte() != 0;
        isSoundOn = in.readByte() != 0;
        isNotify = in.readByte() != 0;
    }

    public static final Creator<Setting> CREATOR = new Creator<Setting>() {
        @Override
        public Setting createFromParcel(Parcel in) {
            return new Setting(in);
        }

        @Override
        public Setting[] newArray(int size) {
            return new Setting[size];
        }
    };

    public String getName() {
        return name;
    }

    public boolean isTurnOn() {
        return isTurnOn;
    }

    public boolean isSoundOn() {
        return isSoundOn;
    }

    public boolean isNotify() {
        return isNotify;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeByte((byte) (isTurnOn ? 1 : 0));
        dest.writeByte((byte) (isSoundOn ? 1 : 0));
        dest.writeByte((byte) (isNotify ? 1 : 0));
    }
}
