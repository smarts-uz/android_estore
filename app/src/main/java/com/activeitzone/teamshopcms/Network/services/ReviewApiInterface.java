package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.ReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ReviewApiInterface {
    @GET
    Call<ReviewResponse> getReviews(@Url String url);
}
