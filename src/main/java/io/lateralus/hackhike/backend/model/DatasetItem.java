package io.lateralus.hackhike.backend.model;

import com.google.api.client.util.Key;

public class DatasetItem{

    @Key
    private String time;
    @Key
    private int value;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
