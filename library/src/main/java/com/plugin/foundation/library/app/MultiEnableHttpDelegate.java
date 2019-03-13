package com.plugin.foundation.library.app;


import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;

/**
 * 支持多baseUrl动态切换
 *
 * 注意:
 * 定义时:需要添加@Headers映射
 *  @Headers({"Domain-Name:domain"})
 *  @GET("/http/test.txt")
 *  Observable<BaseResponseEntity < String>> getArticleCategory();
 *  使用时:需要手动指定baseUrl
 * RetrofitUrlManager.getInstance().putDomain("domain", "http://192.168.1.52");
 *
 */
public class MultiEnableHttpDelegate extends HttpDelegate
{
    public MultiEnableHttpDelegate(String baseUrl) {
        super(baseUrl);
    }

    @Override
    protected OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return RetrofitUrlManager.getInstance().with(builder).build();
    }
}
