package com.anber.animation

import android.animation.AnimatorSet
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.graphics.Point
import android.graphics.PointF
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.ObjectsCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val pic = findViewById<ImageView>(R.id.iv_pic)
        // 1:ViewPropertyAnimator
//        val annotation = pic.animate().translationX(100f)
//        annotation.startDelay = 800

//        val circle = findViewById<CircleView>(R.id.cv_circle)
        //2,ObjectAnimator
//        val objectAnimator = ObjectAnimator.ofFloat(circle, "radio", 80f)
//        objectAnimator.startDelay = 600
//        objectAnimator.start()

        //val camera = findViewById<CameraView1>(R.id.cv_camera)

        /*      var topFlipAnimator = ObjectAnimator.ofFloat(camera, "topFlip", 60f)
              topFlipAnimator.duration = 1500
              topFlipAnimator.startDelay = 1000
              topFlipAnimator.start()

              var bottomFlipAnimator = ObjectAnimator.ofFloat(camera, "bottomFlip", 60f)
              bottomFlipAnimator.duration = 1500
              bottomFlipAnimator.startDelay = 1000
              bottomFlipAnimator.start()

              var flipRotaionAnimator = ObjectAnimator.ofFloat(camera, "flipRotaion", 60f)
              flipRotaionAnimator.duration = 1500
              flipRotaionAnimator.startDelay = 1000
              flipRotaionAnimator.start()*/

        //3, AnimatorSet
        /* var bottomFlipAnimator = ObjectAnimator.ofFloat(camera, "bottomFlip", 60f)
         bottomFlipAnimator.duration = 1000
         bottomFlipAnimator.startDelay = 1000

         var flipRotaionAnimator = ObjectAnimator.ofFloat(camera, "flipRotaion", 270f)
         flipRotaionAnimator.duration = 1000
         flipRotaionAnimator.startDelay = 200

         var topFlipAnimator = ObjectAnimator.ofFloat(camera, "topFlip", -60f)
         topFlipAnimator.duration = 1000
         topFlipAnimator.startDelay = 200

         var animatorSet = AnimatorSet()
         animatorSet.playSequentially(bottomFlipAnimator,flipRotaionAnimator,topFlipAnimator)
         animatorSet.start()*/

        //4, PropertyValuesHolder
        /*  var bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
          var flipRotaionHolder = PropertyValuesHolder.ofFloat("flipRotaion", 270f)
          var topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)
          var valuesHolderAnimator = ObjectAnimator.ofPropertyValuesHolder(
              camera,
              bottomFlipHolder,
              flipRotaionHolder,
              topFlipHolder
          )
          valuesHolderAnimator.startDelay = 1000
          valuesHolderAnimator.duration = 200
          valuesHolderAnimator.start()*/
        //5, Keyframe
        /*  var keyframe1=Keyframe.ofFloat(0f,0f )
          var keyframe2=Keyframe.ofFloat(0.2f,1.4f * 200f.dp)
          var keyframe3=Keyframe.ofFloat(0.8f,0.6f * 200f.dp)
          var keyframe4=Keyframe.ofFloat(1f,1f * 200f.dp)

          val ofKeyframeHolder = PropertyValuesHolder.ofKeyframe(
              "translationX",
              keyframe1,
              keyframe2,
              keyframe3,
              keyframe4
          )
          val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(camera, ofKeyframeHolder)
          objectAnimator.startDelay =1000
          objectAnimator.duration=2000
          objectAnimator.start()*/

        //6, Interpolator
        /* val objectAnimator1 = ObjectAnimator.ofFloat(camera, "translationX", 200f)
         objectAnimator1.interpolator = AccelerateInterpolator()
         objectAnimator1.startDelay = 1000
         objectAnimator1.duration = 2000
         objectAnimator1.start()*/

        // TypeEvaluator
        /*val pointView = findViewById<PointView>(R.id.view)
        var objectAnimator = ObjectAnimator.ofObject(
            pointView,
            "point",
            PointView.PointTypeEvaluator(),
            PointF(300f, 300f),
        )
        objectAnimator.startDelay =1000
        objectAnimator.duration=2000
        objectAnimator.start()*/

        //对字符串做动画
        val view = findViewById<ProvinceView>(R.id.view)
        var objectAnimator = ObjectAnimator.ofObject(
            view,
            "province",
            ProvinceView.ProvinceTypeEvaluator(),
            "澳门特别行政区"
        )
        objectAnimator.startDelay = 1000
        objectAnimator.duration = 6000
        objectAnimator.start()
    }
}