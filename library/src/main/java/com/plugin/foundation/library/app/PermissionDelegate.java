package com.plugin.foundation.library.app;

import android.content.Context;
import android.content.res.Configuration;

import com.plugin.foundation.library.image.GlideImageLoaderAPI;
import com.plugin.foundation.library.image.ImageLoaderProxy;
import com.plugin.foundation.library.permission.PermissionAPIProxy;
import com.plugin.foundation.library.permission.RxPermissionAPI;

public class PermissionDelegate implements IApplifeCycle {
    @Override
    public void attachBaseContext(Context base) {
    }

    @Override
    public void onCreate() {
        PermissionAPIProxy.init(new RxPermissionAPI());
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
