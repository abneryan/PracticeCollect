package com.anber.customviewlayout.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.anber.customviewlayout.dp
import kotlin.math.min

/**
 * @Auther: yanguoqing
 * @Date: 2022/11/23 22:49
 * @Description:
 */
class SquareImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredHeight,measuredWidth)
        setMeasuredDimension(size,size)
    }
   /* override fun layout(l: Int, t: Int, r: Int, b: Int) {
        val width = r -l;
        val height = b -t;
        val size = min(width,height)
        super.layout(l, t, l+size, t+size)
    }*/
}