package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.CheckWishlistResponse;

public interface CheckWishlistInteractor {
    interface CallBack {

        void onWishlistChecked(CheckWishlistResponse checkWishlistResponse);

        void onWishlistCheckedError();
    }
}
