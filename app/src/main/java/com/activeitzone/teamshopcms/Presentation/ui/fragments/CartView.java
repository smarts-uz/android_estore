package com.activeitzone.teamshopcms.Presentation.ui.fragments;

import com.activeitzone.teamshopcms.Models.CartModel;
import com.activeitzone.teamshopcms.Network.response.CartQuantityUpdateResponse;
import com.activeitzone.teamshopcms.Network.response.RemoveCartResponse;

import java.util.List;

public interface CartView {
    void setCartItems(List<CartModel> cartItems);
    void showRemoveCartMessage(RemoveCartResponse removeCartResponse);
    void showCartQuantityUpdateMessage(CartQuantityUpdateResponse cartQuantityUpdateResponse);
}
