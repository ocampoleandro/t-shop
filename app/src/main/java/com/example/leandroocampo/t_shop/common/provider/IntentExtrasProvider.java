package com.example.leandroocampo.t_shop.common.provider;

import android.content.Intent;
import android.os.Bundle;

/**
 * Lets fetch information from an {@link Intent} bundle. Also gives {@link ParamsProvider} extra capabilities.
 */

public class IntentExtrasProvider extends ParamsProvider {

    private Intent intent;

    public IntentExtrasProvider(Bundle savedInstanceState, Intent intent) {
        super(savedInstanceState);
        this.intent = intent;
    }

    @Override
    protected Bundle getBundle() {
        return (savedInstanceState != null) ? savedInstanceState : intent.getExtras();
    }

}
