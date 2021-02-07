package com.activeitzone.teamshopcms.Presentation.ui.listeners;

import com.activeitzone.teamshopcms.Models.CartModel;

public interface CartItemListener {
    void onCartRemove(CartModel cartModel);
    void onQuantityUpdate(int quantity, CartModel cartModel);
}
