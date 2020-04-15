package com.plugin.foundation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.plugin.foundation.library.mvp.presenter.MvpPresenter;
import com.plugin.foundation.library.util.Md5Util;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




//        DownloadProxy.init(new FileDownLoaderImp(getApplication()));
//        File directory=new File(Environment.getExternalStorageDirectory(),"/MT2/download");
//        IDiskCache cache=new DiskLrucaheImp(directory,1024*1024*10);
//        File file=cache.get("https://avatar.csdn.net/1/0/0/3_piglite.jpg");
//        Log.e("TAG","file:"+file);
//        if(file!=null)
//        {
//            Log.e("TAG","file:"+file.exists());
//        }


        String result1= Md5Util.hashKeyForDisk("https://avatar.csdn.net/1/0/0/哈哈.jpg");
        Log.e("TAG","result:"+",result1:"+result1);
//
//        DownloadProxy.getInstance().downloadFile("https://avatar.csdn.net/1/0/0/3_piglite.jpg", cache , new DownLoadListener() {
//            @Override
//            public void onProgress(int soFarBytes, int totalBytes) {
//
//            }
//
//            @Override
//            public void onComplite(String url, File file) {
//
//            }
//
//            @Override
//            public void onFailed(String url, Throwable e) {
//
//            }
//        });


    }

}
