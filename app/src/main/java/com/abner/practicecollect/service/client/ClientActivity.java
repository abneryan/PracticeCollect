package com.abner.practicecollect.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.abner.aidl.IMyAidlInterface;
import com.abner.practicecollect.R;

import java.util.LinkedHashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ClientActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ClientActivity";
    private IMyAidlInterface myAidlInterface;
    private boolean mShouldUnbind;
    private ServiceConnection serviceConnection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "client onServiceConnected");
            System.out.println("YGQ--1" +iBinder);
            myAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            System.out.println("YGQ--1" +iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "client onServiceDisconnected");
            myAidlInterface = null;
        }
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.d(TAG,"YGQ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        initView();
        handler.sendEmptyMessageDelayed(0,1000*5);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(0, 0.75f, true);
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(6, 7);
        map.get(1);
        map.get(2);


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Log.d(TAG,entry.getKey() + ":" + entry.getValue());

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        doUnbindService();
    }

    private void initView() {
        findViewById(R.id.bindService).setOnClickListener(this);
        findViewById(R.id.unBindService).setOnClickListener(this);
        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.stopService).setOnClickListener(this);
        findViewById(R.id.add).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bindService:
                doBindService();
                break;
            case R.id.unBindService:
               doUnbindService();
                break;
            case R.id.startService:
                Intent startIntent = new Intent();
                startIntent.setComponent(new ComponentName("com.abner.serviceclient","com.abner.CalculateService"));
                startIntent.setPackage(getPackageName());
                startService(startIntent);
                break;
            case R.id.stopService:
                Intent stopIntent = new Intent();
                stopIntent.setAction("com.abner.serviceclient.calculate");
                stopIntent.setPackage(getPackageName());
                stopService(stopIntent);
                break;
            case R.id.add:
                if(myAidlInterface != null){
                    try {
                        int result = myAidlInterface.add(10, 8);
                        Toast.makeText(getBaseContext(),"10 + 8 = " + result, Toast.LENGTH_SHORT).show();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getBaseContext(),"服务器被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    void doBindService() {
        // Attempts to establish a connection with the service.  We use an
        // explicit class name because we want a specific service
        // implementation that we know will be running in our own process
        // (and thus won't be supporting component replacement by other
        // applications).
        Intent bindIntent = new Intent();
        bindIntent.setComponent(new ComponentName("com.abner.serviceclient","com.abner.CalculateService"));
        bindIntent.setPackage(getPackageName());
        if (bindService(bindIntent,
                serviceConnection, Context.BIND_AUTO_CREATE)) {
            mShouldUnbind = true;
        } else {
            Log.e("MY_APP_TAG", "Error: The requested service doesn't " +
                    "exist, or this client isn't allowed access to it.");
        }
    }

    void doUnbindService() {
        if (mShouldUnbind) {
            // Release information about the service's state.
            unbindService(serviceConnection);
            mShouldUnbind = false;
        }
    }
}
