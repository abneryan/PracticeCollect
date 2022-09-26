package com.example.customview

import android.content.res.Resources
import android.util.TypedValue

/**
 * @Auther: yanguoqing
 * @Date: 2020/12/24 09:36
 * @Description: 扩展属性
 */
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )
val Int.dp
    get() = this.toFloat().dp


/**
 * Kotlin的扩展函数可以让你作为一个类成员进行调用的函数，但是是定义在这个类的外部。这样可以很方便的扩展一个已经存在的类，为它添加额外的方法
 * 扩展方法
 */
fun String.lastChar(): Char = this.get(this.length - 1)