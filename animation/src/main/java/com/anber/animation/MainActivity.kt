package com.anber.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.ObjectsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val pic = findViewById<ImageView>(R.id.iv_pic)
//        val annotation = pic.animate().translationX(100f)
//        annotation.startDelay = 800

//        val circle = findViewById<CircleView>(R.id.cv_circle)
//        val objectAnimator = ObjectAnimator.ofFloat(circle, "radio", 80f)
//        objectAnimator.startDelay = 600
//        objectAnimator.start()

        val camera = findViewById<CameraView1>(R.id.cv_camera)

     /*   var topFlipAnimator = ObjectAnimator.ofFloat(camera, "topFlip", 60f)
        topFlipAnimator.duration = 1500
        topFlipAnimator.startDelay = 1000
        topFlipAnimator.start()*/

      /*  var bottomFlipAnimator = ObjectAnimator.ofFloat(camera,"bottomFlip",60f)
        bottomFlipAnimator.duration =1500
        bottomFlipAnimator.startDelay =1000
        bottomFlipAnimator.start()*/

          var flipRotaionAnimator = ObjectAnimator.ofFloat(camera,"flipRotaion",60f)
        flipRotaionAnimator.duration =1500
        flipRotaionAnimator.startDelay =1000
        flipRotaionAnimator.start()
    }
}