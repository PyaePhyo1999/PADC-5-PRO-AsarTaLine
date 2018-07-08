package com.example.acer.asartaline.network;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Acer on 7/7/2018.
 */

public interface FoodListApi {
    @FormUrlEncoded
    @POST("v1/GetWarDee.php")
    Observable<GetFoodListResponse> loadFoodList(
            @Field("access_token") String accessToken);

}
