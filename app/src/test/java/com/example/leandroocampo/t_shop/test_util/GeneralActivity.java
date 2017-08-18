package com.example.leandroocampo.t_shop.test_util;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.leandroocampo.t_shop.common.ui.FragmentChangeable;
import com.example.leandroocampo.t_shop.common.ui.TitleChangeable;
import com.example.leandroocampo.t_shop.common.ui.ToolbarChangeable;

/**
 * Activity for testing purpose.
 */

public class GeneralActivity extends AppCompatActivity
        implements TitleChangeable, ToolbarChangeable, FragmentChangeable {

    public Fragment fragmentUpdated;

    @Override
    public void setTitleToolbar(String title) {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }
    }

    @Override
    public void setToolbar(Toolbar toolbar, boolean addBackButton) {
        setSupportActionBar(toolbar);
    }

    @Override
    public void updateMainFragment(Fragment fragment) {
        fragmentUpdated = fragment;
    }
}
