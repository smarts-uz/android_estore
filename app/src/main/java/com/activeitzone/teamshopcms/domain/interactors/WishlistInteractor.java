package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.WishlistModel;

import java.util.List;

public interface WishlistInteractor {
    interface CallBack {

        void onWishlistLodaded(List<WishlistModel> wishlistModels);

        void onWishlistError();
    }
}
