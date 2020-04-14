package com.plugin.foundation.library.permission;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Observable;

/**
 * Created by cample on 2018/6/22.
 */

public interface IPermissionAPI {
    Observable<Boolean> request(FragmentActivity context, String... permissions);
    Observable<Boolean> request(Fragment context, String... permissions);
}
