package com.android.androidplugindemo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.morgoo.droidplugin.pm.PluginManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private String apkPath= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator +"yaoyiyao_plugin.apk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void doClick(View view) {
        switch (view.getId()){
            case R.id.btn_test:
                //启动插件，插件下载好了，在内存卡里
//                Intent intent=new Intent();
//                intent.setClassName(getPackageName(),"com.android.yaoyiyao_plugin.MainActivity");
////                this.startActivity(new Intent(this,TestActivity.class));
//                intent.putExtra("name","liuy");
//                startActivity(intent);

                // 一定要这样
//                PackageManager pm =  getPackageManager();
//                // 有了apk路径是可以获取apk的包名
//                PackageInfo info = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
//                String packageName = info.packageName;
//                Log.i("info","pacageeName="+packageName);
//                Intent intent = pm.getLaunchIntentForPackage(packageName);
//                Log.i("info","intent="+intent);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("name","liuy");
//                startActivity(intent);


                //360

                PackageManager pm=getPackageManager();
                PackageInfo info = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
                String packageName = info.packageName;
                Intent intent=pm.getLaunchIntentForPackage(packageName);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name","liuy");
                startActivity(intent);
                break;
            case R.id.btn_install:
//                PluginManager.install(MainActivity.this,apkPath);

                //360插件
                try {
                    int result=PluginManager.getInstance().installPackage(apkPath,0);
                    Log.e("TAG","result="+result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btn_unInstall:
                try {
                    PluginManager.getInstance().deletePackage(apkPath,0);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
}
