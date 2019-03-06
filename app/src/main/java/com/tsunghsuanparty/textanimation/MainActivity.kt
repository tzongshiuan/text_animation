package com.tsunghsuanparty.textanimation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tsunghsuanparty.textanimlib.slide.SlideAnimation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        val slowText = findViewById<TextView>(R.id.text_slow)
        val slideAnim1 = SlideAnimation()
        slideAnim1.initSettings(Color.BLACK, Color.GREEN, SlideAnimation.ANIM_SLOW)
        slideAnim1.startAnimation(slowText)

        val normalText = findViewById<TextView>(R.id.text_normal)
        val slideAnim2 = SlideAnimation()
        slideAnim2.initSettings(Color.BLACK, Color.GREEN, SlideAnimation.ANIM_NORMAL)
        slideAnim2.startAnimation(normalText)

        val fastText = findViewById<TextView>(R.id.text_fast)
        val slideAnim3 = SlideAnimation()
        slideAnim3.initSettings(Color.BLACK, Color.GREEN, SlideAnimation.ANIM_FAST)
        slideAnim3.startAnimation(fastText)
    }
}
