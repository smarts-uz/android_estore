package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllCategoryApiInterface {
    @GET("categories")
    Call<CategoryResponse> getAllCategories();
}
