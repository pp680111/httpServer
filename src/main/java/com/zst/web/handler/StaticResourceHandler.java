package com.zst.web.handler;

import com.google.inject.Singleton;

import java.io.File;

/**
 * 用于读取静态资源文件
 */
@Singleton
public class StaticResourceHandler {
    private static String baseResourcePathPrefix;

    public StaticResourceHandler(){
        baseResourcePathPrefix = "/web/";
    }


    public File getFile(String filePath){
        String uri = StaticResourceHandler.class.getResource(baseResourcePathPrefix + filePath).getFile();
        return new File(uri);
    }
}
