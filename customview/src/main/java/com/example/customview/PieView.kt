package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/9/21 10:47
 * @Description: 饼状图
 */
private var RADIUS = 150f.dp
private var OFFSET_LENGHT = 10f.dp

class PieView constructor(context: Context, attributeSet: AttributeSet?) :
    View(context, attributeSet) {
    var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var radiansList = floatArrayOf(60f, 120f, 30f, 60f, 90f)
    var colorList = listOf(
        Color.parseColor("#ffcc00"),
        Color.parseColor("#ccff00"),
        Color.parseColor("#99ffcc"),
        Color.parseColor("#66ccff"),
        Color.parseColor("#A020F0")
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //用于记录累计旋转角度
        var startAngle = 0f
        for ((index, value) in radiansList.withIndex()) {
            //将第二部分平移
            if (index == 2) {
                canvas?.save()
                canvas?.translate(
                    OFFSET_LENGHT * Math.cos(Math.toRadians((startAngle + value / 2).toDouble()))
                        .toFloat(),
                    OFFSET_LENGHT * Math.sin(Math.toRadians((startAngle + value / 2).toDouble()))
                        .toFloat()
                )
            }
            //设置圆饼颜色
            mPaint.color = colorList[index]
            //画弧形
            canvas?.drawArc(
                width / 2 - RADIUS,
                height / 2 - RADIUS,
                width / 2 + RADIUS,
                height / 2 + RADIUS,
                startAngle,
                value,
                true,
                mPaint
            )
            //累加滑过的总弧度
            startAngle += value
            //恢复第2部分画布
            if (index == 2) {
                canvas?.restore()
            }
        }
    }
}