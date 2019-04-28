package com.plugin.foundation;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.plugin.foundation.library.adapter.recyclerview.adapter.SimpleRecyclerAdapter;
import com.plugin.foundation.library.adapter.recyclerview.viewholder.SimpleViewHolder;

import java.util.List;

public class MyAdapter1 extends SimpleRecyclerAdapter<String> {
    public MyAdapter1(Context context, int layoutId, List<String> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    public void convert(SimpleViewHolder holder, int position, String item) {
        super.convert(holder, position, item);
        TextView itemTv=holder.getView(R.id.itemTv);
        itemTv.setText(item);
    }
}
