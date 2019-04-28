package com.plugin.foundation.library.mvp.view.delegate;

import android.view.View;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ButterKnifeViewDelegateImp extends DefaultViewDelegateImp {
    private Unbinder unbinder;

    public ButterKnifeViewDelegateImp(Object target, View contentView) {
        super(target, contentView);
        unbinder=ButterKnife.bind(target, contentView);
    }
    @Override
    public void onDetach() {
        if(unbinder!=null)
        {
            unbinder.unbind();
            unbinder=null;
        }
    }
}

