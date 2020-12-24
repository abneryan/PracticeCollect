package com.example.customview.xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.customview.R
import com.example.customview.px

private val IMAGE_WIDTH = 200f.px
private val IMAGE_PADDING = 20f.px
class AvatarView(context: Context?, attrs: AttributeSet?)
    : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()),IMAGE_PADDING,IMAGE_PADDING ,paint )
    }

    fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options();
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.no_network_status, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.no_network_status, options)
    }
}
