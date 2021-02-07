package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.ProductListingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ProductListingApiInterface {
    @GET
    Call<ProductListingResponse> getProducts(@Url String url);
}
