package com.plugin.foundation.library.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class LeakCanaryLifeCycleDelegate implements IApplifeCycle
{
    private Application application;

    public LeakCanaryLifeCycleDelegate(Application application) {
        this.application = application;
    }

    @Override
    public void attachBaseContext(Context base) {
    }

    @Override
    public void onCreate() {
        if (LeakCanary.isInAnalyzerProcess(application)) {//1
            return;
        }
        LeakCanary.install(application);
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
