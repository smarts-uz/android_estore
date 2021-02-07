package com.activeitzone.teamshopcms.Presentation.presenters;

import com.activeitzone.teamshopcms.Models.SubCategory;
import com.activeitzone.teamshopcms.Presentation.ui.activities.SubSubCategoryView;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.SubSubCategoryInteractor;
import com.activeitzone.teamshopcms.domain.interactors.impl.SubSubCategoryInteractorImpl;

import java.util.List;

public class SubSubCategoryPresenter extends AbstractPresenter implements SubSubCategoryInteractor.CallBack {
    private SubSubCategoryView subSubCategoryView;

    public SubSubCategoryPresenter(Executor executor, MainThread mainThread, SubSubCategoryView subSubCategoryView) {
        super(executor, mainThread);
        this.subSubCategoryView =subSubCategoryView;
    }

    public void getSubSubCategories(String url){
        new SubSubCategoryInteractorImpl(mExecutor, mMainThread, this, url).execute();
    }

    @Override
    public void onSubSubCategoriesDownloaded(List<SubCategory> subCategories) {
        if (subSubCategoryView != null){
            subSubCategoryView.setSubSubCategories(subCategories);
        }
    }

    @Override
    public void onSubSubCategoriesDownloadError() {

    }
}
