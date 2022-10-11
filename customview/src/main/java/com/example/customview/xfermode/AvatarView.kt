package com.example.customview.xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.customview.R
import com.example.customview.dp

private val IMAGE_WIDTH = 80f.dp
private val IMAGE_PADDING = 20f.dp

class AvatarView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    var rectf: RectF = RectF(
        IMAGE_PADDING,
        IMAGE_PADDING,
        IMAGE_WIDTH + IMAGE_PADDING,
        IMAGE_WIDTH + IMAGE_PADDING
    )

    override fun onDraw(canvas: Canvas) {
        //开启离屏渲染
        val saveLayer = canvas.saveLayer(rectf, paint)
        canvas.drawOval(
            IMAGE_PADDING,
            IMAGE_PADDING,
            IMAGE_WIDTH + IMAGE_PADDING,
            IMAGE_WIDTH + IMAGE_PADDING,
            paint
        )
        paint.xfermode = xfermode
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()), IMAGE_PADDING, IMAGE_PADDING, paint)
        //恢复离屏渲染
        canvas.restoreToCount(saveLayer)
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
