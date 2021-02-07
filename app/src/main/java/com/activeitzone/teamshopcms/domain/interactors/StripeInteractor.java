package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.StripeClientSecretResponse;

public interface StripeInteractor {
    interface CallBack {

        void ononClientSecretReceived(StripeClientSecretResponse stripeClientSecretResponse);

        void ononClientSecretReceiveError();
    }
}
