package com.plugin.foundation.library.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class ApplicationProxy extends Application
{
    private AppDelegateLifeCycleProxyManger manager;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        List<IApplifeCycle> applifeCycles=new ArrayList<>();
        addApplifeCycles(applifeCycles);
        manager=new AppDelegateLifeCycleProxyManger.Builder()
                .addApplifeCycle(new DbAndImaLoaderDelegate())
                .addApplifeCycles(applifeCycles)
                .build();
        manager.attachBaseContext(base);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        manager.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        manager.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        manager.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        manager.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        manager.onTrimMemory(level);
    }

    protected abstract void addApplifeCycles(List<IApplifeCycle> applifeCycles);
}
