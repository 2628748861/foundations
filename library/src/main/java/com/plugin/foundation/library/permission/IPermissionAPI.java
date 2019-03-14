package com.plugin.foundation.library.permission;

import android.app.Activity;

import io.reactivex.Observable;

/**
 * Created by cample on 2018/6/22.
 */

public interface IPermissionAPI {
    Observable<Boolean> request(Activity context, String... permissions);
}
