package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.FlashDeal;

public interface FlashDealInteractor {
    interface CallBack {

        void onFlashDealProductDownloaded(FlashDeal flashDeal);

        void onFlashDealProductDownloadError();
    }
}