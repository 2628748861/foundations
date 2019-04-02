package com.plugin.foundation.library.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Environment;

import com.plugin.foundation.library.http.HttpApiProxy;
import com.plugin.foundation.library.http.RetrofitApi;
import com.plugin.foundation.library.http.entity.SSLSocketClient;

import java.io.File;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * 网络请求代理类
 */
public class HttpDelegate implements IApplifeCycle
{

    private String baseUrl;
    /** 是否支持多baseUrl动态切换
     *  注意:
     *  定义时:需要添加@Headers映射
     *  @Headers({"Domain-Name:domain"})
     *  @GET("/http/test.txt")
     *  Observable<BaseResponseEntity < String>> getArticleCategory();
     *  使用时:需要手动指定baseUrl
     *  RetrofitUrlManager.getInstance().putDomain("domain", "http://192.168.1.52");
     *  如果没有手动指定baseurl,将采用默认的baseUrl作为地址
     * @return
     */
    private boolean supportMulti;

    public HttpDelegate( String baseUrl,boolean supportMulti) {
        this.baseUrl=baseUrl;
        this.supportMulti=supportMulti;
    }

    /**提供okhttpClient
     * @param builder
     * @return
     */
    protected OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder)
    {
        //忽略https证书验证
        builder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier());
        // 缓存目录
        File file = new File(Environment.getExternalStorageDirectory(), "http_cache");
        // 缓存大小
        int cacheSize = 10 * 1024 * 1024;
        builder.cache(new Cache(file,cacheSize));
        if(supportMulti)
        {
            return RetrofitUrlManager.getInstance().with(builder).build();
        }
        return builder.build();
    }

    @Override
    public void attachBaseContext(Context base) {

    }
    @Override
    public void onCreate() {
        HttpApiProxy.init(new RetrofitApi(baseUrl,provideOkHttpClient(new OkHttpClient.Builder())));
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }
}
