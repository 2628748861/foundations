package com.plugin.foundation.library.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.plugin.foundation.library.db.DbProxy;
import com.plugin.foundation.library.db.IDbAPI;

import java.lang.reflect.Constructor;

/**
 *
 */
public class GreenDaoDelegate implements IApplifeCycle {

    private Application application;
    Class<IDbAPI> apiClass;
    public GreenDaoDelegate(Application application, Class<IDbAPI> apiClass)
    {
        this.apiClass=apiClass;
        this.application=application;
    }

    @Override
    public void attachBaseContext(Context base) {
    }

    @Override
    public void onCreate() {
        try {
            Constructor constructor = apiClass.getConstructor(new Class[]{Context.class});
            IDbAPI proxy=(IDbAPI)constructor.newInstance(application);
            DbProxy.init(proxy);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
