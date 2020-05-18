package com.abner;

import android.app.Application;

import com.abner.andfix.AndFixPatchManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //完成andFix模块的初始化
        initAndFix();
    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initPatch(this);
    }
}
