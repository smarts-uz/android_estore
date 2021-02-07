package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.RemoveCartResponse;

public interface RemoveCartInteractor {
    interface CallBack {

        void onCartItemRemoved(RemoveCartResponse removeCartResponse);

        void onCartItemRemovedError();
    }
}
