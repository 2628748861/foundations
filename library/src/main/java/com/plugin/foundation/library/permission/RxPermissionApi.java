package com.plugin.foundation.library.permission;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;

public class RxPermissionApi implements IPermissionAPI {
    @Override
    public Observable<Boolean> request(FragmentActivity context, String... permissions) {
        return new RxPermissions(context).request(permissions);
    }

    @Override
    public Observable<Boolean> request(Fragment context, String... permissions) {
        return new RxPermissions(context).request(permissions);
    }
}
