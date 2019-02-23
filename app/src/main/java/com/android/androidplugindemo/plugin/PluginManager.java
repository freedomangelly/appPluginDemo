package com.android.androidplugindemo.plugin;

import android.content.Context;

/**
 * @author Created by freed
 * Created by freed on 2019/2/21.
 * Date:2019/2/21
 * @description
 */
public class PluginManager {

    public static final void install (Context context,String apkPath){
        //解决类加载的问题
        try {
            FixDexManager fixDexManager=new FixDexManager(context);
            //把apk的class加载到applicationClassLoader
            fixDexManager.fixDex(apkPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
