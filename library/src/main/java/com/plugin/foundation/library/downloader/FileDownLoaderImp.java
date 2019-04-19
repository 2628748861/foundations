package com.plugin.foundation.library.downloader;

import android.os.Environment;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadQueueSet;
import com.liulishuo.filedownloader.FileDownloader;
import com.plugin.foundation.library.diskcache.IDiskCache;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileDownLoaderImp implements IDownLoad {

    private List<BaseDownloadTask> tasks = new ArrayList<>();
    /**
     * 文件下载的临时目录(每次创建时清空)
     */
    private File tempDirectory;
    public FileDownLoaderImp()
    {
        tempDirectory=new File(Environment.getExternalStorageDirectory(),"/temp");
        if(tempDirectory.exists())
            tempDirectory.delete();
    }


    @Override
    public boolean isDownLoading(String url) {
        for (BaseDownloadTask task:tasks)
        {
            if(task.getUrl().equals(url))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void downloadFile(String url,File saveFile,final DownLoadListener listener) {

        if(isDownLoading(url))
            return;
        tasks.add(FileDownloader.getImpl().create(url).setPath(saveFile.getPath()));
        FileDownloadQueueSet queueSet = new FileDownloadQueueSet(new FileDownloadListener() {
            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

            }

            @Override
            protected void started(BaseDownloadTask task) {
                super.started(task);
                if(!isDownLoading(task.getUrl()))
                {
                    tasks.add(FileDownloader.getImpl().create(task.getUrl()).setPath(task.getPath()));
                }
            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                if(listener!=null)
                    listener.onProgress(task.getUrl(),soFarBytes,totalBytes);
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                if(listener!=null)
                {
                    tasks.remove(task.getUrl());
                    listener.onComplite(task.getUrl(),new File(task.getPath()));
                }

            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                if(listener!=null)
                {
                    tasks.remove(task.getUrl());
                    listener.onFailed(task.getUrl(),e);
                }

            }

            @Override
            protected void warn(BaseDownloadTask task) {

            }
        });
        queueSet.setAutoRetryTimes(1);
        queueSet.downloadTogether(tasks);
        queueSet.start();
    }

    @Override
    public void downloadFile(final String url,final IDiskCache diskCache,final DownLoadListener listener) {

        if(!tempDirectory.exists())
        {
            tempDirectory.mkdirs();
        }
        final File tempFile=new File(tempDirectory,UUID.randomUUID().toString()+".temp");
        if(isDownLoading(url))
            return;
        tasks.add(FileDownloader.getImpl().create(url).setPath(tempFile.getPath()));
        FileDownloadQueueSet queueSet = new FileDownloadQueueSet(new FileDownloadListener() {
            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

            }

            @Override
            protected void started(BaseDownloadTask task) {
                super.started(task);
                if(!isDownLoading(task.getUrl()))
                {
                    tasks.add(FileDownloader.getImpl().create(task.getUrl()).setPath(task.getPath()));
                }
            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                if(listener!=null)
                    listener.onProgress(task.getUrl(),soFarBytes,totalBytes);
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                File tempFile=new File(task.getPath());
                diskCache.set(task.getUrl(),tempFile);
                tasks.remove(task.getUrl());
                if(tempFile.exists())
                {
                    tempFile.delete();
                }

                if(listener!=null)
                {
                    listener.onComplite(task.getUrl(),new File(task.getPath()));
                }


            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                File tempFile=new File(task.getPath());
                tasks.remove(task.getUrl());
                if(tempFile.exists())
                {
                    tempFile.delete();
                }
                if(listener!=null)
                {
                    listener.onFailed(task.getUrl(),e);
                }
            }

            @Override
            protected void warn(BaseDownloadTask task) {

            }
        });
        queueSet.setAutoRetryTimes(1);
        queueSet.downloadTogether(tasks);
        queueSet.start();

    }


}
