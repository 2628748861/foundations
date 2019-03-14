package com.plugin.foundation.library.adapter.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**所有ListView/GridView适配器的基类，内部封装了具体的通用操作，将需要具体实现的操作以抽象方法的形式暴露出来，让实现类具体实现；
 * Created by admin on 2017/3/8.
 */
public abstract class BaseListAdapter<T> extends BaseAdapter
{
    protected Context context;
    private int layoutId;
    private List<T> mDatas;
    public BaseListAdapter(Context context, int layoutId, List<T> mDatas) {
        this.context = context;
        this.layoutId = layoutId;
        this.mDatas = mDatas;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }
    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        T item=mDatas.get(position);
        final ListViewViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder,position, item);
        return viewHolder.getConvertView();
    }
    public abstract void convert(ListViewViewHolder helper,int position, T item);
    private ListViewViewHolder getViewHolder(int position, View convertView, ViewGroup parent)
    {
        return ListViewViewHolder.get(context, convertView, parent, layoutId, position);
    }
}
