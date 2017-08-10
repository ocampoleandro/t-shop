package com.example.leandroocampo.t_shop.test_util;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.leandroocampo.t_shop.common.ui.TitleChangeable;
import com.example.leandroocampo.t_shop.common.ui.ToolbarChangeable;

/**
 * Activity for testing purpose.
 */

public class GeneralActivity extends AppCompatActivity implements TitleChangeable, ToolbarChangeable {

    @Override
    public void setTitleToolbar(String title) {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }
    }

    @Override
    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }
}
