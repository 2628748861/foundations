package com.plugin.foundation.library.mvp.fragment;


import com.plugin.foundation.mvp.presenter.MvpPresenter;
import com.plugin.foundation.mvp.view.MvpView;
import com.plugin.foundation.mvp.view.delegate.DefaultViewDelegateImp;

public abstract class BaseMvpFragment<Presenter extends MvpPresenter> extends MvpFragment<Presenter> {
    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegateImp(this,getContentView());
    }
}
