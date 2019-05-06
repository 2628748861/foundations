package com.plugin.foundation.library.image.glide;

import android.graphics.Bitmap;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.plugin.foundation.library.image.args.Args;

/**
 * Glide实现的参数构建类,主要用于填充泛型参数
 */
public class GlideArgsBuilder extends Args.Builder<Transformation<Bitmap>,TransitionOptions<BitmapTransitionOptions,Bitmap>,RequestListener<Bitmap>> {
}
