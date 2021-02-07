package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.WishlistResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface WishlistApiInterface {
    @GET
    Call<WishlistResponse> getWishlistItems(@Header("Authorization") String authHeader, @Url String url);
}
