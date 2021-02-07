package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.ShippingInfoUpdateResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ShippingInfoApiInterface {
    @POST("user/shipping/update")
    Call<ShippingInfoUpdateResponse> updateShippingInfo(@Header("Authorization") String authHeader, @Body JsonObject jsonObject);
}
