package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.ShippingInfoUpdateResponse;

public interface ShippingInfoUpdateInteractor {
    interface CallBack {

        void onShippingInfoUpdated(ShippingInfoUpdateResponse shippingInfoUpdateResponse);

        void onShippingInfoUpdatedError();
    }
}
