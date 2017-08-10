package com.example.leandroocampo.t_shop.common.dao.callback;

/**
 * Returns the model information as a single entity.
 */

public interface EntityCallback<T> {
    /**
     * the information could be fetched
     *
     * @param data the information fetched
     */
    void onSuccess(T data);

    void onError();
}
