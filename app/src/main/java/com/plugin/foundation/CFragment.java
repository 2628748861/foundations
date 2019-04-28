package com.plugin.foundation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.plugin.foundation.library.mvp.fragment.BaseMvpFragment;
import com.plugin.foundation.library.mvp.presenter.MvpPresenter;

import butterknife.BindView;

public class CFragment extends BaseMvpFragment {

    @BindView(R.id.tv)
    TextView tv;


//    @Override
//    public int applyContent() {
//        return R.layout.fragment_01;
//    }
//
//    @Override
//    public MvpPresenter createPresenter() {
//        return null;
//    }
//
//    @Override
//    protected void onCreateViewLazy(Bundle savedInstanceState) {
//        super.onCreateViewLazy(savedInstanceState);
//
//        ButterKnife.bind(this.getContentView());
//
//        String str=getArguments().getString("data");
//        tv.setText(str);
//        showContent();
//
//    }


    @Override
    public MvpPresenter createPresenter() {
        return null;
    }

    @Override
    public void initViews(View view, Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
    }

    @Override
    public void lazyInit(View view, Bundle savedInstanceState) {
        String str=getArguments().getString("data");
        tv.setText(str);
        showContent();
    }

    @Override
    public int applyContent() {
        return R.layout.fragment_01;
    }




}
