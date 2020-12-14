package com.example.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAnim = AnimationUtils.loadAnimation(this,R.anim.button)

        val welcomeText = findViewById(R.id.textView) as TextView

        welcomeText.startAnimation(buttonAnim)
    }
}