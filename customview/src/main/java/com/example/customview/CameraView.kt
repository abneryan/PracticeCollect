package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/9/23 18:20
 * @Description:
 */
private val IMAGE_SIZE = 200.dp
private val IMAGE_PADDING = 100.dp

class CameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap = getAvatar(IMAGE_SIZE.toInt())
    val clipPath = Path().apply {
        addOval(
            IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_SIZE, IMAGE_PADDING + IMAGE_SIZE,
            Path.Direction.CW
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // TODO: 切完之后会出现毛边
         canvas?.clipPath(clipPath)
        //TODO: 没有毛边
        canvas?.clipRect(IMAGE_PADDING, IMAGE_PADDING,IMAGE_PADDING + IMAGE_SIZE/2,IMAGE_PADDING + IMAGE_SIZE/2)
        canvas?.drawBitmap(bitmap, IMAGE_PADDING, IMAGE_PADDING, paint)
    }

    fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options();
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.ic_head, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.ic_head, options)
    }
}