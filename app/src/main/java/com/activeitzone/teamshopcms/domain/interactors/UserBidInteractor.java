package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.UserBid;

import java.util.List;

public interface UserBidInteractor {
    interface CallBack {

        void onUserBidLodaded(List<UserBid> userBids);

        void onUserBidError();
    }
}
