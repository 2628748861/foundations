package com.plugin.foundation.library.adapter.recyclerview.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by admin on 2017/4/1.
 */
public class SimpleViewHolder extends RecyclerView.ViewHolder
{
    private SparseArray<View> mViews;

    public SimpleViewHolder(View itemView)
    {
        super(itemView);
        this.mViews = new SparseArray<View>();
    }
    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId)
    {

        View view = mViews.get(viewId);
        if (view == null)
        {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }




}
