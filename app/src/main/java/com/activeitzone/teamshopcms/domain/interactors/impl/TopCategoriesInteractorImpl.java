package com.activeitzone.teamshopcms.domain.interactors.impl;

import android.util.Log;

import com.activeitzone.teamshopcms.Network.ApiClient;
import com.activeitzone.teamshopcms.Network.response.CategoryResponse;
import com.activeitzone.teamshopcms.Network.services.TopCategoryApiInterface;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.TopCategoryInteractor;
import com.activeitzone.teamshopcms.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopCategoriesInteractorImpl extends AbstractInteractor {
    private TopCategoryInteractor.CallBack mCallback;
    private TopCategoryApiInterface apiService;

    public TopCategoriesInteractorImpl(Executor threadExecutor, MainThread mainThread, TopCategoryInteractor.CallBack callBack) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(TopCategoryApiInterface.class);
        Call<CategoryResponse> call = apiService.getTopCategories();

        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                try {
                    mCallback.onTopCategoriesDownloaded(response.body().getData());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                mCallback.onTopCategoriesDownloadError();
            }
        });

    }
}
