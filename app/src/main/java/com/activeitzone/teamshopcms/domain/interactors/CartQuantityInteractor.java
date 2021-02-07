package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.CartQuantityUpdateResponse;

public interface CartQuantityInteractor {
    interface CallBack {

        void onCartQuantityUpdated(CartQuantityUpdateResponse cartQuantityUpdateResponse);

        void onCartQuantityUpdatedError();
    }
}
