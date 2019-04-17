package com.plugin.foundation.library.downloader;

import java.io.File;

/**
 * 下载监听
 */
public interface DownLoadListener
{
    /**下载进度更新
     * @param soFarBytes
     * @param totalBytes
     */
    void onProgress(int soFarBytes, int totalBytes);

    /**下载完成
     * @param url 下载的url
     * @param file 下载文件的存储路径
     */
    void onComplite(String url, File file);

    /**下载失败
     * * @param url 下载的url
     * @param e
     */
    void onFailed(String url,Throwable e);
}
