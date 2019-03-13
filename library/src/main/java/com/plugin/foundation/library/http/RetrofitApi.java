package com.plugin.foundation.library.http;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by cample on 2018/6/12.
 */

public final class RetrofitApi implements IHttpApi {
    private Retrofit retrofit;

    public RetrofitApi(String baseUrl,OkHttpClient okHttpClient) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Override
    public <T> T create(Class<T> clasz) {
        return retrofit.create(clasz);
    }
}
