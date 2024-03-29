package com.activeitzone.teamshopcms.domain.interactors.impl;

import android.util.Log;

import com.activeitzone.teamshopcms.Network.ApiClient;
import com.activeitzone.teamshopcms.Network.response.SubSubCategoryResponse;
import com.activeitzone.teamshopcms.Network.services.SubSubCategoryApiInterface;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.SubSubCategoryInteractor;
import com.activeitzone.teamshopcms.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubSubCategoryInteractorImpl extends AbstractInteractor {
    private SubSubCategoryInteractor.CallBack mCallback;
    private SubSubCategoryApiInterface apiService;
    private String url;

    public SubSubCategoryInteractorImpl(Executor threadExecutor, MainThread mainThread, SubSubCategoryInteractor.CallBack callBack, String url) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.url = url;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(SubSubCategoryApiInterface.class);
        Call<SubSubCategoryResponse> call = apiService.getSubSubcategories(url);

        call.enqueue(new Callback<SubSubCategoryResponse>() {
            @Override
            public void onResponse(Call<SubSubCategoryResponse> call, Response<SubSubCategoryResponse> response) {
                try {
                    mCallback.onSubSubCategoriesDownloaded(response.body().getData());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<SubSubCategoryResponse> call, Throwable t) {
                mCallback.onSubSubCategoriesDownloadError();
            }
        });

    }
}
