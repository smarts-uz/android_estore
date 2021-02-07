package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.BrandResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrandApiInterface {
    @GET("brands")
    Call<BrandResponse> getBrands();
}
