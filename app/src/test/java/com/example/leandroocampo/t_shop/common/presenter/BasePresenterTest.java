package com.example.leandroocampo.t_shop.common.presenter;

import com.example.leandroocampo.t_shop.test_util.DummyView;

import org.junit.Test;
import org.mockito.Mockito;

import static com.google.common.truth.Truth.assertThat;

public class BasePresenterTest {

    private BasePresenter<DummyView> subject;

    private boolean initCalled = false;


    @Test
    public void onCreateObject_whenInjectIsTrue_initInjectShouldBeCalled() {
        subject = new BasePresenter<DummyView>(true) {
            @Override
            protected void initInject() {
                initCalled = true;
            }
        };
        assertThat(initCalled).isTrue();
    }

    @Test
    public void onCreateObject_whenInjectIsFalse_initInjectShouldBeCalled() {
        subject = new BasePresenter<DummyView>(false) {
            @Override
            protected void initInject() {
                initCalled = true;
            }
        };
        assertThat(initCalled).isFalse();
    }

    @Test
    public void onViewCreated_viewShouldBeAttached() {
        subject = new BasePresenter<DummyView>(true) {
            @Override
            protected void initInject() {
                initCalled = true;
            }
        };
        subject.onViewCreated(Mockito.mock(DummyView.class));
        assertThat(subject.getView()).isNotNull();
    }
}
