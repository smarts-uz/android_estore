package com.activeitzone.teamshopcms.Presentation.ui.activities;

import com.activeitzone.teamshopcms.Models.Review;

import java.util.List;

public interface ProductReviewView {
    void onReviewsLoaded(List<Review> reviews);
}
