package com.activeitzone.teamshopcms.Network.services;

import com.activeitzone.teamshopcms.Network.response.AppSettingsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppSettingsApiInterface {
    @GET("settings")
    Call<AppSettingsResponse> getAppSettings();
}
