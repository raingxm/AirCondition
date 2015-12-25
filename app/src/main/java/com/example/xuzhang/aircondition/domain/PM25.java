package com.example.xuzhang.aircondition.domain;


import com.google.gson.annotations.SerializedName;

public class PM25 {
    @SerializedName("quality")
    private String quality;

    @Override
    public String toString() {
        return "PM25{" +
                "quality='" + quality + '\'' +
                '}';
    }
}
