package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.FlashDealResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlashDealApiInterface {
    @GET("products/flash-deal")
    Call<FlashDealResponse> getFlashDeal();
}