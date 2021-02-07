package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.Category;

import java.util.List;

public interface AllCategoryInteractor {
    interface CallBack {

        void onAllCategoriesDownloaded(List<Category> categories);

        void onAllCategoriesDownloadError();
    }
}
