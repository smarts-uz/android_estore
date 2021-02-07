package com.activeitzone.teamshopcms.Presentation.presenters;

import com.activeitzone.teamshopcms.Network.response.ProductSearchResponse;
import com.activeitzone.teamshopcms.Presentation.ui.fragments.ProductSearchView;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.ProductSearchInteractor;
import com.activeitzone.teamshopcms.domain.interactors.impl.ProductSearchInteractorImpl;

public class ProductSearchPresenter extends AbstractPresenter implements ProductSearchInteractor.CallBack {
    private ProductSearchView ProductSearchView;

    public ProductSearchPresenter(Executor executor, MainThread mainThread, ProductSearchView ProductSearchView) {
        super(executor, mainThread);
        this.ProductSearchView = ProductSearchView;
    }

    public void getSearchedProducts(String url) {
        new ProductSearchInteractorImpl(mExecutor, mMainThread, this, url).execute();
    }


    @Override
    public void onProductSearched(ProductSearchResponse productSearchResponse) {
        if (ProductSearchView != null){
            ProductSearchView.setSearchedProduct(productSearchResponse);
        }
    }

    @Override
    public void onProductSearchedError() {

    }
}
