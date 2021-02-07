package com.activeitzone.teamshopcms.domain.interactors.impl;

import android.util.Log;

import com.activeitzone.teamshopcms.Network.ApiClient;
import com.activeitzone.teamshopcms.Network.response.SliderImageResponse;
import com.activeitzone.teamshopcms.Network.services.SliderImageApiInterface;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.SliderInteractor;
import com.activeitzone.teamshopcms.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SliderInteractorImpl extends AbstractInteractor {

    private SliderInteractor.CallBack mCallback;
    private SliderImageApiInterface apiService;

    public SliderInteractorImpl(Executor threadExecutor, MainThread mainThread, SliderInteractor.CallBack callBack) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(SliderImageApiInterface.class);
        Call<SliderImageResponse> call = apiService.getSliderImages();

        call.enqueue(new Callback<SliderImageResponse>() {
            @Override
            public void onResponse(Call<SliderImageResponse> call, Response<SliderImageResponse> response) {
                try {
                    mCallback.onSliderDownloaded(response.body().getData());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<SliderImageResponse> call, Throwable t) {
                mCallback.onSliderDownloadError();
            }
        });

    }
}