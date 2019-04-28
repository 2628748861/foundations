package com.plugin.foundation.library.adapter.recyclerview.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class DataBindingViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public B bind;

    public DataBindingViewHolder(@NonNull View itemView) {
        super(itemView);
        bind=DataBindingUtil.bind(itemView);
    }
}
