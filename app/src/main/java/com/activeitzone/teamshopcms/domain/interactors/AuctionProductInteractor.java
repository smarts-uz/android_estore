package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.AuctionProduct;

import java.util.List;

public interface AuctionProductInteractor {
    interface CallBack {

        void onAuctionProductDownloaded(List<AuctionProduct> auctionProducts);

        void onAuctionProductDownloadError();
    }
}
