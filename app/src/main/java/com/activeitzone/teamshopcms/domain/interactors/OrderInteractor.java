package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.OrderResponse;

public interface OrderInteractor {
    interface CallBack {

        void onOrderSubmitted(OrderResponse orderResponse);

        void onOrderSubmitError();
    }
}
