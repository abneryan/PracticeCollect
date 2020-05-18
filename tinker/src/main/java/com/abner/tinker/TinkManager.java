package com.abner.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;


public class TinkManager {
    private static boolean isInstalled;
    private static ApplicationLike mApplike;
    private static TinkManager mInstance;
    private TinkManager(){};
    public static TinkManager getInstance(){
        if(mInstance == null){
            synchronized (TinkManager.class){
                if(mInstance == null){
                    mInstance  =new TinkManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 完成tinker初始化
     * @param applicationLike
     */
    public void installTinker(ApplicationLike applicationLike){
        mApplike = applicationLike;
        if(isInstalled){
            return;
        }
        TinkerInstaller.install(mApplike);
        isInstalled = true;
    }

    /**
     * 完成Patch 文件的加载
     * @param patch
     */
    public void loadPath(String patch){
        if(Tinker.isTinkerInstalled()){
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),patch);
        }
    }

    /**
     * 获取ApplicationLike 获取Context
     * @return
     */
    private Context getApplicationContext(){
        if (mApplike != null) {
           return mApplike.getApplication().getApplicationContext();
        }
        return null;
    }
}
