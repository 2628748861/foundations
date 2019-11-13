package com.plugin.foundation.library.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import java.io.ByteArrayOutputStream;

/**
 * @ClassName
 * @Description
 * @Author Xiaoborui
 * @Date 2017/4/18 16:58
 */

public class DrawableUtils {
    /**
     *
     * @param shape 形状
     * @param color 颜色
     * @param corner 圆角
     * @param strokeSize 边框大小
     * @param strokeColor 边框颜色
     * @param width 宽
     * @param height 高
     * @param alpha 透明度
     * @return
     */
    public static GradientDrawable getShape(int shape, @ColorInt int color, float corner, int strokeSize, @ColorInt int strokeColor, int width, int height, @FloatRange(from=0.0D, to=1.0D)float alpha){
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(adjustAlpha(color,alpha));
        bg.setShape(shape);
        if(corner > 0)
            bg.setCornerRadius(corner);
        if(strokeSize > 0)
            bg.setStroke(strokeSize,strokeColor);

        if(width > 0 && height > 0)
            bg.setSize(width,height);

        return bg;
    }

    /**
     * @param shape
     * @param color
     * @return
     */
    public static GradientDrawable getShape(int shape, @ColorInt int color){
        return getShape(shape,color,0,0,0,0,0,1f);
    }

    /**
     * @param corner
     * @param stroke
     * @param color
     * @return
     */
    public static GradientDrawable getCornerWithStroke(float corner, int stroke, @ColorInt int color, @ColorInt int strokeColor){
        return getShape(GradientDrawable.RECTANGLE,color,corner,stroke,strokeColor,0,0,1f);
    }

    /**
     * @param corner
     * @param color
     * @return
     */
    public static GradientDrawable getCorner(float corner, @ColorInt int color){
        return getShape(GradientDrawable.RECTANGLE,color,corner,0,0,0,0,1f);
    }


    /**
     * 5.0以上水波纹效果
     * 5.0以下普通按压效果
     * @param defaultColor
     * @param effectColor
     * @return
     */
    public static Drawable getCompactPressDrawable(@ColorInt int defaultColor, @ColorInt int effectColor){
        GradientDrawable defaultDrawable = new GradientDrawable();
        defaultDrawable.setColor(defaultColor);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            GradientDrawable contentDrawable = new GradientDrawable();
            contentDrawable.setColor(defaultColor);
            return new RippleDrawable(ColorStateList.valueOf(effectColor), contentDrawable, null);
        } else {
            return getPressDrawable(effectColor, defaultColor);
        }
    }

    /**
     * 普通按下效果
     * @param effectColor
     * @param defaultColor
     * @return
     */
    public static Drawable getPressDrawable(@ColorInt int effectColor, @ColorInt int defaultColor) {
        return getPressDrawable(-1,effectColor,defaultColor);
    }

    /**
     * 普通按下效果
     * @return
     */
    public static Drawable getPressDrawable(Drawable effectDrawable, Drawable defaultDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed},effectDrawable);
        stateListDrawable.addState(new int[]{}, defaultDrawable);
        return stateListDrawable;
    }

    /**
     * 普通按下效果
     * @param effectColor
     * @param defaultColor
     * @return
     */
    public static Drawable getPressDrawable(int corner, @ColorInt int effectColor, @ColorInt int defaultColor) {
        GradientDrawable effectDrawable = new GradientDrawable();
        effectDrawable.setColor(effectColor);
        GradientDrawable defaultDrawable = new GradientDrawable();
        defaultDrawable.setColor(defaultColor);
        if(corner > 0){
            effectDrawable.setCornerRadius(corner);
            defaultDrawable.setCornerRadius(corner);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed},effectDrawable);
        stateListDrawable.addState(new int[]{}, defaultDrawable);
        return stateListDrawable;
    }

    /**
     * 普通按下效果
     * @return
     */
    public static Drawable getSelectDrawable(Drawable effectDrawable, Drawable defaultDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected},effectDrawable);
        stateListDrawable.addState(new int[]{}, defaultDrawable);
        return stateListDrawable;
    }

    /**
     * 选中的效果
     * @param effectColor
     * @param defaultColor
     * @return
     */
    public static Drawable getSelectDrawable(@ColorInt int effectColor, @ColorInt int defaultColor){
        GradientDrawable effectDrawable = new GradientDrawable();
        effectDrawable.setColor(effectColor);
        GradientDrawable defaultDrawable = new GradientDrawable();
        defaultDrawable.setColor(defaultColor);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected},effectDrawable);
        stateListDrawable.addState(new int[]{}, defaultDrawable);
        return stateListDrawable;
    }

    /**
     * 调整颜色透明度
     * @param paramInt
     * @param paramFloat
     * @return
     */
    @ColorInt
    public static int adjustAlpha(@ColorInt int paramInt, @FloatRange(from=0.0D, to=1.0D) float paramFloat) {
        return Color.argb(Math.round(Color.alpha(paramInt) * paramFloat), Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
    }

    @ColorInt
    public static int getColor(Context context,@ColorRes int colorRes){
        return ContextCompat.getColor(context, colorRes);
    }


    public static Drawable getDrawable(Context context,@DrawableRes int drawableRes){
        return ContextCompat.getDrawable(context, drawableRes);
    }

    /**
     *  Bitmap转换成byte[]
     */
    public static byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    /**
     * drawable转bitmap
     * @param drawable
     * @return
     */
    public static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap
                .createBitmap(
                        drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight(),
                        drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 为drawable着色
     * @param oriDrawable
     * @param color
     * @return
     */
    public static Drawable TintDrawable(Drawable oriDrawable, @ColorInt int color, @FloatRange(from=0.0D, to=1.0D) float alpha){
        final Drawable wrappedDrawable = DrawableCompat.wrap(oriDrawable.mutate());
        DrawableCompat.setTintList(wrappedDrawable, ColorStateList.valueOf(adjustAlpha(color,alpha)));
        return wrappedDrawable;
    }

}
