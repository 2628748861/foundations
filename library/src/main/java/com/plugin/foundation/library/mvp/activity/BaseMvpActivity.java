package com.plugin.foundation.library.mvp.activity;


import com.plugin.foundation.mvp.presenter.MvpPresenter;
import com.plugin.foundation.mvp.view.MvpView;
import com.plugin.foundation.mvp.view.delegate.DefaultViewDelegateImp;

public abstract class BaseMvpActivity<Presenter extends MvpPresenter> extends MvpActivity<Presenter> {
    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegateImp(this,contentView);
    }
}
