package com.activeitzone.teamshopcms.domain.interactors.impl;

import android.util.Log;

import com.activeitzone.teamshopcms.Network.ApiClient;
import com.activeitzone.teamshopcms.Network.response.UserBidResponse;
import com.activeitzone.teamshopcms.Network.services.UserBidApiInterface;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.UserBidInteractor;
import com.activeitzone.teamshopcms.domain.interactors.base.AbstractInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserBidInteractorImpl extends AbstractInteractor {
    private UserBidInteractor.CallBack mCallback;
    private UserBidApiInterface apiService;
    private int user_id;
    private String token;

    public UserBidInteractorImpl(Executor threadExecutor, MainThread mainThread, UserBidInteractor.CallBack callBack, int id, String token) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
        this.user_id = id;
        this.token = "Bearer "+token;
    }

    @Override
    public void run() {
        apiService = ApiClient.getClient().create(UserBidApiInterface.class);
        Call<UserBidResponse> call = apiService.getUserBids(token,"auctions/bids/"+user_id);

        call.enqueue(new Callback<UserBidResponse>() {
            @Override
            public void onResponse(Call<UserBidResponse> call, Response<UserBidResponse> response) {
                try {
                    mCallback.onUserBidLodaded(response.body().getData());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<UserBidResponse> call, Throwable t) {
                mCallback.onUserBidError();
            }
        });

    }
}
