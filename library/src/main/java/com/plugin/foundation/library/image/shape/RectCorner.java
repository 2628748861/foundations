package com.plugin.foundation.library.image.shape;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.load.Transformation;
import com.plugin.foundation.library.image.CornerTransform;

/**
 * 圆角矩形
 *
 */
public class RectCorner extends CornerShape<Transformation<Bitmap>> {
    private Context mContext;
    /**
     * 圆角半径
     */
    private int radius;
    /**
     * 矩形四个角是否需要圆角修饰
     */
    private boolean leftTop,rightTop,leftBottom,rightBottom;

    public RectCorner(Context mContext,int radius,boolean leftTop, boolean rightTop, boolean leftBottom, boolean rightBottom) {
        this.mContext = mContext;
        this.radius=radius;
        this.leftTop=leftTop;
        this.rightTop=rightTop;
        this.leftBottom=leftBottom;
        this.rightBottom=rightBottom;
    }

    @Override
    public Transformation<Bitmap> getShape() {
        return new CornerTransform(mContext,radius).exceptCorner(leftTop,rightTop,leftBottom,rightBottom);
    }
}
