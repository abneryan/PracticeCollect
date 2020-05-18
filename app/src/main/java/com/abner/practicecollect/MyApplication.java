package com.abner.practicecollect;

import android.app.Application;
import android.content.Intent;

import com.abner.practicecollect.launchMode.Acitivity1;
import com.abner.practicecollect.launchMode.Activity2;
import com.abner.practicecollect.launchMode.LaunchModeMainActivity;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        Intent intent = new Intent(this, Activity2.class);
//        startActivity(intent);
    }
}
