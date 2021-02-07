package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.ProfileInfoUpdateResponse;

public interface ProfileInfoUpdateInteractor {
    interface CallBack {

        void onProfileInfoUpdated(ProfileInfoUpdateResponse profileInfoUpdateResponse);

        void onProfileInfoUpdatedError();
    }
}
