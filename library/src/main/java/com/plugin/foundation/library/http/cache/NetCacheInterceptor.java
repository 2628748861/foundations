package com.plugin.foundation.library.http.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetCacheInterceptor implements Interceptor
{
    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request();
//        CacheControl cacheControl = new CacheControl.Builder()
//                .maxAge(60, TimeUnit.SECONDS)
//                .maxStale(120, TimeUnit.SECONDS).build();
        request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return response;
    }
}
