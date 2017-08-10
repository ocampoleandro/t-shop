package com.example.leandroocampo.t_shop.configuration.injection;

import com.example.leandroocampo.t_shop.common.dao.ShirtDAO;
import com.example.leandroocampo.t_shop.common.network.shirt.ShirtNetClient;
import com.example.leandroocampo.t_shop.common.util.NetworkUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provides the components that give access to the data model. DAO, DATABASE AND NET.
 */
@Module
public class DAOModule {

    private static final String BASE_URL = "https://mock-shirt-backend.getsandbox.com";

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(getShirtBaseUrl())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ShirtNetClient provideShirtNetClient(Retrofit retrofit) {
        return retrofit.create(ShirtNetClient.class);
    }

    @Provides
    @Singleton
    NetworkUtil provideNetworkUtil() {
        return new NetworkUtil();
    }

    @Provides
    @Singleton
    ShirtDAO provideShirtDAO(ShirtNetClient shirtNetClient, NetworkUtil networkUtil) {
        return new ShirtDAO(shirtNetClient, networkUtil);
    }

    protected String getShirtBaseUrl() {
        return BASE_URL;
    }
}
