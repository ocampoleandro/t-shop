package com.example.leandroocampo.t_shop.common.dao;

import com.example.leandroocampo.t_shop.common.dao.callback.ListCallback;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.common.network.shirt.ShirtListCallback;
import com.example.leandroocampo.t_shop.common.network.shirt.ShirtNetClient;
import com.example.leandroocampo.t_shop.common.util.NetworkUtil;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import retrofit2.Call;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShirtDAOTest {

    private ShirtDAO subject;

    @Mock
    private ShirtNetClient mockShirtNetClient;
    @Mock
    private NetworkUtil mockNetworkUtil;
    @Mock
    private ListCallback<Shirt> mockCallback;

    @SuppressWarnings("unchecked")
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        subject = new ShirtDAO(mockShirtNetClient, mockNetworkUtil);
    }

    @Test
    public void onShirtListCalled_whenNoInternet_callNoInternetCallback(){
        when(mockNetworkUtil.testInternetConnection()).thenReturn(false);
        RequestData requestData = subject.listShirts(mockCallback);

        verify(mockCallback).onNoInternetConnection();
        assertThat(requestData).isNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void onShirtListCalled_whenInternet_callGetShirts(){
        when(mockNetworkUtil.testInternetConnection()).thenReturn(true);

        Call<List<Shirt>> call = mock(Call.class);
        when(mockShirtNetClient.getShirts()).thenReturn(call);

        RequestData requestData = subject.listShirts(mockCallback);

        verify(mockShirtNetClient).getShirts();
        verify(call).enqueue(any(ShirtListCallback.class));
        assertThat(requestData).isNotNull();
    }
}
