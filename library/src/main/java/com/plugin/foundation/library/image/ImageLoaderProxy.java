package com.plugin.foundation.library.image;

import android.content.Context;
import android.widget.ImageView;

import com.plugin.foundation.library.image.shape.CornerShape;

import java.io.File;

/**
 * Created by cample on 2018/6/26.
 */

public final class ImageLoaderProxy implements ImageLoaderAPI {
    private static ImageLoaderAPI iImageLoaderAPI;
    private ImageLoaderProxy(){}
    public static void init(ImageLoaderAPI imageLoaderAPI)
    {
        ImageLoaderProxy.iImageLoaderAPI=imageLoaderAPI;
    }
    public static ImageLoaderProxy getInstance()
    {
       return IImageLoaderProxyHolder.instance;
    }

    static class IImageLoaderProxyHolder
    {
        private static ImageLoaderProxy instance = new ImageLoaderProxy();
    }


    @Override
    public void display(Context context, String url, int placeHolder, CornerShape shape, ImageView imageView) {
        iImageLoaderAPI.display(context, url, placeHolder, shape, imageView);
    }

    @Override
    public void display(Context context, Integer drawableResId, int placeHolder, CornerShape shape, ImageView imageView) {
        iImageLoaderAPI.display(context, drawableResId, placeHolder, shape, imageView);
    }

    @Override
    public void display(Context context, File file, int placeHolder, CornerShape shape, ImageView imageView) {
        iImageLoaderAPI.display(context, file, placeHolder, shape, imageView);
    }

    @Override
    public long getCacheSize(Context context) {
        return iImageLoaderAPI.getCacheSize(context);
    }

    @Override
    public void clear(Context context) {
        if (context==null) return;
        iImageLoaderAPI.clear(context);
    }
}
