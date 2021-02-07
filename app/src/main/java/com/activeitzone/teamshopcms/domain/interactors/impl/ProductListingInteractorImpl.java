package com.activeitzone.teamshopcms.domain.interactors.impl;

import android.util.Log;

import com.activeitzone.teamshopcms.Network.ApiClient;
import com.activeitzone.teamshopcms.Network.response.ProductListingResponse;
import com.activeitzone.teamshopcms.Network.services.ProductListingApiInterface;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.ProductListingInteractor;
import com.activeitzone.teamshopcms.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListingInteractorImpl extends AbstractInteractor {
    private ProductListingInteractor.CallBack mCallback;
    private ProductListingApiInterface apiService;
    private String url;

    public ProductListingInteractorImpl(Executor threadExecutor, MainThread mainThread, ProductListingInteractor.CallBack callBack, String url) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.url = url;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(ProductListingApiInterface.class);
        Call<ProductListingResponse> call = apiService.getProducts(url);

        call.enqueue(new Callback<ProductListingResponse>() {
            @Override
            public void onResponse(Call<ProductListingResponse> call, Response<ProductListingResponse> response) {
                try {
                    mCallback.onProductDownloaded(response.body());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ProductListingResponse> call, Throwable t) {
                mCallback.onProductDownloadError();
            }
        });

    }
}
