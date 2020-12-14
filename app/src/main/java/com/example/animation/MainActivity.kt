package com.example.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oneAnim = AnimationUtils.loadAnimation(this,R.anim.oneanim)
        val twoAnim = AnimationUtils.loadAnimation(this,R.anim.twoanim)
        val threeAnim = AnimationUtils.loadAnimation(this,R.anim.threeanim)
        val fourAnim = AnimationUtils.loadAnimation(this,R.anim.fouranim)

        val emailText = findViewById(R.id.editTextEmailAddress) as EditText
        val passwordText = findViewById(R.id.editTextPassword) as EditText
        val button = findViewById(R.id.button) as Button



        val welcomeText = findViewById(R.id.textView) as TextView
        val imageLogo = findViewById(R.id.imageView) as ImageView

        welcomeText.startAnimation(oneAnim)
        imageLogo.startAnimation(twoAnim)
        emailText.startAnimation(threeAnim)
        passwordText.startAnimation(threeAnim)
        button.startAnimation(fourAnim)

    }
}