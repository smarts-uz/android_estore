package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BestSellingApiInterface {
    @GET("products/best-seller")
    Call<ProductResponse> getBestSellingPrdocuts();
}
