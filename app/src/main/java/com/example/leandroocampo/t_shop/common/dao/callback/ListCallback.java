package com.example.leandroocampo.t_shop.common.dao.callback;

import java.util.List;

/**
 * Returns the model information as a list.
 */

public interface ListCallback<T> {
    /**
     * the information could be fetched
     *
     * @param data the information fetched
     */
    void onSuccess(List<T> data);

    void onError();

    void onNoInternetConnection();
}
