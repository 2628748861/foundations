package com.plugin.foundation.library.app;

import android.content.Context;
import android.content.res.Configuration;

import com.plugin.foundation.library.http.HttpApiProxy;
import com.plugin.foundation.library.http.RetrofitApi;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;

/**
 * 网络
 */
public class HttpDelegate implements IApplifeCycle
{

    private String baseUrl;

    public HttpDelegate( String baseUrl) {
        this.baseUrl=baseUrl;
    }

    /**提供okhttpClient
     * @param builder
     * @return
     */
    protected OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder)
    {
        if(supportMulti())
        {
            return RetrofitUrlManager.getInstance().with(builder).build();
        }
        return  builder.build();
    }

    /**是否支持多baseUrl动态切换
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
    protected boolean supportMulti()
    {
        return false;
    }


    @Override
    public void attachBaseContext(Context base) {

    }
    @Override
    public void onCreate() {
//        /**
//         * 如果只是单baseUrl不进行动态切换则可以这样写:
//         * OkHttpClient okHttpClient=new OkHttpClient.Builder()
//         *                 //.addInterceptor() 添加拦截器 等...
//         *                 .build();
//         * 如果需要支持多baseUrl动态切换则这样写:
//         *  OkHttpClient okHttpClient=RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder())
//         *  //.addInterceptor() 添加拦截器 等...
//         *  .build();
//         * **/
        OkHttpClient okHttpClient=provideOkHttpClient(new OkHttpClient.Builder());
//        if(multiEnable)
//        {
//            okHttpClient=RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder())
//                    .build();
//        }
//        else
//        {
//            okHttpClient=new OkHttpClient.Builder().build();
//        }

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
