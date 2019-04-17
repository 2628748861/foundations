package com.plugin.foundation.library.downloader;

import android.app.Application;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;

public class FileDownLoaderImp implements IDownLoad {

    public FileDownLoaderImp(Application application)
    {
        FileDownloader.setupOnApplicationOnCreate(application);
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

}
