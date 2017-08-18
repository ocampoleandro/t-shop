package com.example.leandroocampo.t_shop.common.presenter;

import com.example.leandroocampo.t_shop.test_util.DummyView;

import org.junit.Test;
import org.mockito.Mockito;

import static com.google.common.truth.Truth.assertThat;

@SuppressWarnings("FieldCanBeLocal")
public class BasePresenterTest {

    private BasePresenter<DummyView> subject;

    @Test
    public void onViewCreated_viewShouldBeAttached() {
        subject = new BasePresenter<DummyView>() {

        };
        subject.onViewCreated(Mockito.mock(DummyView.class));
        assertThat(subject.getView()).isNotNull();
    }
}
