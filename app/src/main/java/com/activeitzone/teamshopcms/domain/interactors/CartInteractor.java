package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.CartModel;

import java.util.List;

public interface CartInteractor {
    interface CallBack {

        void onCartLodaded(List<CartModel> cartModel);

        void onCartError();
    }
}
