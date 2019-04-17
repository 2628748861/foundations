package com.plugin.foundation.library.downloader;
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

}
