package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/9/21 10:47
 * @Description:
 */
// 开口角度
private val OPEN_ANGLE = 120f
//刻度宽
private val DASH_WIDTH = 2f.dp
//刻度长
private val DASH_HEIGHT = 6f.dp
//弧形半径
private var RADIUS = 150f.dp
//指针长度
private var POINTER_RADIUS = 140f.dp

class DashboardView constructor(context: Context, attributeSet: AttributeSet?) :
    View(context, attributeSet) {
    var mPath: Path = Path()
    var mDashPath: Path = Path()
    var mPaint: Paint
    lateinit var pathEffect: PathDashPathEffect

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.strokeWidth = 3f.dp
        mPaint.style = Paint.Style.STROKE
        //初始化刻度path
        mDashPath.addRect(0f, 0f, DASH_WIDTH, DASH_HEIGHT, Path.Direction.CCW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        //外层圆弧path
        mPath.addArc(
            width / 2 - RADIUS,
            height / 2 - RADIUS,
            width / 2 + RADIUS,
            height / 2 + 150f.dp,
            90 + OPEN_ANGLE / 2,
            360 - OPEN_ANGLE
        )
        //测量外圆弧长度类
        val pathMeasure = PathMeasure(mPath, false)
        //虚线刻度辅助类，用于实现刻度
        pathEffect = PathDashPathEffect(
            mDashPath,
            (pathMeasure.length - DASH_WIDTH) / 20,
            0f,
            PathDashPathEffect.Style.ROTATE
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //画弧线
        canvas?.drawPath(mPath, mPaint)

        //画刻度
        mPaint.pathEffect = pathEffect;
        canvas?.drawPath(mPath, mPaint)
        mPaint.pathEffect = null

        //将指针画到指定位置
        mPaint.setColor(Color.RED)
        canvas?.drawLine(
            width / 2f, height / 2f,
            width / 2f + POINTER_RADIUS * Math.cos(mark2Radians(6))
                .toFloat(),
            height / 2f + POINTER_RADIUS * Math.sin(mark2Radians(6))
                .toFloat(),
            mPaint
        )
    }

    private fun mark2Radians(value: Int) =
        Math.toRadians(90 + OPEN_ANGLE / 2 + (360 - OPEN_ANGLE) / 20 * value.toDouble())

}