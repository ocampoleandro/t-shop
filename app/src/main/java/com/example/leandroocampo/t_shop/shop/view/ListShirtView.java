package com.example.leandroocampo.t_shop.shop.view;

import com.example.leandroocampo.t_shop.common.model.Shirt;

import java.util.List;

public interface ListShirtView {
    void showShirts(List<Shirt> shirts);
    void showErrorFetchingList();
}
