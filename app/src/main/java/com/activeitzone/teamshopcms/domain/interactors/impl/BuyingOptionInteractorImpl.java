package com.activeitzone.teamshopcms.domain.interactors.impl;

import android.util.Log;

import com.activeitzone.teamshopcms.Network.ApiClient;
import com.activeitzone.teamshopcms.Network.response.VariantResponse;
import com.activeitzone.teamshopcms.Network.services.VariantPriceApiInterface;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.BuyingOptionInteractor;
import com.activeitzone.teamshopcms.domain.interactors.base.AbstractInteractor;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuyingOptionInteractorImpl extends AbstractInteractor {
    private BuyingOptionInteractor.CallBack mCallback;
    private VariantPriceApiInterface apiService;
    private int id;
    private String color;
    private JsonArray choicesArray;

    public BuyingOptionInteractorImpl(Executor threadExecutor, MainThread mainThread, BuyingOptionInteractor.CallBack callBack, int id, String color, JsonArray choicesArray) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.id = id;
        this.color = color;
        this.choicesArray = choicesArray;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(VariantPriceApiInterface.class);
        Call<VariantResponse> call = apiService.getVariantPrice(id, color, choicesArray.toString());

        call.enqueue(new Callback<VariantResponse>() {
            @Override
            public void onResponse(Call<VariantResponse> call, Response<VariantResponse> response) {
                try {
                    //Log.d("Test", response.body().getVariant());
                    mCallback.onGetVariantPrice(response.body());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<VariantResponse> call, Throwable t) {
                //Log.d("Test", String.valueOf(call.isExecuted()));
                mCallback.onGetVariantPriceError();
            }
        });

    }
}
