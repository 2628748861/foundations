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
        AppDelegateLifeCycleProxyManger.Builder builder=new AppDelegateLifeCycleProxyManger.Builder()
                .addApplifeCycle(new LeakCanaryLifeCycleDelegate(this))
                .addApplifeCycle(provideHttpConifg())
                .addApplifeCycle(provideDatabaseConifg())
                .addApplifeCycle(provideImageLoaderConifg())
                .addApplifeCycle(providePermissionConifg())
                .addApplifeCycles(applifeCycles);
        manager=builder.build();
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


    protected IApplifeCycle provideHttpConifg(){
        return new HttpDelegate("");
    }
    protected IApplifeCycle provideDatabaseConifg(){
        return new DatabaseDelegate();
    }
    protected IApplifeCycle provideImageLoaderConifg()
    {
        return new ImageLoaderDelegate();
    }
    protected IApplifeCycle providePermissionConifg()
    {
        return new PermissionDelegate();
    }


    protected abstract void addApplifeCycles(List<IApplifeCycle> applifeCycles);
}
