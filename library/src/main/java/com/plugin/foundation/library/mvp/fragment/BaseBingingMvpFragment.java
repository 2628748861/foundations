package com.plugin.foundation.library.mvp.fragment;




import android.databinding.ViewDataBinding;

import com.plugin.foundation.library.mvp.presenter.MvpPresenter;
import com.plugin.foundation.library.mvp.view.MvpView;
import com.plugin.foundation.library.mvp.view.delegate.ButterKnifeViewDelegateImp;
import com.plugin.foundation.library.mvp.view.delegate.DataBindingViewDelegateImp;

public abstract class BaseBingingMvpFragment<Presenter extends MvpPresenter,Bing extends ViewDataBinding> extends MvpFragment<Presenter> {
    protected Bing bing;
    @Override
    protected MvpView applyViewDelegate() {
        DataBindingViewDelegateImp<Bing> mvpView= new DataBindingViewDelegateImp<Bing>(this,getContentView());
        bing=mvpView.getBinding();
        return mvpView;
    }
}
