package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.AuctionResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AuctionProductApiInterface {
    @GET("auctions")
    Call<AuctionResponse> getAuctionProducts();
}
