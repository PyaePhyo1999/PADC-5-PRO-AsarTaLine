package com.example.acer.asartaline.network;

import com.example.acer.asartaline.data.vos.FoodListVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Acer on 7/7/2018.
 */

public class GetFoodListResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlWarDee")
    private  List<FoodListVO> foodList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<FoodListVO> getFoodList() {
        return foodList;
    }
}
