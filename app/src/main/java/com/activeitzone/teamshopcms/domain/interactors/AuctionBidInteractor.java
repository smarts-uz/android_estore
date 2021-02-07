package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.AuctionBidResponse;

public interface AuctionBidInteractor {
    interface CallBack {

        void onBidSubmitted(AuctionBidResponse auctionBidResponse);

        void onBidSubmittedError();
    }
}
