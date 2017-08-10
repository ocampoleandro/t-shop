package com.example.leandroocampo.t_shop.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.leandroocampo.t_shop.TShopApplication;

/**
 * Check the network connection.
 */

public class NetworkUtil {

    /**
     * Test the network connection.
     *
     * @return true if there is a connection available.
     */
    public boolean testInternetConnection() {
        ConnectivityManager cm =
                (ConnectivityManager) TShopApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected() && netInfo.isAvailable();
    }

}
