package com.activeitzone.teamshopcms.Presentation.ui.activities;

import com.activeitzone.teamshopcms.Network.response.StripeClientSecretResponse;

public interface StripePaymentView {
    void onClientSecretReceived(StripeClientSecretResponse stripeClientSecretResponse);
}
