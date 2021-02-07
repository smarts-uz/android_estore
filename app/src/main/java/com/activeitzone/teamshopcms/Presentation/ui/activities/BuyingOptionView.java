package com.activeitzone.teamshopcms.Presentation.ui.activities;

import com.activeitzone.teamshopcms.Network.response.AddToCartResponse;
import com.activeitzone.teamshopcms.Network.response.VariantResponse;

public interface BuyingOptionView {
    void setVariantprice(VariantResponse variantResponse);
    void setAddToCartMessage(AddToCartResponse addToCartResponse);
}
