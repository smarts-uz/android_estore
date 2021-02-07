package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.SliderImageResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SliderImageApiInterface {
    @GET("sliders")
    Call<SliderImageResponse> getSliderImages();
}
