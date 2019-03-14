package com.plugin.foundation.library.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by cample on 2017/8/10.
 */

public class DensityUtils {
    /**将dp转换为px
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context, int dp)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }

    /**将px转换为dp
     * @param context
     * @param px
     * @return
     */
    public static int px2dp(Context context, float px)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(px / scale);
    }

    /**
     * px转sp
     *
     * @param
     * @param
     * @return
     */
    public static float px2sp(Context context, float px)
    {
        return (px / context.getResources().getDisplayMetrics().scaledDensity);
    }

    /**
     * sp转px
     *
     * @param
     * @param
     * @return
     */
    public static float sp2px(Context context, float sp)
    {
        return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, context.getResources().getDisplayMetrics());
    }
}
