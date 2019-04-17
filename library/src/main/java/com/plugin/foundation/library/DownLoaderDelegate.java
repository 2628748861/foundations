package com.plugin.foundation.library;

import android.content.Context;
import android.content.res.Configuration;

import com.plugin.foundation.library.app.IApplifeCycle;
import com.plugin.foundation.library.downloader.DownloadProxy;
import com.plugin.foundation.library.downloader.FileDownLoaderImp;

/**
 * 下载代理实现
 */
public class DownLoaderDelegate implements IApplifeCycle
{

    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate() {
        DownloadProxy.init(new FileDownLoaderImp());
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
