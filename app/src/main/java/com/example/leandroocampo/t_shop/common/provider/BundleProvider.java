package com.example.leandroocampo.t_shop.common.provider;

import android.os.Bundle;

/**
 * Lets fetch information from an {@link Bundle} bundle (information that was passed as parameters mainly).
 * Also gives {@link ParamsProvider} extra capabilities.
 */

public class BundleProvider extends ParamsProvider {

    private Bundle params;

    public BundleProvider(Bundle savedInstanceState, Bundle params) {
        super(savedInstanceState);
        this.params = params;
    }


    @Override
    protected Bundle getBundle() {
        return (savedInstanceState != null) ? savedInstanceState : params;
    }

}
