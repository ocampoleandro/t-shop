package com.example.leandroocampo.t_shop.common.presenter.factory;

import com.example.leandroocampo.t_shop.common.presenter.HomePresenter;
import com.example.leandroocampo.t_shop.common.provider.ParamsProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.google.common.truth.Truth.assertThat;

public class HomePresenterFactoryTest {

    private HomePresenterFactory subject;

    @Before
    public void setup(){
        subject = new HomePresenterFactory();
    }

    @Test
    public void onCreate_showCreateObject(){
        HomePresenter presenter = subject.create(Mockito.mock(ParamsProvider.class));
        assertThat(presenter).isNotNull();
    }
}
