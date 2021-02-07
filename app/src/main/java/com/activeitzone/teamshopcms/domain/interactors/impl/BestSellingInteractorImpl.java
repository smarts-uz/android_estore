package com.activeitzone.teamshopcms.domain.interactors.impl;

import android.util.Log;

import com.activeitzone.teamshopcms.Network.ApiClient;
import com.activeitzone.teamshopcms.Network.response.ProductResponse;
import com.activeitzone.teamshopcms.Network.services.BestSellingApiInterface;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.BestSellingInteractor;
import com.activeitzone.teamshopcms.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BestSellingInteractorImpl extends AbstractInteractor {
    private BestSellingInteractor.CallBack mCallback;
    private BestSellingApiInterface apiService;

    public BestSellingInteractorImpl(Executor threadExecutor, MainThread mainThread, BestSellingInteractor.CallBack callBack) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(BestSellingApiInterface.class);
        Call<ProductResponse> call = apiService.getBestSellingPrdocuts();

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                try {
                    mCallback.onBestSellingProductDownloaded(response.body().getData());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                mCallback.onBestSellingProductDownloadError();
            }
        });

    }
}
