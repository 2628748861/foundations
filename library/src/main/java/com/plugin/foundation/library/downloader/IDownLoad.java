package com.plugin.foundation.library.downloader;
import com.plugin.foundation.library.diskcache.IDiskCache;

import java.io.File;

public interface IDownLoad
{

    /**下载文件并使用文件缓存
     * @param url
     * @param diskCache
     * @param listener
     */
    void downloadFile(String url,IDiskCache diskCache, DownLoadListener listener);

    /**普通下载文件并保存文件
     * @param url
     * @param file
     * @param listener
     */
    void downloadFile(String url, File file, DownLoadListener listener);

    /**是否在下载队列中
     * @param url
     * @return
     */
    boolean isDownLoading(String url);
}
