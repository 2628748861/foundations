package com.plugin.foundation.library.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by cample on 2017/7/29.
 */

public abstract class BaseRecyclerAdapter<T>  extends RecyclerView.Adapter<RecyclerViewHolder> implements View.OnClickListener, View.OnLongClickListener
{

    protected Context context;
    private int layoutId;
    private List<T> mDatas;
    protected OnItemClickListener onItemClickListener;
    private OnItemLongClickListener longClickListener;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }
    public interface OnItemLongClickListener
    {
        void onItemLongClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }
    public BaseRecyclerAdapter(Context context, int layoutId, List<T> mDatas) {
        this.layoutId = layoutId;
        this.mDatas = mDatas;
        this.context=context;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder= RecyclerViewHolder.get(context,parent,layoutId);
        viewHolder.getItemView().setOnClickListener(this);
        viewHolder.getItemView().setOnLongClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.getItemView().setTag(position);
        convert(holder,position,getItem(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    public abstract void convert(RecyclerViewHolder holder, int position, T item);
    public int getItemViewCount()
    {
        return 1;
    }
    public T getItem(int position)
    {
        return mDatas.get(position);
    }

    @Override
    public boolean onLongClick(View v) {
        if(longClickListener!=null)
        {
            longClickListener.onItemLongClick((int)v.getTag());
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        if(onItemClickListener!=null)
        {
            onItemClickListener.onItemClick((int)view.getTag());
        }
    }
}
