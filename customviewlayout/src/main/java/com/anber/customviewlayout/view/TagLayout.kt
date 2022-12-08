package com.anber.customviewlayout.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children

/**
 * @Auther: yanguoqing
 * @Date: 2022/11/24 19:02
 * @Description:
 */
class TagLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        for (child in children){

        }
    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for (child in children) {
            if(children.indexOf(child) == 0){
                child.layout(0, 0, (r - l)/2, (b - t)/2)
            }else{
                child.layout((r-l)/2, (b-t)/2, r - l, b - t)
            }
        }
    }
}