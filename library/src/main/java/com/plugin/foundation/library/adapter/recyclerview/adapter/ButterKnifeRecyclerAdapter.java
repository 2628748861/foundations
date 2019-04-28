package com.plugin.foundation.library.adapter.recyclerview.adapter;
import android.content.Context;
import android.view.View;

import com.plugin.foundation.library.adapter.recyclerview.viewholder.ButterKnifeViewHolder;
import java.util.List;

/**支持ButterKnife的适配器
 * @param <T>
 */
public class ButterKnifeRecyclerAdapter<T> extends BaseRecyclerAdapter<T,ButterKnifeViewHolder> {
    public ButterKnifeRecyclerAdapter(Context context, int layoutId, List<T> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    public ButterKnifeViewHolder createViewHolder(View view) {
        return new ButterKnifeViewHolder(view);
    }

    @Override
    public void convert(ButterKnifeViewHolder viewHolder, int position, T item) {
    }
}
