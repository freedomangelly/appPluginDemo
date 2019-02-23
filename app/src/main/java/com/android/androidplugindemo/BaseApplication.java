package com.android.androidplugindemo;

import android.app.Application;
import android.content.Context;

import com.morgoo.droidplugin.PluginApplication;
import com.morgoo.droidplugin.PluginHelper;

/**
 * @author Created by freed
 * Created by freed on 2019/2/20.
 * Date:2019/2/20
 * @description
 */
public class BaseApplication extends PluginApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        PluginHelper.getInstance().applicationOnCreate(getBaseContext());
//        HookStartActivityUtil hookStartActivityUtil=new HookStartActivityUtil(this,ProxyActivity.class);
//        try {
//            hookStartActivityUtil.hookStartActivity();
//            hookStartActivityUtil.hookLaunchActivity();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        PluginHelper.getInstance().applicationAttachBaseContext(base);
        super.attachBaseContext(base);
    }
}
