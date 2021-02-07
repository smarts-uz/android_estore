package com.activeitzone.teamshopcms.Presentation.ui.fragments;

import com.activeitzone.teamshopcms.Models.AuctionProduct;
import com.activeitzone.teamshopcms.Models.Banner;
import com.activeitzone.teamshopcms.Models.Brand;
import com.activeitzone.teamshopcms.Models.Category;
import com.activeitzone.teamshopcms.Models.FlashDeal;
import com.activeitzone.teamshopcms.Models.Product;
import com.activeitzone.teamshopcms.Models.SliderImage;
import com.activeitzone.teamshopcms.Network.response.AppSettingsResponse;
import com.activeitzone.teamshopcms.Network.response.AuctionBidResponse;

import java.util.List;

public interface HomeView {
    void onAppSettingsLoaded(AppSettingsResponse appSettingsResponse);

    void setSliderImages(List<SliderImage> sliderImages);

    void setHomeCategories(List<Category> categories);

    void setTodaysDeal(List<Product> products);

    void setFlashDeal(FlashDeal flashDeal);

    void setBanners(List<Banner> banners);

    void setBestSelling(List<Product> products);

    void setFeaturedProducts(List<Product> products);

    void setTopCategories(List<Category> categories);

    void setPopularBrands(List<Brand> brands);

    void setAuctionProducts(List<AuctionProduct> auctionProducts);

    void onAuctionBidSubmitted(AuctionBidResponse auctionBidResponse);
}