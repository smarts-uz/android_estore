package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TopCategoryApiInterface {
    @GET("categories/featured")
    Call<CategoryResponse> getTopCategories();
}
