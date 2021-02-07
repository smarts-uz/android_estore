package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.AddToWishlistResponse;

public interface AddToWishlistInteractor {
    interface CallBack {

        void onWishlistItemAdded(AddToWishlistResponse addToWishlistResponse);

        void onWishlistItemAddedError();
    }
}
