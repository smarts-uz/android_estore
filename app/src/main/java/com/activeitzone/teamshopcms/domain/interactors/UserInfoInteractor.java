package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.User;

public interface UserInfoInteractor {
    interface CallBack {

        void onUserInfoLodaded(User user);

        void onUserInfoError();
    }
}
