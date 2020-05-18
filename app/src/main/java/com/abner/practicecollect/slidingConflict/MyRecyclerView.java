package com.abner.practicecollect.slidingConflict;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 内部拦截法
 */
public class MyRecyclerView extends RecyclerView {
    private int lastY;
    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(getClass().getSimpleName(),"computeVerticalScrollOffset:" +computeVerticalScrollOffset());
        if(ev.getAction() == MotionEvent.ACTION_DOWN){
            requestDisallowInterceptTouchEvent(true);
        } else if(ev.getAction() == MotionEvent.ACTION_MOVE){
            if(lastY > ev.getY()){//列表向上滑，加载更多查看底部数据
                if(!canScrollVertically(1)){ //滑到了底部
                    requestDisallowInterceptTouchEvent(false);
                }
            } else if(lastY < ev.getY()){//列表向下滑，查看顶部数据
                if(!canScrollVertically(-1)){ //滑到了顶部
                    requestDisallowInterceptTouchEvent(false);
                }
            }
        }
        lastY = (int)ev.getY();
        return super.dispatchTouchEvent(ev);
    }
}
