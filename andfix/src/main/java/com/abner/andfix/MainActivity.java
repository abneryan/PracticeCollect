package com.abner.andfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.abner.utils.Utils;

import java.io.File;


//    乐视：/storage/emulated/0/Android/data/com.abner.andfix/cache/apatch
//         /storage/emulated/0/apatch/apatch.apatch
public class MainActivity extends AppCompatActivity {
    private static final String FILE_END = ".apatch";
    private String mPatchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        File file = new File(mPatchDir);
        if(file == null || !file.exists()){
            file.mkdir();
        }
        //产生bug
        findViewById(R.id.creatbug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.printLog();
            }
        });
        //修复bug
        findViewById(R.id.fixbug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("abner",getPatchName());
                AndFixPatchManager.getInstance().addPatch(getPatchName());
            }
        });

    }

    /**
     * 构建patch文件名
     * @return
     */
    private String getPatchName() {
        return mPatchDir.concat("1").concat(FILE_END);
    }
}