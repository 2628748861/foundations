package com.plugin.foundation;

import com.plugin.foundation.library.mvp.presenter.MvpPresenter;
import com.plugin.foundation.library.mvp.view.MvpView;

public class MyPresenter extends MvpPresenter {
    public MyPresenter(MvpView mvpView) {
        super(mvpView);
    }
}
