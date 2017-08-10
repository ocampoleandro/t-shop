package com.example.leandroocampo.t_shop.common.provider;

import android.os.Bundle;

import org.junit.Test;
import org.mockito.Mockito;

import static com.google.common.truth.Truth.assertThat;

public class BundleProviderTest {

    private BundleProvider subject;

    @Test
    public void onCreate_attributesShouldBeInitialized(){
        subject = new BundleProvider(Mockito.mock(Bundle.class),Mockito.mock(Bundle.class));
        assertThat(subject.getBundle()).isNotNull();
        assertThat(subject.getParams()).isNotNull();
    }

    @Test
    public void onGetBundle_whenSavedInstanceStateNotNull_shouldReturnState(){
        Bundle bundleState = Mockito.mock(Bundle.class);
        subject = new BundleProvider(bundleState,null);

        Bundle bundle = subject.getBundle();
        assertThat(bundle).isEqualTo(bundleState);
    }

    @Test
    public void onGetBundle_whenSavedInstanceStateIsNull_shouldReturnParams(){
        Bundle bundleParams = Mockito.mock(Bundle.class);
        subject = new BundleProvider(null,bundleParams);

        Bundle bundle = subject.getBundle();
        assertThat(bundle).isEqualTo(bundleParams);
    }
}
