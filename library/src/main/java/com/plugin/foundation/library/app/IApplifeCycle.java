package com.plugin.foundation.library.app;

import android.content.Context;
import android.content.res.Configuration;

/**
 * 抽取Application生命周期
 */
public interface IApplifeCycle {
    void attachBaseContext(Context base);
    void onCreate();
    void onTerminate();
    void onLowMemory();
    void onTrimMemory(int level);
    void onConfigurationChanged(Configuration newConfig);
}
