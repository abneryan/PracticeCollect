package com.example.customview

import android.content.res.Resources
import android.util.TypedValue

/**
 * @Auther: yanguoqing
 * @Date: 2022/9/20 11:20
 * @Description:
 */
object Utils {
    fun dp2px(value: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            value,
            Resources.getSystem().displayMetrics
        )
    }
    fun px2dp(value: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_PX,
            value,
            Resources.getSystem().displayMetrics
        )
    }
}