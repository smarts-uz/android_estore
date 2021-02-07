package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Models.SliderImage;

import java.util.List;

public interface SliderInteractor {

    interface CallBack {

        void onSliderDownloaded(List<SliderImage> sliderImages);

        void onSliderDownloadError();
    }
}
