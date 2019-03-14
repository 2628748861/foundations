package com.plugin.foundation.library.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2017/4/1.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    private SparseArray<View> mViews;
    private View itemView;

    private RecyclerViewHolder(View itemView)
    {
        super(itemView);
        this.itemView=itemView;
        this.mViews = new SparseArray<View>();
    }
    /**
     * 拿到一个ViewHolder对象
     * @param context
     * @param parent
     * @param layoutId
     * @return
     */
    public static RecyclerViewHolder get(Context context, ViewGroup parent, int layoutId)
    {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(itemView);
        return holder;
    }
    public View getItemView()
    {
        return itemView;
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
