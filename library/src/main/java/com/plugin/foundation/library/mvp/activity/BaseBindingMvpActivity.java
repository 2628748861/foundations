package com.plugin.foundation.library.mvp.activity;


import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.plugin.foundation.library.mvp.presenter.MvpPresenter;
import com.plugin.foundation.library.mvp.view.MvpView;
import com.plugin.foundation.library.mvp.view.delegate.DataBindingViewDelegateImp;

public abstract class BaseBindingMvpActivity<Presenter extends MvpPresenter,Bing extends ViewDataBinding> extends MvpActivity<Presenter> {
    protected Bing bing;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //用于切除application样式的影响
        getWindow().setBackgroundDrawableResource(android.R.color.white);
    }

    @Override
    protected MvpView applyViewDelegate() {
        DataBindingViewDelegateImp<Bing> mvpView=new DataBindingViewDelegateImp<Bing>(this,contentView);
        bing=mvpView.getBinding();
        return mvpView;
    }
}
