package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.Shop;

public interface ShopInteractor {
    interface CallBack {

        void onShopLoaded(Shop shop);

        void onShopLoadError();
    }
}
