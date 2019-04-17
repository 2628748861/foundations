package com.plugin.foundation.library.downloader;
import java.io.File;

public interface IDownLoad
{
     void downloadFile(String url,File saveFile,DownLoadListener listener);
}
