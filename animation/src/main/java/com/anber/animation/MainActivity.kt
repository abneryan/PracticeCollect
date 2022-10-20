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
    }
}