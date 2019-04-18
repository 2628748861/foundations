package com.plugin.foundation.library.diskcache;

import java.io.File;
import java.io.InputStream;

/**
 * 文件缓存接口
 */
public interface IDiskCache {
    /**根据key获取文件
     * @param key
     * @return
     */
    File get(String key);

    /**存储文件(针对文件)
     * @param key 文件存储时对应的key
     * @param source 要存储的文件
     */
    void set(String key,File source);

    /**存储文件(针对输入流)
     * @param key 文件存储时对应的key
     * @param inputStream 要存储的输入流
     */
    void set(String key,InputStream inputStream);

    /**获取缓存路径
     * @return
     */
    File getCacheDirectory();
}
