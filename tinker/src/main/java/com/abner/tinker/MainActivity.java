package com.abner.tinker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_END = ".apk";
    private String mPatchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        File file = new File(mPatchDir);
        if(file ==null || !file.exists()){
            file.mkdir();
        }

        findViewById(R.id.loadpatch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPatch();
            }
        });
    }

    private void loadPatch() {
        TinkManager.getInstance().loadPath(getPatchName());
    }

    private String getPatchName() {
        return mPatchDir.concat("tinker").concat(FILE_END);
    }
}
