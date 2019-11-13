package com.plugin.foundation.library.mvp.view.delegate;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.view.View;

public class DataBindingViewDelegateImp<Bing extends ViewDataBinding> extends DefaultViewDelegateImp {
    private Bing binding;

    public DataBindingViewDelegateImp(Object target, View contentView) {
        super(target, contentView);
        binding=DataBindingUtil.bind(contentView);
    }

    public Bing getBinding() {
        return binding;
    }

    @Override
    public void onDetach() {
        if(binding!=null)
        {
            binding.unbind();
        }
    }
}

