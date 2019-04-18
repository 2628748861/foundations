package com.plugin.foundation.library.downloader;

import android.app.Application;
import android.os.Environment;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.plugin.foundation.library.diskcache.IDiskCache;

import java.io.File;
import java.util.UUID;

public class FileDownLoaderImp implements IDownLoad {

    public FileDownLoaderImp(Application application)
    {
        FileDownloader.setupOnApplicationOnCreate(application);
    }

    @Override
    public boolean isDownLoading(String url) {
        return FileDownloader.getImpl().create(url).isRunning();
    }

    @Override
    public void downloadFile(String url,File saveFile,final DownLoadListener listener) {

        FileDownloader.getImpl().create(url)
                .setPath(saveFile.getPath())
                .setListener(new FileDownloadListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }
                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        if(listener!=null)
                            listener.onProgress(soFarBytes,totalBytes);
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        if(listener!=null)
                            listener.onComplite(task.getUrl(),new File(task.getPath()));
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        if(listener!=null)
                            listener.onFailed(task.getUrl(),e);
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {

                    }
                })
                .start();
    }

    @Override
    public void downloadFile(final String url,final IDiskCache diskCache,final DownLoadListener listener) {
        final File tempFile=new File(Environment.getExternalStorageDirectory(),UUID.randomUUID().toString()+".temp");
        FileDownloader.getImpl().create(url)
                .setPath(tempFile.getPath())
                .setListener(new FileDownloadListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }
                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        if(listener!=null)
                            listener.onProgress(soFarBytes,totalBytes);
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        diskCache.set(url,new File(task.getPath()));
                        if(listener!=null)
                            listener.onComplite(task.getUrl(),new File(task.getPath()));
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        if(listener!=null)
                            listener.onFailed(task.getUrl(),e);
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {

                    }
                })
                .start();
    }
}
