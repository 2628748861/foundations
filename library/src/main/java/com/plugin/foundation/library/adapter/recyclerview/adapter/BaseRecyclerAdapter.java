package com.plugin.foundation.library.adapter.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by cample on 2017/7/29.
 */

public abstract class BaseRecyclerAdapter<T,V extends RecyclerView.ViewHolder>  extends RecyclerView.Adapter<V> implements View.OnClickListener, View.OnLongClickListener
{

    protected Context context;
    private int layoutId;
    private List<T> mDatas;
    private LayoutInflater inflater;
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
        this.inflater=LayoutInflater.from(context);
    }
    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(layoutId,parent,false);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(V holder, final int position) {
        holder.itemView.setTag(position);
        convert(holder,position,getItem(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    public abstract V createViewHolder(View view);
    public abstract void convert(V v, int position, T item);
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
