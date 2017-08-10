package com.example.leandroocampo.t_shop.common.provider;

import android.os.Bundle;
import android.os.Parcelable;

import com.example.leandroocampo.t_shop.test_util.DummyParcel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class ParamsProviderTest {

    private ParamsProvider subject;

    @Mock
    private Bundle mockSavedInstanceState;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        subject = new ParamsProvider(mockSavedInstanceState);
    }

    @Test
    public void onCreate_attributesShouldBeInitialized(){
        assertThat(subject.getBundle()).isNotNull();
    }

    @Test
    public void onGetParcelable_getParcelableShouldBeCalled(){
        subject.getParcelable("key");
        verify(mockSavedInstanceState).getParcelable(eq("key"));
    }

    @Test
    public void onPutParcelable_putParcelableShouldBeCalled(){
        DummyParcel object = new DummyParcel("field");
        subject.putParcelable("key",object);
        verify(mockSavedInstanceState).putParcelable(eq("key"),any(Parcelable.class));
    }

    @Test
    public void onGetString_getStringShouldBeCalled(){
        subject.getString("key");
        verify(mockSavedInstanceState).getString(eq("key"));
    }

    @Test
    public void onPutString_putStringShouldBeCalled(){
        subject.putString("key","value");
        verify(mockSavedInstanceState).putString(eq("key"),eq("value"));
    }
}
