package com.example.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.GridView
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val fourAnim = AnimationUtils.loadAnimation(this,R.anim.oneanim)
        var photos = findViewById(R.id.photoPage) as ImageView

        photos.startAnimation(fourAnim)
        var modalItems: Modal = intent.getSerializableExtra("data") as Modal

        Log.e("name",modalItems.name.toString())

        photoName.text = modalItems.name
        photoPage.setImageResource(modalItems.image!!)
    }
}