package com.plugin.foundation.library.permission;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Observable;

/**
 * Created by cample on 2018/6/26.
 */

public class PermissionAPIProxy implements IPermissionAPI {
    private static IPermissionAPI iPermission;
    private PermissionAPIProxy(){
    }
    public static void init(IPermissionAPI iPermission)
    {
        PermissionAPIProxy.iPermission=iPermission;
    }
    public static PermissionAPIProxy getInstance()
    {
       return IPermissionProxyHolder.instance;
    }

    static class IPermissionProxyHolder
    {
        private static PermissionAPIProxy instance = new PermissionAPIProxy();
    }

    @Override
    public Observable<Boolean> request(FragmentActivity context, String... permissions) {
        return iPermission.request(context,permissions);
    }

    @Override
    public Observable<Boolean> request(Fragment context, String... permissions) {
        return iPermission.request(context,permissions);
    }
}
