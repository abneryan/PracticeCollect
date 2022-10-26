package com.anber.animation

import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/10/26 17:01
 * @Description:
 */
private var provinceList = listOf(
    "北京市",
    "天津市",
    "上海市",
    "重庆市",
    "河北省",
    "河南省",
    "云南省",
    "辽宁省",
    "黑龙江省",
    "湖南省",
    "安徽省",
    "山东省",
    "新疆维吾尔",
    "江苏省",
    "浙江省",
    "江西省",
    "湖北省",
    "广西壮族",
    "甘肃省",
    "山西省",
    "内蒙古",
    "陕西省",
    "吉林省",
    "福建省",
    "贵州省",
    "广东省",
    "青海省",
    "西藏",
    "四川省",
    "宁夏回族",
    "海南省",
    "台湾省",
    "香港特别行政区",
    "澳门特别行政区"


)

class ProvinceView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var province = "北京"
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.textSize = 20.dp
        paint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawText(province, width / 2f, height / 2f, paint)
    }

    class ProvinceTypeEvaluator : TypeEvaluator<String> {
        override fun evaluate(p0: Float, p1: String?, p2: String?): String {
            var startIndex = provinceList.indexOf(p1)
            var endIndex = provinceList.indexOf(p2)
            var curentIndex = startIndex + (endIndex - startIndex) * p0
            return provinceList.get(curentIndex.toInt())
        }

    }
}