package com.plugin.foundation.library.app;

import android.content.Context;
import android.content.res.Configuration;

import com.plugin.foundation.library.db.DbProxy;
import com.plugin.foundation.library.db.LitePalApi;
import com.plugin.foundation.library.image.GlideImageLoaderAPI;
import com.plugin.foundation.library.image.ImageLoaderProxy;
import com.plugin.foundation.library.permission.PermissionAPIProxy;
import com.plugin.foundation.library.permission.RxPermissionAPI;

import org.litepal.LitePal;

public class ImageLoaderDelegate implements IApplifeCycle {
    Context base;
    @Override
    public void attachBaseContext(Context base) {
        this.base=base;
    }

    @Override
    public void onCreate() {
        ImageLoaderProxy.init(new GlideImageLoaderAPI());
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
