package com.activeitzone.teamshopcms.Presentation.presenters;

import com.activeitzone.teamshopcms.Network.response.ProductListingResponse;
import com.activeitzone.teamshopcms.Presentation.ui.activities.ProductListingView;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.ProductListingInteractor;
import com.activeitzone.teamshopcms.domain.interactors.impl.ProductListingInteractorImpl;

public class ProductListingPresenter extends AbstractPresenter implements ProductListingInteractor.CallBack {
    private ProductListingView productListingView;

    public ProductListingPresenter(Executor executor, MainThread mainThread, ProductListingView productListingView) {
        super(executor, mainThread);
        this.productListingView = productListingView;
    }

    public void getProducts(String url) {
        new ProductListingInteractorImpl(mExecutor, mMainThread, this, url).execute();
    }


    @Override
    public void onProductDownloaded(ProductListingResponse productListingResponse) {
        if (productListingView != null){
            productListingView.setProducts(productListingResponse);
        }
    }

    @Override
    public void onProductDownloadError() {

    }
}
