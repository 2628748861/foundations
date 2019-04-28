package com.plugin.foundation.library.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.plugin.foundation.library.image.shape.CornerShape;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.io.File;


/**
 * Created by cample on 2018/3/21.
 */

public class GlideImageLoaderAPI implements ImageLoaderAPI<Transformation<Bitmap>>
{
    @Override
    public void display(Context context, String url, int placeHolder, CornerShape<Transformation<Bitmap>> shape, ImageView imageView) {
        RequestBuilder<Drawable> requestBuilder=Glide.with(context).load(url).placeholder(placeHolder);
        if(shape!=null)
        {
            requestBuilder.transform(shape.getShape());
        }
        requestBuilder.into(imageView);
    }

    @Override
    public void display(Context context, Integer drawableResId, int placeHolder, CornerShape<Transformation<Bitmap>> shape, ImageView imageView) {
        RequestBuilder<Drawable> requestBuilder=Glide.with(context).load(drawableResId).placeholder(placeHolder);
        if(shape!=null)
        {
            requestBuilder.transform(shape.getShape());
        }
        requestBuilder.into(imageView);
    }

    @Override
    public void display(Context context, File file, int placeHolder, CornerShape<Transformation<Bitmap>> shape, ImageView imageView) {
        RequestBuilder<Drawable> requestBuilder=Glide.with(context).load(file).placeholder(placeHolder);
        if(shape!=null)
        {
            requestBuilder.transform(shape.getShape());
        }
        requestBuilder.into(imageView);
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
