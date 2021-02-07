package com.activeitzone.teamshopcms.Presentation.ui.activities;

import com.activeitzone.teamshopcms.Models.User;
import com.activeitzone.teamshopcms.Network.response.ProfileInfoUpdateResponse;
import com.activeitzone.teamshopcms.Network.response.ShippingInfoUpdateResponse;

public interface AccountInfoView {
    void onProfileInfoUpdated(ProfileInfoUpdateResponse profileInfoUpdateResponse);
    void onShippingInfoUpdated(ShippingInfoUpdateResponse shippingInfoUpdateResponse);
    void setUpdatedUserInfo(User user);
}
