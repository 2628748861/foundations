package com.plugin.foundation.library.adapter.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.plugin.foundation.library.util.DensityUtils;


/**
 * Created by cample on 2018/7/20.
 */

public class ListItemDecoration extends RecyclerView.ItemDecoration
{
    private int height;
    private int color;

    public ListItemDecoration(Context mContext, int height, int color) {
        this.height = DensityUtils.dp2px(mContext,height);
        this.color = color;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Paint paint=new Paint();
        paint.setColor(color);

        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();

        int childCount=parent.getChildCount();
        for (int i=0;i<childCount;i++)
        {
            View child=parent.getChildAt(i);
            int top=child.getBottom();
            int bottom=top+height;
            c.drawRect(left,top,right,bottom,paint);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom=height;
    }
}
