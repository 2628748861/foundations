package com.plugin.foundation.library.adapter.recyclerview.adapter;

import android.content.Context;
import android.view.View;

import com.plugin.foundation.library.adapter.recyclerview.viewholder.ButterKnifeViewHolder;
import com.plugin.foundation.library.adapter.recyclerview.viewholder.SimpleViewHolder;

import java.util.List;

/**简单适配器
 * @param <T>
 */
public class SimpleRecyclerAdapter<T> extends BaseRecyclerAdapter<T,SimpleViewHolder> {
    public SimpleRecyclerAdapter(Context context, int layoutId, List<T> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    public SimpleViewHolder createViewHolder(View view) {
        return new SimpleViewHolder(view);
    }
    @Override
    public void convert(SimpleViewHolder viewHolder, int position, T item) {

    }
}
