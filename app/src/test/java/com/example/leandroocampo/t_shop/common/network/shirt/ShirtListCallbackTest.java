package com.example.leandroocampo.t_shop.common.network.shirt;

import com.example.leandroocampo.t_shop.common.dao.callback.ListCallback;
import com.example.leandroocampo.t_shop.common.model.Shirt;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class ShirtListCallbackTest {

    private ShirtListCallback subject;
    private ListCallback<Shirt> mockCallback;
    private Call<List<Shirt>> mockCall;

    @SuppressWarnings("unchecked")
    @Before
    public void setup() {
        mockCallback = Mockito.mock(ListCallback.class);
        subject = new ShirtListCallback(mockCallback);
        mockCall = Mockito.mock(Call.class);
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    @Test
    public void onFailure_onErrorShouldBeCalled() {
        Throwable t = Mockito.mock(Throwable.class);

        subject.onFailure(mockCall, t);
        verify(mockCallback).onError();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void onResponse_whenSucceed_onSuccessShouldBeCalled() {
        List<Shirt> shirts = new ArrayList<>();
        shirts.add(new Shirt());
        Response<List<Shirt>> response = Response.success(shirts);

        subject.onResponse(mockCall, response);
        verify(mockCallback).onSuccess(eq(shirts));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void onResponse_whenFail_onErrorShouldBeCalled() {
        Response<List<Shirt>> response = Response.error(404, Mockito.mock(ResponseBody.class));

        subject.onResponse(mockCall, response);
        verify(mockCallback).onError();
    }
}
