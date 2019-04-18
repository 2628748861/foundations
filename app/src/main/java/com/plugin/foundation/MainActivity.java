package com.plugin.foundation;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.plugin.foundation.library.diskcache.DiskLrucaheImp;
import com.plugin.foundation.library.diskcache.IDiskCache;
import com.plugin.foundation.library.downloader.DownLoadListener;
import com.plugin.foundation.library.downloader.DownloadProxy;
import com.plugin.foundation.library.downloader.FileDownLoaderImp;
import com.plugin.foundation.library.mvp.activity.BaseMvpActivity;
import com.plugin.foundation.library.mvp.activity.WebActivity;
import com.plugin.foundation.library.mvp.presenter.MvpPresenter;
import com.plugin.foundation.library.util.LogUtils;
import com.plugin.foundation.library.util.Md5Util;
import com.plugin.foundation.library.util.SdcardUtils;

import java.io.File;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity {

    @BindView(R.id.title_template)
    TextView title_template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        DownloadProxy.init(new FileDownLoaderImp(getApplication()));
        File directory=new File(Environment.getExternalStorageDirectory(),"/MT2/download");
        IDiskCache cache=new DiskLrucaheImp(directory,1024*1024*10);
        File file=cache.get(Md5Util.hashKeyForDisk("https://avatar.csdn.net/1/0/0/3_piglite.jpg"));
        if(file!=null)
        {
            Log.e("TAG","file:"+file.exists());
        }

        DownloadProxy.getInstance().downloadFile("https://avatar.csdn.net/1/0/0/3_piglite.jpg", cache , new DownLoadListener() {
            @Override
            public void onProgress(int soFarBytes, int totalBytes) {

            }

            @Override
            public void onComplite(String url, File file) {

            }

            @Override
            public void onFailed(String url, Throwable e) {

            }
        });


    }

    @Override
    public int applyContent() {
        return R.layout.activity_main;
    }

    @Override
    public MvpPresenter createPresenter() {
        return null;
    }
}
