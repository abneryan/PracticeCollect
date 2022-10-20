package com.example.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @Auther: yanguoqing
 * @Date: 2022/9/23 18:20
 * @Description: 范围裁切，几何变换
 */
private val IMAGE_SIZE = 200.dp
private val IMAGE_PADDING = 100.dp

class CameraView1(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap = getAvatar(IMAGE_SIZE.toInt())
    //存在一个虚拟的三维坐标系
    private var camera = Camera();

    init {
        //沿X轴翻转
        camera.rotateX(30f)
        //设置camera位置
        camera.setLocation(0f, 0f, -7 * resources.displayMetrics.density) //第三个参数做动态适配
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //反着思考正常思考
//        canvas?.translate(IMAGE_PADDING + IMAGE_SIZE / 2, IMAGE_PADDING + IMAGE_SIZE / 2)
//        camera.applyToCanvas(canvas)
//        canvas?.translate(-IMAGE_PADDING - IMAGE_SIZE / 2, -IMAGE_PADDING - IMAGE_SIZE / 2)
//        canvas?.drawBitmap(bitmap, IMAGE_PADDING, IMAGE_PADDING, paint)

        //实现折纸效果
        //2,上半部分
        canvas?.save()
        canvas?.translate(IMAGE_PADDING + IMAGE_SIZE / 2, IMAGE_PADDING + IMAGE_SIZE / 2)
        canvas?.rotate(-30f)
        canvas?.clipRect(-IMAGE_SIZE, -IMAGE_SIZE,IMAGE_SIZE ,0f)
        canvas?.rotate(30f)
        canvas?.translate(-IMAGE_PADDING - IMAGE_SIZE / 2, -IMAGE_PADDING - IMAGE_SIZE / 2)
        canvas?.drawBitmap(bitmap, IMAGE_PADDING, IMAGE_PADDING, paint)
        canvas?.restore()
        //1,下半部分
        canvas?.translate(IMAGE_PADDING + IMAGE_SIZE / 2, IMAGE_PADDING + IMAGE_SIZE / 2)
        canvas?.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas?.clipRect(-IMAGE_SIZE, 0f,IMAGE_SIZE,IMAGE_SIZE )
        canvas?.rotate(30f)
        canvas?.translate(-IMAGE_PADDING - IMAGE_SIZE / 2, -IMAGE_PADDING - IMAGE_SIZE / 2)
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