package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.OrderResponse;

public interface CODInteractor {
    interface CallBack {

        void onCODOrderSubmitted(OrderResponse orderResponse);

        void onCODOrderSubmitError();
    }
}
