package com.plugin.foundation.library.http.cache;

import android.content.Context;

import com.plugin.foundation.library.util.NetworkUtil;

import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetCacheInterceptor implements Interceptor
{
    private Context context;

    public NetCacheInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) {
        Request.Builder builder = chain.request()
                .newBuilder();
        builder.cacheControl(CacheControl.FORCE_CACHE).url(chain.request().url())
                .build();
        if (NetworkUtil.isNetworkConnected(context)) {
            int maxAge = 60; // read from cache for 60 s
            builder
                    .removeHeader("Pragma")
                    .addHeader("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 14; // tolerate 2-weeks stale
            builder
                    .removeHeader("Pragma")
                    .addHeader("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        try {
            return chain.proceed(builder.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
