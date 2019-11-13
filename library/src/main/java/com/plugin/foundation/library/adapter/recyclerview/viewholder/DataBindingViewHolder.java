package com.plugin.foundation.library.adapter.recyclerview.viewholder;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

public class DataBindingViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public B bind;

    public DataBindingViewHolder(@NonNull View itemView) {
        super(itemView);
        bind=DataBindingUtil.bind(itemView);
    }
}
