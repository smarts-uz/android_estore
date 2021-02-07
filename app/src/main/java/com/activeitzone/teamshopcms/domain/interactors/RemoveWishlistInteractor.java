package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.RemoveWishlistResponse;

public interface RemoveWishlistInteractor {
    interface CallBack {

        void onWishlistItemRemoved(RemoveWishlistResponse removeWishlistResponse);

        void onWishlistItemRemovedError();
    }
}
