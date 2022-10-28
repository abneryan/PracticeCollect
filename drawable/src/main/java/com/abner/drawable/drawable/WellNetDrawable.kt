package com.abner.drawable.drawable

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.view.PixelCopy
import com.abner.drawable.dp

/**
 * @Auther: yanguoqing
 * @Date: 2022/10/28 10:15
 * @Description: 自定义网格
 */
private val INTERVAL = 50.dp

class WellNetDrawable : Drawable() {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#F9A825")
        strokeWidth = 5.dp
    }

    override fun draw(canvas: Canvas) {
        //画竖线
        var x = bounds.left.toFloat()
        while (x < bounds.right) {
            canvas.drawLine(x, bounds.top.toFloat(), x, bounds.bottom.toFloat(), paint)
            x += INTERVAL
        }
        //画横线
        var y = bounds.top.toFloat()
        while (y < bounds.bottom) {
            canvas.drawLine(bounds.left.toFloat(), y,  bounds.right.toFloat(), y, paint)
            y += INTERVAL
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return when (paint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0XFF -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSPARENT
        }
    }
}