package com.abner.practicecollect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.abner.practicecollect.EventDispatche.EventDispatchMainActivity;
import com.abner.practicecollect.handler.HandlerActivity;
import com.abner.practicecollect.jni.JNIActivity;
import com.abner.practicecollect.launchMode.LaunchModeMainActivity;
import com.abner.practicecollect.recyclerView.RecyclerViewActivity;
import com.abner.practicecollect.service.client.ClientActivity;
import com.abner.practicecollect.slidingConflict.MainSlidingConflictActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {
    private final static String TAG= "MainActivity";
    private RecyclerView mRecyclerView;
    private static Activity activity;
    private String[] mTitles = new String[]{"Handler","Service","IPC","事件分发机制",
                                            "JNI","滑动冲突","启动模式","动画","RecyclerView"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG,"onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.d(TAG,"onRestoreInstanceState");
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.main_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter mainAdapter = new MainAdapter(Arrays.asList(mTitles));
        mainAdapter.setListener(this);
        mRecyclerView.setAdapter(mainAdapter);

    }

    @Override
    public void onItemClick(View view, int pisition) {
        switch (pisition){
            case 0://Handler
                Intent handlerIntent = new Intent(getBaseContext(), HandlerActivity.class);
                startActivity(handlerIntent);
                break;
            case 1://Service
                Intent intent = new Intent(getBaseContext(), ClientActivity.class);
                startActivity(intent);
                break;
            case 2://IPC

                break;
            case 3://事件分发机制
                Intent eventDispatchIntent = new Intent(getBaseContext(), EventDispatchMainActivity.class);
                startActivity(eventDispatchIntent);

                break;
            case 4://JNI
                Intent jniIntent = new Intent(getBaseContext(), JNIActivity.class);
                startActivity(jniIntent);
                break;
            case 5://滑动冲突
                Intent conflictIntent = new Intent(getBaseContext(), MainSlidingConflictActivity.class);
                startActivity(conflictIntent);
                break;
            case 6://启动模式
                Intent launchMode = new Intent(getBaseContext(), LaunchModeMainActivity.class);
                startActivity(launchMode);
                break;
            case 7://RecyclerView
                Intent recycerViewIntent = new Intent(getBaseContext(), RecyclerViewActivity.class);
                startActivity(recycerViewIntent);
                break;

            default:
        }
    }
}