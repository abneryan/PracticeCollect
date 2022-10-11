package com.example.customview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/9/22 18:22
 * @Description:
 */
private var IMAGE_WIDTH = 160.dp
private var IMAGE_PADDING = 40.dp

class MultilineTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var text ="Proin leo justo, ornare vitae augue ut, consectetur fermentum dui. Vestibulum sed libero pharetra, euismod odio ut, consectetur nunc. Vivamus eleifend mauris ac ullamcorper ultricies. Cras non elit nibh. Suspendisse eu fermentum sapien. Curabitur convallis nunc id nibh dignissim euismod ac eu nisl. Proin ornare, lorem at tincidunt rutrum, tellus lectus posuere nisl, sed cursus urna orci eget nulla. Praesent sed tristique diam. Fusce malesuada tincidunt erat, non convallis nunc tincidunt vel. Etiam id fringilla lacus, id pulvinar diam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec sit amet mi sit amet libero blandit rhoncus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla nec dui ac lectus gravida sagittis"
    var textPaint: TextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 20.dp
    }
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 20.dp
    }
    var fontMetrics = Paint.FontMetrics()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        var staticLayout = StaticLayout(text,
//            textPaint,width,Layout.Alignment.ALIGN_NORMAL,1f,0f,true)
//        staticLayout.draw(canvas)
        canvas?.drawBitmap(
            getAvatar(IMAGE_WIDTH.toInt()), width - IMAGE_WIDTH - IMAGE_PADDING,
            IMAGE_PADDING, paint
        )
        paint.getFontMetrics(fontMetrics)
        var measuredWidth = floatArrayOf(0f)
        var count: Int
        var start = 0
        var maxWidth: Float
        var verticalOffset = -fontMetrics.top

        while (start < text.length) {
            //文字在图片的上面或者在图片的下边
            if (verticalOffset + fontMetrics.bottom < IMAGE_PADDING ||
                verticalOffset + fontMetrics.top > IMAGE_PADDING + IMAGE_WIDTH) {
                maxWidth = width.toFloat()
            } else { //文字在图片顶底部之间
                maxWidth = width - IMAGE_WIDTH - IMAGE_PADDING
            }
            count = paint.breakText(text, start, text.length, true, maxWidth, measuredWidth)
            canvas?.drawText(
                text,
                start,
                start + count,
                0f,
                verticalOffset,
                paint
            )
            start += count
            verticalOffset += paint.fontSpacing
        }

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