package com.plugin.foundation.library.util;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

public class SdcardUtils {
    /**判断sdcard是否挂载
     * @return
     */
    public static boolean existSDCard() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    /**sdcard可用大小
     * @return
     */
    public static long getSDFreeSize(){
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long freeBlocks = sf.getAvailableBlocks();
        return (freeBlocks * blockSize)/1024 /1024; //单位MB
    }

    /**sdcard总大小
     * @return
     */
    public static long getSDAllSize(){
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long allBlocks = sf.getBlockCount();
        return (allBlocks * blockSize)/1024/1024; //单位MB
    }

}
