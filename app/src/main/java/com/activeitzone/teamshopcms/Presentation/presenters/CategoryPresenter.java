package com.activeitzone.teamshopcms.Presentation.presenters;

import com.activeitzone.teamshopcms.Models.Category;
import com.activeitzone.teamshopcms.Presentation.ui.fragments.CategoryView;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.AllCategoryInteractor;
import com.activeitzone.teamshopcms.domain.interactors.impl.AllCategoriesInteractorImpl;

import java.util.List;

public class CategoryPresenter extends AbstractPresenter implements AllCategoryInteractor.CallBack {

    private CategoryView categoryView;

    public CategoryPresenter(Executor executor, MainThread mainThread, CategoryView categoryView) {
        super(executor, mainThread);
        this.categoryView = categoryView;
    }

    public void getAllCategories() {
        new AllCategoriesInteractorImpl(mExecutor, mMainThread, this).execute();
    }

    @Override
    public void onAllCategoriesDownloaded(List<Category> categories) {
        if (categoryView != null) {
            categoryView.setAllCategories(categories);
        }
    }

    @Override
    public void onAllCategoriesDownloadError() {

    }
}
