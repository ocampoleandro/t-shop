package com.example.leandroocampo.t_shop.common.provider;

import android.content.Intent;
import android.os.Bundle;

import org.junit.Test;
import org.mockito.Mockito;

import static com.google.common.truth.Truth.assertThat;

public class IntentExtrasProviderTest {

    private IntentExtrasProvider subject;

    @Test
    public void onCreate_attributesShouldBeInitialized() {
        subject = new IntentExtrasProvider(Mockito.mock(Bundle.class), Mockito.mock(Intent.class));
        assertThat(subject.getBundle()).isNotNull();
        assertThat(subject.getIntent()).isNotNull();
    }

    @Test
    public void onGetBundle_whenSavedInstanceStateNotNull_shouldReturnState() {
        Bundle bundleState = Mockito.mock(Bundle.class);
        subject = new IntentExtrasProvider(bundleState, null);

        Bundle bundle = subject.getBundle();
        assertThat(bundle).isEqualTo(bundleState);
    }

    @Test
    public void onGetBundle_whenSavedInstanceStateIsNull_shouldReturnParams() {
        Intent intentParams = Mockito.mock(Intent.class);
        subject = new IntentExtrasProvider(null, intentParams);

        Intent intent = subject.getIntent();
        assertThat(intent).isEqualTo(intentParams);
    }
}
