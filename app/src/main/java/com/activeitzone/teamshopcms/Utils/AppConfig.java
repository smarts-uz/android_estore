package com.activeitzone.teamshopcms.Utils;

import android.content.Context;

import com.activeitzone.teamshopcms.Models.AppSettings;

import java.text.DecimalFormat;

public class AppConfig {
    public static AppSettings appSettings;

//    public static String BASE_URL = "http://demo.activeitzone.com/ecommerce/api/v1/";
    public static String BASE_URL = "http://ashop.asrorztg.beget.tech/api/v1/";
//    public static String BASE_URL = "http://178.218.201.180/api/v1/";
//    public static String ASSET_URL = "http://demo.activeitzone.com/ecommerce/public/";
//    public static String ASSET_URL = "http://178.218.201.180/";
    public static String ASSET_URL = "http://ashop.asrorztg.beget.tech/";

//    public static String BASE_URL = "http://192.168.1.114/shop/api/v1/";
//    public static String ASSET_URL = "http://192.168.1.114/shop/public/";

    public static String STRIPE_KEY = "pk_test_c6VvBEbwHFdulFZ62q1IQrar";
    public static String BRAINTREE_KEY = "sandbox_pghddbzc_h44cx45wt7g27wmc";

    public static String convertPrice(Context context, Double price) {
        appSettings = new UserPrefs(context).getAppSettingsPreferenceObjectJson("app_settings_response").getData().get(0);
        return appSettings.getCurrency().getSymbol() + new DecimalFormat("#,###.00").format(price*appSettings.getCurrency().getExchangeRate());
    }

    public static AppSettings getAppSettings(Context context){
        return new UserPrefs(context).getAppSettingsPreferenceObjectJson("app_settings_response").getData().get(0);
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static int convertDpToPx(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}
