package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.SubCategory;

import java.util.List;

public interface SubSubCategoryInteractor {
    interface CallBack {

        void onSubSubCategoriesDownloaded(List<SubCategory> subCategories);

        void onSubSubCategoriesDownloadError();
    }
}
