package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.VariantResponse;

public interface BuyingOptionInteractor {
    interface CallBack {

        void onGetVariantPrice(VariantResponse variantResponse);

        void onGetVariantPriceError();
    }
}
