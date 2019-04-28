package com.plugin.foundation;

import android.content.Context;

import com.plugin.foundation.databinding.ItemRecyBinding;
import com.plugin.foundation.library.adapter.recyclerview.adapter.DataBindingRecyclerAdapter;
import com.plugin.foundation.library.adapter.recyclerview.viewholder.DataBindingViewHolder;

import java.util.List;

public class MyAdapter2 extends DataBindingRecyclerAdapter<String,ItemRecyBinding> {
    public MyAdapter2(Context context, int layoutId, List<String> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    public void convert(DataBindingViewHolder<ItemRecyBinding> itemRecyBindingDataBindingViewHolder, int position, String item) {
        super.convert(itemRecyBindingDataBindingViewHolder, position, item);
        itemRecyBindingDataBindingViewHolder.bind.itemTv.setText(item);
    }
}
