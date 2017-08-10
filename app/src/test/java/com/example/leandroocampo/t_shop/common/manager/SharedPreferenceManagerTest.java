package com.example.leandroocampo.t_shop.common.manager;

import com.example.leandroocampo.t_shop.BuildConfig;
import com.example.leandroocampo.t_shop.TShopTestApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.google.common.truth.Truth.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = TShopTestApplication.class)
public class SharedPreferenceManagerTest {

    private SharedPreferenceManager subject;

    @Before
    public void setup() {
        subject = new SharedPreferenceManager();
    }

    @Test
    public void onPutString_ShouldSaveValue(){
        subject.putString("key","value");
        assertThat(TShopTestApplication.getInstance()
                .getSharedPreferences().getString("key",null)).isEqualTo("value");
    }

    @Test
    public void onGetString_shouldFetchValue(){
        subject.putString("key","value");
        assertThat(subject.getString("key")).isEqualTo("value");
    }
}
