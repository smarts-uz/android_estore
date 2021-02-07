package com.activeitzone.teamshopcms.domain.interactors;

import com.activeitzone.teamshopcms.Network.response.CouponResponse;

public interface CouponInteractor {
    interface CallBack {

        void onCouponApplied(CouponResponse couponResponse);

        void onCouponAppliedError();
    }
}
