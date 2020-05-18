package com.abner;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.abner.aidl.IMyAidlInterface;

public class CalculateService extends Service {
    private final static String TAG = "CalculateService";

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        //IBinder mBinder = new MyBinder();
        System.out.println("YGQ--1" +mBinder);
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
    IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub(){


        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int a, int b) throws RemoteException {
            Log.d(TAG, "IMyAidlInterface---add");
            return a+b;
        }
    };
 /*   public class MyBinder extends Binder{
        public int add(int a, int b){
            Log.d(TAG, "Binder---add");
            return a+b;
        }
    }*/
}
