package com.plugin.foundation.library.downloader;
import com.plugin.foundation.library.diskcache.IDiskCache;

import java.io.File;


/**
 * Created by cample on 2018/3/21.
 */

public final class DownloadProxy implements IDownLoad
{
    private static IDownLoad iDownLoad;
    private DownloadProxy(){
    }
    public static void init(IDownLoad iDownLoad)
    {
        DownloadProxy.iDownLoad=iDownLoad;
    }
    public static DownloadProxy getInstance()
    {
        return IDownloadProxyHolder.instance;
    }

    private static class IDownloadProxyHolder
    {
        private static DownloadProxy instance = new DownloadProxy();
    }
    @Override
    public void downloadFile(String url, File saveFile, DownLoadListener listener) {
        iDownLoad.downloadFile(url,saveFile,listener);
    }

    @Override
    public void downloadFile(String url,  IDiskCache diskCache, DownLoadListener listener) {
        iDownLoad.downloadFile(url, diskCache, listener);
    }

    @Override
    public boolean isDownLoading(String url) {
        return iDownLoad.isDownLoading(url);
    }
}
