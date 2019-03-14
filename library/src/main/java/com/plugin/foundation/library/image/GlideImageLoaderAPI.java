package com.plugin.foundation.library.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.io.File;


/**
 * Created by cample on 2018/3/21.
 */

public class GlideImageLoaderAPI implements ImageLoaderAPI
{
    @Override
    public void display(Context context, String url, int placeHolder,boolean isCircle, int radius, ImageView imageView) {
        Glide.with(context).load(url).placeholder(placeHolder).apply(getRequestOptions(isCircle, radius)).into(imageView);
    }

    @Override
    public void display(Context context, Integer drawableResId, int placeHolder,boolean isCircle, int radius, ImageView imageView) {
        Glide.with(context).load(drawableResId).placeholder(placeHolder).apply(getRequestOptions(isCircle, radius)).into(imageView);
    }

    @Override
    public void display(Context context, File file, int placeHolder, boolean isCircle, int radius, ImageView imageView) {

        Glide.with(context).load(file).placeholder(placeHolder).apply(getRequestOptions(isCircle, radius)).into(imageView);
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

    private RequestOptions getRequestOptions(boolean isCircle,int radius)
    {
        RequestOptions options;
        if(isCircle)
        {
            options = RequestOptions.circleCropTransform();
        }
        else
        {
            RoundedCorners roundedCorners= new RoundedCorners(radius);
            options=RequestOptions.bitmapTransform(roundedCorners);
        }
        return options;
    }

}
