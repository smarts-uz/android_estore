package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.AuthResponse;

public interface LoginInteractor {
    interface CallBack {

        void onValidLogin(AuthResponse authResponse);

        void onLoginError();
    }
}
