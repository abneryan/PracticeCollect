package com.anber.customviewlayout.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.anber.customviewlayout.dp

/**
 * @Auther: yanguoqing
 * @Date: 2022/11/24 16:13
 * @Description:
 */
private val RADIUS = 100.dp;
private val PADDING = 100.dp;
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        /*val size = ((PADDING + RADIUS) * 2).toInt()
        var mode = MeasureSpec.getMode(widthMeasureSpec)
        var specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        var width = when(mode){
            MeasureSpec.EXACTLY -> specWidthSize
            MeasureSpec.AT_MOST -> if(size > specWidthSize) specWidthSize else size
            else ->size
        }*/
        val size = ((PADDING + RADIUS) * 2).toInt()
        var width = resolveSize(size,widthMeasureSpec)
        var height = resolveSize(size,heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(PADDING + RADIUS,PADDING + RADIUS,RADIUS,paint )
    }

}