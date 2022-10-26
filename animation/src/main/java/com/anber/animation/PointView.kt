package com.anber.animation

import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/10/26 15:23
 * @Description:
 */
class PointView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var point = PointF(0f, 0f)
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.strokeWidth =20.dp
        paint.strokeCap = Paint.Cap.ROUND
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPoint(point.x, point.y, paint)
    }
    class PointTypeEvaluator:TypeEvaluator<PointF>{
        override fun evaluate(p0: Float, p1: PointF, p2: PointF): PointF {
            var startX = p1.x
            var endX = p2.x
            var currentX = startX + (endX -startX)* p0
            var startY = p1.y
            var endY = p2.y
            var currentY = startY + (endY -startY)* p0
            return PointF(currentX,currentY)
        }

    }
}