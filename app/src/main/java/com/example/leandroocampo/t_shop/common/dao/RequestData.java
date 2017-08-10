package com.example.leandroocampo.t_shop.common.dao;

/**
 * Represents an information request. Gives the capability of cancelling a request if it is not needed anymore.
 */

public interface RequestData {

    void cancelRequest();

    boolean isRequestCancelled();
}
