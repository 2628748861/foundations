package com.plugin.foundation.library.adapter.listview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2017/4/1.
 */
public class ListViewViewHolder
{
    private final SparseArray<View> mViews;
    private View mConvertView;

    private ListViewViewHolder(Context context, ViewGroup parent, int layoutId,
                               int position)
    {
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        //setTag
        mConvertView.setTag(this);


    }

    /**
     * 拿到一个ViewHolder对象
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ListViewViewHolder get(Context context, View convertView,
                                         ViewGroup parent, int layoutId, int position)
    {

        if (convertView == null)
        {
            return new ListViewViewHolder(context, parent, layoutId, position);
        }
        return (ListViewViewHolder) convertView.getTag();
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
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView()
    {
        return mConvertView;
    }



}
