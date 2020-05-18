package com.abner.andfix;

import android.content.Context;

import com.abner.utils.Utils;
import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

public class AndFixPatchManager {
    private static AndFixPatchManager mInstance;
    private static PatchManager mPatchManager;

    private AndFixPatchManager(){};

    public static AndFixPatchManager getInstance(){
        if(mInstance == null){
            synchronized (AndFixPatchManager.class){
                if(mInstance == null){
                    mInstance = new AndFixPatchManager();
                }
            }
        }
        return mInstance;
    }
    public void initPatch(Context context){
        mPatchManager = new PatchManager(context);
        mPatchManager.init(Utils.getVersionName(context));
        mPatchManager.loadPatch();
    }

    public void addPatch(String path){
        try {
            if(mPatchManager!= null){
                mPatchManager.addPatch(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
