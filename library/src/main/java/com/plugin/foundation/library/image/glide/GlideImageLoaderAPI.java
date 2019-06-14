package com.plugin.foundation.library.image.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition;
import com.plugin.foundation.library.image.args.Args;
import com.plugin.foundation.library.image.ImageLoaderAPI;

import java.io.File;

/**
 * Created by cample on 2018/3/21.
 */

public class GlideImageLoaderAPI implements ImageLoaderAPI<Transformation<Bitmap>,TransitionOptions<BitmapTransitionOptions, Bitmap>,RequestListener<Bitmap>>
{
    @Override
    public void display(Context context, Args<Transformation<Bitmap>,TransitionOptions<BitmapTransitionOptions, Bitmap>,RequestListener<Bitmap>> args, ImageView imageView) {
        if(args==null)return;
        RequestBuilder<Bitmap> requestBuilder=Glide.with(context)
                .asBitmap()
                .load(args.getUri())
                .placeholder(args.getPlaceHolder())
                .error(args.getError())
                .skipMemoryCache(false)
                .thumbnail(args.getThumbnail());
        if(args.getWidth()!=0&&args.getHeight()!=0)
            requestBuilder.override(args.getWidth(),args.getHeight());
        if(args.getListener()!=null)
            requestBuilder.listener(args.getListener());
        if(args.getShape()!=null)
            requestBuilder.transform(args.getShape().getShape());
        if(args.getTransaction()!=null)
            requestBuilder.transition(args.getTransaction());
        requestBuilder.into(imageView);
    }

    @Override
    public void displayGif(Context context, Args args, ImageView imageView) {
        if(args==null)return;
        Glide.with(context)
                .asGif()
                .load(args.getUri())
                .placeholder(args.getPlaceHolder())
                .error(args.getError())
                .thumbnail(args.getThumbnail())
                .into(imageView);
    }

    @Override
    public long getCacheSize(Context context) {
       return getFolderSize(new File(context.getCacheDir() + "/"+ InternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR));
    }

    @Override
    public void clear(Context context) {
        Glide.get(context).clearMemory();
        Glide.get(context).clearDiskCache();
    }

    private long getFolderSize(File file)  {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (File aFileList : fileList) {
                if (aFileList.isDirectory()) {
                    size = size + getFolderSize(aFileList);
                } else {
                    size = size + aFileList.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
}
