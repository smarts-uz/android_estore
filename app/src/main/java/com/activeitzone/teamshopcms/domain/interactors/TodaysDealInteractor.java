package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.Product;

import java.util.List;

public interface TodaysDealInteractor {
    interface CallBack {

        void onTodaysDealProductDownloaded(List<Product> products);

        void onTodaysDealProductDownloadError();
    }
}
