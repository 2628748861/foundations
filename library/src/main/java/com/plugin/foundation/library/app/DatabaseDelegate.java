package com.plugin.foundation.library.app;

import android.content.Context;
import android.content.res.Configuration;

import com.plugin.foundation.library.db.DbProxy;
import com.plugin.foundation.library.db.IDbAPI;

/**
 *
 */
public class DatabaseDelegate implements IApplifeCycle {

    public DatabaseDelegate(IDbAPI dbProxy)
    {
        DbProxy.init(dbProxy);
    }

    @Override
    public void attachBaseContext(Context base) {
    }

    @Override
    public void onCreate() {
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
