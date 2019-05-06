package com.plugin.foundation.library.image;

import android.content.Context;
import android.widget.ImageView;

import com.plugin.foundation.library.image.args.Args;

/**
 * @param <Transform> 转换器:用于图片的形状转变
 * @param <Transaction> 图像过渡:用于图像展现的过渡方式,例如:淡入淡出,渐变...
 * @param <Listener> 监听器:用于对图片加载进行监听
 */
public interface ImageLoaderAPI<Transform,Transaction,Listener> {

    /**加载普通图片
     * @param args
     * @param imageView
     */
    void display(Context context, Args<Transform,Transaction,Listener> args, ImageView imageView);

    /**加载Gif图片
     * @param context
     * @param args
     * @param imageView
     */
    void displayGif(Context context,Args args,ImageView imageView);

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
