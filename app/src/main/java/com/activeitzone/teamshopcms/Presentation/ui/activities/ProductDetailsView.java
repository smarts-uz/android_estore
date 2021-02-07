package com.activeitzone.teamshopcms.Presentation.ui.activities;

import com.activeitzone.teamshopcms.Models.Product;
import com.activeitzone.teamshopcms.Models.ProductDetails;
import com.activeitzone.teamshopcms.Network.response.AddToCartResponse;
import com.activeitzone.teamshopcms.Network.response.AddToWishlistResponse;
import com.activeitzone.teamshopcms.Network.response.CheckWishlistResponse;
import com.activeitzone.teamshopcms.Network.response.RemoveWishlistResponse;

import java.util.List;

public interface ProductDetailsView {
    void setProductDetails(ProductDetails productDetails);
    void setRelatedProducts(List<Product> relatedProducts);
    void setTopSellingProducts(List<Product> topSellingProducts);
    void setAddToCartMessage(AddToCartResponse addToCartResponse);
    void setAddToWishlistMessage(AddToWishlistResponse addToWishlistMessage);
    void onCheckWishlist(CheckWishlistResponse checkWishlistResponse);
    void onRemoveFromWishlist(RemoveWishlistResponse removeWishlistResponse);
}
