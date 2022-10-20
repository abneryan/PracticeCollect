package com.anber.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/10/19 10:20
 * @Description:
 */
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint:Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var radio = 200.dp
        set(value) {
            field = value
            invalidate()
        }
    init {
        paint.color =Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(width/2f,height/2f,radio, paint)
    }
}