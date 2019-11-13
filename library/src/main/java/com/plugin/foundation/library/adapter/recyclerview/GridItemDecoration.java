package com.plugin.foundation.library.adapter.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.plugin.foundation.library.util.DensityUtils;


/**
 * Created by cample on 2018/7/20.
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration
{
    private int spanCount;
    private int spacing;

    public GridItemDecoration(Context mContext, int spanCount, int spacing) {
        this.spacing = DensityUtils.dp2px(mContext,spacing);
        this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);
        int column = position / spanCount;
        //outRect.left=spacing;
        outRect.top=column>0?0:spacing;
        outRect.right=spacing;
        outRect.bottom=spacing;
    }
}
