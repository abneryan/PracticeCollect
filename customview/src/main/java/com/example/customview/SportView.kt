package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/9/22 10:37
 * @Description: 运动进度圆环；字体居中显示；左，上贴边显示
 */
private var RADIUS = 150.dp
private var WIDTH = 10.dp
private var CIRCLE_COLOR = Color.parseColor("#C0FF3E")
private var ARC_COLOR = Color.parseColor("#CD0000")

class SportView constructor(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = WIDTH
        textAlign = Paint.Align.CENTER
        textSize = 70.dp
    }
    var fontMetrics: Paint.FontMetrics = Paint.FontMetrics()
    var bounds: Rect = Rect()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = CIRCLE_COLOR;
        canvas?.drawCircle(width / 2f, height / 2f, RADIUS, paint)

        paint.color = ARC_COLOR;
        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawArc(
            width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS,
            -90f,
            240f,
            false,
            paint
        )
        paint.style = Paint.Style.FILL
        //1：----------从方法适用于动态修改文字，保持文字主体部分/核心区域居中显示  fontMetrics
        /* paint.getFontMetrics(fontMetrics)
         canvas?.drawText(
             "abcd",
             width / 2f,
             height / 2f - (fontMetrics.ascent + fontMetrics.descent)/2,
             paint
         )*/
        //1 end：----------从方法适用于动态修改文字，保持文字主体部分/核心区域居中显示

        //2：----------从方法适用于静态态修改文字  bounds：文字显示区域的范围
        /* paint.getTextBounds("abcd",0,"abcd".length,bounds)
         canvas?.drawText(
             "abcd",
             width / 2f,
             height / 2f - (bounds.top + bounds.bottom)/2,
             paint
         )*/
        //2 end：----------从方法适用于静态态修改文字  bounds：文字显示区域的范围

        //3：----------文字向上贴边 适用阅读型
        /* paint.textAlign = Paint.Align.LEFT
         paint.getFontMetrics(fontMetrics)
         Log.d("SportView", fontMetrics.top.toString())
         canvas?.drawText("efgh",0f,0f-fontMetrics.top,paint)*/
        //3 end----------文字向上贴边 适用阅读型

        //4：----------文字向上贴边 适用固定观赏型
       /* paint.textSize = 150.dp
        paint.textAlign = Paint.Align.LEFT
        paint.getTextBounds("efgh", 0, "efgh".length, bounds)
        Log.d("SportView", fontMetrics.top.toString())
        canvas?.drawText("efgh", 0f, 0f - bounds.top, paint)*/
        //4 end----------文字向上贴边 适用固定观赏型

        //5：----------文字向上贴边 适用固定观赏型
        paint.textSize = 15.dp
        paint.textAlign = Paint.Align.LEFT
        paint.getTextBounds("efgh", 0, "efgh".length, bounds)
        canvas?.drawText("efgh", 0f, 0f - bounds.top, paint)
        //5 end----------文字向上贴边 适用固定观赏型

        //6：----------文字向左贴边 适用固定观赏型
        paint.textSize = 150.dp
        paint.textAlign = Paint.Align.LEFT
        paint.getTextBounds("efgh", 0, "efgh".length, bounds)
        canvas?.drawText("efgh", 0f-bounds.left, 0f - bounds.top, paint)
        //6 end----------文字向左贴边 适用固定观赏型
    }
}