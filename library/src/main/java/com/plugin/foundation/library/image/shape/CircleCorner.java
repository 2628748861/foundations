package com.plugin.foundation.library.image.shape;

import android.graphics.Bitmap;

import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

/**
 * 圆形
 */
public class CircleCorner extends CornerShape<Transformation<Bitmap>> {
    @Override
    public Transformation<Bitmap> getShape() {
        return new CircleCrop();
    }
}
