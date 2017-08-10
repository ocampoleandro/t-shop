package com.example.leandroocampo.t_shop.shop.presenter;

import com.example.leandroocampo.t_shop.common.dao.RequestData;
import com.example.leandroocampo.t_shop.common.dao.ShirtDAO;
import com.example.leandroocampo.t_shop.common.model.Shirt;
import com.example.leandroocampo.t_shop.shop.view.ListShirtView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ListShirtPresenterTest {

    private ListShirtPresenter subject;

    @Mock
    ShirtDAO shirtDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        subject = new ListShirtPresenter(shirtDAO);
    }

    @Test
    public void onShirtsRequested_listShirtsShouldBeCalled() {
        RequestData requestData = Mockito.mock(RequestData.class);
        when(shirtDAO.listShirts(eq(subject))).thenReturn(requestData);

        subject.onShirtsRequested();
        verify(shirtDAO).listShirts(eq(subject));
        assertThat(subject.getRequestData()).isEqualTo(requestData);
    }

    @Test
    public void onStop_whenRequestDateIsNotNullAndNotCancelled_requestShouldBeCancelled() {
        RequestData requestData = Mockito.mock(RequestData.class);
        when(shirtDAO.listShirts(eq(subject))).thenReturn(requestData);
        when(requestData.isRequestCancelled()).thenReturn(false);

        subject.onShirtsRequested();
        subject.onStop();
        verify(requestData).cancelRequest();
    }

    @Test
    public void onStop_whenRequestDateIsNotNullAndCancelled_requestShouldNotBeCancelled() {
        RequestData requestData = Mockito.mock(RequestData.class);
        when(shirtDAO.listShirts(eq(subject))).thenReturn(requestData);
        when(requestData.isRequestCancelled()).thenReturn(true);

        subject.onShirtsRequested();
        subject.onStop();
        verify(requestData, never()).cancelRequest();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void onSuccessFetchingShirts_whenOnStop_requestShouldNotBeCancelled() {
        RequestData requestData = Mockito.mock(RequestData.class);
        when(shirtDAO.listShirts(eq(subject))).thenReturn(requestData);

        ListShirtView listShirtView = Mockito.mock(ListShirtView.class);
        subject.onViewCreated(listShirtView);

        List<Shirt> shirts = Mockito.mock(List.class);
        subject.onSuccess(shirts);
        subject.onStop();
        verify(requestData, never()).cancelRequest();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void onSuccessFetchingShirts_showShirtsShouldBeCalled() {
        RequestData requestData = Mockito.mock(RequestData.class);
        when(shirtDAO.listShirts(eq(subject))).thenReturn(requestData);

        ListShirtView listShirtView = Mockito.mock(ListShirtView.class);
        subject.onViewCreated(listShirtView);

        List<Shirt> shirts = Mockito.mock(List.class);
        subject.onSuccess(shirts);
        verify(listShirtView).showShirts(eq(shirts));
        assertThat(subject.getRequestData()).isNull();
    }

    @Test
    public void onErrorFetchingShirts_showErrorShouldBeCalled() {
        ListShirtView listShirtView = Mockito.mock(ListShirtView.class);
        subject.onViewCreated(listShirtView);

        subject.onError();
        verify(listShirtView).showErrorFetchingList();
    }

    @Test
    public void onNoInternetConnection_showErrorShouldBeCalled() {
        ListShirtView listShirtView = Mockito.mock(ListShirtView.class);
        subject.onViewCreated(listShirtView);

        subject.onNoInternetConnection();
        verify(listShirtView).showErrorFetchingList();
    }
}
