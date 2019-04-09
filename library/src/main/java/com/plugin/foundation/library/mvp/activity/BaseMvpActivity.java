package com.plugin.foundation.library.mvp.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.plugin.foundation.library.mvp.presenter.MvpPresenter;
import com.plugin.foundation.library.mvp.view.MvpView;
import com.plugin.foundation.library.mvp.view.delegate.DefaultViewDelegateImp;

public abstract class BaseMvpActivity<Presenter extends MvpPresenter> extends MvpActivity<Presenter> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //用于切除application样式的影响
        getWindow().setBackgroundDrawableResource(android.R.color.white);
    }

    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegateImp(this,contentView);
    }
}
