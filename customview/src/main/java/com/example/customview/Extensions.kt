package com.example.customview

import android.content.res.Resources
import android.util.TypedValue

/**
 * @Auther: yanguoqing
 * @Date: 2020/12/24 09:36
 * @Description: 扩展属性
 */
val Float.px
get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
)