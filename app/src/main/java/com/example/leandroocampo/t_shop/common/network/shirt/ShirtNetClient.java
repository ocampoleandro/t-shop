package com.example.leandroocampo.t_shop.common.network.shirt;

import com.example.leandroocampo.t_shop.common.model.Shirt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Gives access to {@link Shirt} that come from the API.
 */

public interface ShirtNetClient {

    @GET("/shirts")
    Call<List<Shirt>> getShirts();
}
