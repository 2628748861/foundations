package com.plugin.foundation.library.image;

import android.content.Context;
import android.widget.ImageView;

import com.plugin.foundation.library.image.args.Args;

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
    public void display(Context context, Args args, ImageView imageView) {
        iImageLoaderAPI.display(context, args, imageView);
    }

    @Override
    public void displayGif(Context context, Args args, ImageView imageView) {
        iImageLoaderAPI.displayGif(context, args, imageView);
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
