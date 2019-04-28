package com.plugin.foundation;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.plugin.foundation.library.adapter.recyclerview.adapter.ButterKnifeRecyclerAdapter;
import com.plugin.foundation.library.adapter.recyclerview.viewholder.ButterKnifeViewHolder;

import java.util.List;

import butterknife.ButterKnife;

public class MyAdapter3 extends ButterKnifeRecyclerAdapter<String> {
    public MyAdapter3(Context context, int layoutId, List<String> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    public void convert(ButterKnifeViewHolder viewHolder, int position, String item) {
        super.convert(viewHolder, position, item);
        TextView itemTv=ButterKnife.findById(viewHolder.itemView,R.id.itemTv);
        itemTv.setText(item);
    }
}
