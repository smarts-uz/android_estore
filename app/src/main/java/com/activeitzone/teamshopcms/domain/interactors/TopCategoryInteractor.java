package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.Category;

import java.util.List;

public interface TopCategoryInteractor {
    interface CallBack {

        void onTopCategoriesDownloaded(List<Category> categories);

        void onTopCategoriesDownloadError();
    }
}
