package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.PurchaseHistory;

import java.util.List;

public interface PurchaseHistoryInteractor {
    interface CallBack {

        void onPurchaseHistoryLodaded(List<PurchaseHistory> purchaseHistories);

        void onPurchaseHistoryLodadedError();
    }
}
