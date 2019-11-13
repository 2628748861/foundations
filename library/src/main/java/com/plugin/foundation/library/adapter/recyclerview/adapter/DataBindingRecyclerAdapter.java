package com.plugin.foundation.library.adapter.recyclerview.adapter;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import android.view.View;
import com.plugin.foundation.library.adapter.recyclerview.viewholder.DataBindingViewHolder;
import java.util.List;

/**支持databing的适配器
 * @param <T>
 */
public class DataBindingRecyclerAdapter<T,B extends ViewDataBinding> extends BaseRecyclerAdapter<T,DataBindingViewHolder<B>> {
    public DataBindingRecyclerAdapter(Context context, int layoutId, List<T> mDatas) {
        super(context, layoutId, mDatas);
    }

    @Override
    public DataBindingViewHolder createViewHolder(View view) {
        return new DataBindingViewHolder(view);
    }

    @Override
    public void convert(DataBindingViewHolder<B> viewHolder, int position, T item) {
    }
}
