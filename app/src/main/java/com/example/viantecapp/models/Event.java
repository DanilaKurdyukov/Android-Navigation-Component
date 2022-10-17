package com.example.viantecapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {

    private String eventName;
    private int nowNew;
    private int nowAll;
    private int perDayNew;
    private int perDayAll;
    private int perWeekNew;
    private int perWeekAll;

    public Event(String eventName, int nowNew, int nowAll, int perDayNew, int perDayAll, int perWeekNew, int perWeekAll) {
        this.eventName = eventName;
        this.nowNew = nowNew;
        this.nowAll = nowAll;
        this.perDayNew = perDayNew;
        this.perDayAll = perDayAll;
        this.perWeekNew = perWeekNew;
        this.perWeekAll = perWeekAll;
    }

    protected Event(Parcel in) {
        eventName = in.readString();
        nowNew = in.readInt();
        nowAll = in.readInt();
        perDayNew = in.readInt();
        perDayAll = in.readInt();
        perWeekNew = in.readInt();
        perWeekAll = in.readInt();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getEventName() {
        return eventName;
    }

    public int getNowNew() {
        return nowNew;
    }

    public int getNowAll() {
        return nowAll;
    }

    public int getPerDayNew() {
        return perDayNew;
    }

    public int getPerDayAll() {
        return perDayAll;
    }

    public int getPerWeekNew() {
        return perWeekNew;
    }

    public int getPerWeekAll() {
        return perWeekAll;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(eventName);
        dest.writeInt(nowNew);
        dest.writeInt(nowAll);
        dest.writeInt(perDayNew);
        dest.writeInt(perDayAll);
        dest.writeInt(perWeekNew);
        dest.writeInt(perWeekAll);
    }
}
