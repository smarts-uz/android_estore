package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.AddToCartResponse;

public interface AddToCartInteractor {
    interface CallBack {

        void onCartItemAdded(AddToCartResponse addToCartResponse);

        void onCartItemAddedError();
    }
}
