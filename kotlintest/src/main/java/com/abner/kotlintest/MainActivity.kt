package com.abner.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

const val TAG = "MainActivity";

class MainActivity : AppCompatActivity() {

    var testView: TextView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
    }

    fun initView() {
        //testView = findViewById(R.id.testview);
        testView!!.setOnClickListener {
            object : View.OnClickListener {
                override fun onClick(v: View?) {

                }

            }
        }
    }
}
