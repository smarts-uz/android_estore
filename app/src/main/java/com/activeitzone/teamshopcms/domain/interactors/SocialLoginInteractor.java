package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.AuthResponse;

public interface SocialLoginInteractor {
    interface CallBack {

        void onValidLogin(AuthResponse authResponse);

        void onLoginError();
    }
}
