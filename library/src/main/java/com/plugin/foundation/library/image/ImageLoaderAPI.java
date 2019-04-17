package com.plugin.foundation.library.image;

import android.content.Context;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by cample on 2018/3/21.
 */

public interface ImageLoaderAPI {

    /**加载网络图片
     * @param url
     * @param imageView
     */
    void display(Context context, String url,int placeHolder,boolean isCircle,int radius, ImageView imageView);

    /**加载本地资源图片
     * @param context
     * @param drawableResId
     * @param imageView
     */
    void display(Context context, Integer drawableResId,int placeHolder,boolean isCircle,int radius, ImageView imageView);

    /**加载本地图片
     * @param file
     * @param imageView
     */
    void display(Context context, File file, int placeHolder, boolean isCircle,int radius, ImageView imageView);

    /**获取缓存大小
     * @param context
     * @return
     */
    long getCacheSize(Context context);

    /**
     * 清除图片缓存
     */
    void clear(Context context);

}
