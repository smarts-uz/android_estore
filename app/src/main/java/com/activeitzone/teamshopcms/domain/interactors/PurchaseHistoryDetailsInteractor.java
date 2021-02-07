package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.OrderDetail;

import java.util.List;

public interface PurchaseHistoryDetailsInteractor {
    interface CallBack {

        void onOrderDetailsLoaded(List<OrderDetail> orderDetails);

        void onOrderDetailsLoadError();
    }
}
