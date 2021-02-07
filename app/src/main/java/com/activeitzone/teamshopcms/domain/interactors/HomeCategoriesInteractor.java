package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.Category;

import java.util.List;

public interface HomeCategoriesInteractor {
    interface CallBack {

        void onHomeCategoriesDownloaded(List<Category> categories);

        void onHomeCategoriesDownloadError();
    }
}
