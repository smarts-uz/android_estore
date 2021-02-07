package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.Product;

import java.util.List;

public interface FeaturedProductInteractor {
    interface CallBack {

        void onFeaturedProductDownloaded(List<Product> products);

        void onFeaturedProductDownloadError();
    }
}
