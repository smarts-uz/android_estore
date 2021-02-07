package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.BannerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BannerApiInterface {
    @GET("banners")
    Call<BannerResponse> getBanners();
}
