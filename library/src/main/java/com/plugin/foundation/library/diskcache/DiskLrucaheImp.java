package com.plugin.foundation.library.diskcache;
import com.jakewharton.disklrucache.DiskLruCache;
import com.plugin.foundation.library.util.FileUtils;
import com.plugin.foundation.library.util.Md5Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * DiskLrucahe的实现
 */
public class DiskLrucaheImp implements IDiskCache {
    private DiskLruCache diskLruCache;
    private File saveDirectory;
    public DiskLrucaheImp(File saveDirectory,int MAX_SIZE)
    {
        try {
            this.saveDirectory=saveDirectory;
            diskLruCache=DiskLruCache.open(saveDirectory,1,1,MAX_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public  File get(String key) {
        try {
            key=Md5Util.hashKeyForDisk(key);
            DiskLruCache.Snapshot snapshot=diskLruCache.get(key);
            if(snapshot==null)return null;
            else
            {
                return new File(saveDirectory,key+".0");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public  void set(String key, File source) {
        try {
            if(source==null||!source.exists())return;
            set(key, new FileInputStream(source));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  void set(String key, InputStream inputStream) {
        try {
            key=Md5Util.hashKeyForDisk(key);
            DiskLruCache.Editor editor= diskLruCache.edit(key);
            if(editor!=null&&inputStream!=null)
            {
                FileUtils.copyStream(inputStream,editor.newOutputStream(0));
                editor.commit();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public File getCacheDirectory() {
        return saveDirectory;
    }
}
