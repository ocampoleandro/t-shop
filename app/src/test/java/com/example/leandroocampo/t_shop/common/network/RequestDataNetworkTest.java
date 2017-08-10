package com.example.leandroocampo.t_shop.common.network;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import retrofit2.Call;

import static org.mockito.Mockito.verify;

public class RequestDataNetworkTest {

    private RequestDataNetwork subject;

    private Call mockRequest;

    @Before
    public void setup() {
        mockRequest = Mockito.mock(Call.class);
        subject = new RequestDataNetwork(mockRequest);
    }

    @Test
    public void onCancelRequest_cancelShouldBeCalled(){
        subject.cancelRequest();
        verify(mockRequest).cancel();
    }

    @Test
    public void onIsRequestCancelled_isCancelledShouldBeCalled(){
        subject.isRequestCancelled();
        verify(mockRequest).isCanceled();
    }
}
