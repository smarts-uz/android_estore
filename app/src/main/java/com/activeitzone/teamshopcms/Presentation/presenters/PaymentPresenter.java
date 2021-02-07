package com.activeitzone.teamshopcms.Presentation.presenters;

import com.activeitzone.teamshopcms.Network.response.CouponResponse;
import com.activeitzone.teamshopcms.Network.response.OrderResponse;
import com.activeitzone.teamshopcms.Network.response.StripeClientSecretResponse;
import com.activeitzone.teamshopcms.Presentation.ui.activities.PaymentView;
import com.activeitzone.teamshopcms.Presentation.ui.activities.StripePaymentView;
import com.activeitzone.teamshopcms.domain.executor.Executor;
import com.activeitzone.teamshopcms.domain.executor.MainThread;
import com.activeitzone.teamshopcms.domain.interactors.CODInteractor;
import com.activeitzone.teamshopcms.domain.interactors.CouponInteractor;
import com.activeitzone.teamshopcms.domain.interactors.OrderInteractor;
import com.activeitzone.teamshopcms.domain.interactors.PaypalInteractor;
import com.activeitzone.teamshopcms.domain.interactors.StripeInteractor;
import com.activeitzone.teamshopcms.domain.interactors.impl.CODInteractorImpl;
import com.activeitzone.teamshopcms.domain.interactors.impl.CouponInteractorImpl;
import com.activeitzone.teamshopcms.domain.interactors.impl.OrderInteractorImpl;
import com.activeitzone.teamshopcms.domain.interactors.impl.PaypalInteractorImpl;
import com.activeitzone.teamshopcms.domain.interactors.impl.StripeInteractorImpl;
import com.google.gson.JsonObject;

public class PaymentPresenter extends AbstractPresenter implements CouponInteractor.CallBack, PaypalInteractor.CallBack, StripeInteractor.CallBack, CODInteractor.CallBack, OrderInteractor.CallBack {
    private PaymentView paymentView;
    private StripePaymentView stripePaymentView;

    public PaymentPresenter(Executor executor, MainThread mainThread, PaymentView paymentView) {
        super(executor, mainThread);
        this.paymentView = paymentView;
    }

    public PaymentPresenter(Executor executor, MainThread mainThread, StripePaymentView stripePaymentView) {
        super(executor, mainThread);
        this.stripePaymentView = stripePaymentView;
    }

    public void applyCoupon(int user_id, String code, String token) {
        new CouponInteractorImpl(mExecutor, mMainThread, this, user_id, code, token).execute();
    }

    public void submitPaypalOrder(String token, JsonObject jsonObject) {
        new PaypalInteractorImpl(mExecutor, mMainThread, this, token, jsonObject).execute();
    }

    public void submitStripeRequest(String token, JsonObject jsonObject) {
        new StripeInteractorImpl(mExecutor, mMainThread, this, token, jsonObject).execute();
    }

    public void submitCODOrder(String token, JsonObject jsonObject) {
        new CODInteractorImpl(mExecutor, mMainThread, this, token, jsonObject).execute();
    }

    public void submitOrder(String token, JsonObject jsonObject) {
        new OrderInteractorImpl(mExecutor, mMainThread, this, token, jsonObject).execute();
    }

    @Override
    public void onCouponApplied(CouponResponse couponResponse) {
        if (paymentView != null){
            paymentView.onCouponApplied(couponResponse);
        }
    }

    @Override
    public void onCouponAppliedError() {

    }

    @Override
    public void onPayaplOrderSubmitted(OrderResponse orderResponse) {
        if (paymentView != null){
            paymentView.onOrderSubmitted(orderResponse);
        }
    }

    @Override
    public void onPayaplOrderSubmitError() {

    }

    @Override
    public void ononClientSecretReceived(StripeClientSecretResponse stripeClientSecretResponse) {
        if (stripePaymentView != null){
            stripePaymentView.onClientSecretReceived(stripeClientSecretResponse);
        }
    }

    @Override
    public void ononClientSecretReceiveError() {

    }

    @Override
    public void onCODOrderSubmitted(OrderResponse orderResponse) {
        if (paymentView != null){
            paymentView.onOrderSubmitted(orderResponse);
        }
    }

    @Override
    public void onCODOrderSubmitError() {

    }

    @Override
    public void onOrderSubmitted(OrderResponse orderResponse) {
        if (paymentView != null){
            paymentView.onOrderSubmitted(orderResponse);
        }
    }

    @Override
    public void onOrderSubmitError() {

    }
}
