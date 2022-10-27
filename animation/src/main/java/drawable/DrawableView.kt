package drawable

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.View
import com.anber.animation.dp

/**
 * @Auther: yanguoqing
 * @Date: 2022/10/27 11:23
 * @Description:
 */
class DrawableView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var drawable = ColorDrawable(Color.RED)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawable.setBounds(50.dp.toInt(),80.dp.toInt(),width,height)
        drawable.draw(canvas)
    }
}