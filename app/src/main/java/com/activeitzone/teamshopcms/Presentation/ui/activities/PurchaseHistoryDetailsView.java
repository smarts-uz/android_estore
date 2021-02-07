package com.activeitzone.teamshopcms.Presentation.ui.activities;

import com.activeitzone.teamshopcms.Models.OrderDetail;

import java.util.List;

public interface PurchaseHistoryDetailsView {
    void onOrderDetailsLoaded(List<OrderDetail> orderDetailList);
}
