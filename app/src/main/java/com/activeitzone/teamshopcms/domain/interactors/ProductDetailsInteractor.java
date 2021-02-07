package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.ProductDetails;

public interface ProductDetailsInteractor {
    interface CallBack {

        void onProductDetailsDownloaded(ProductDetails productDetails);

        void onProductDetailsDownloadError();
    }
}
