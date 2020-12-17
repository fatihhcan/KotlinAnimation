package com.example.animation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var modalList = ArrayList<Modal>()

    var names = arrayOf(
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            )
    var images = intArrayOf(
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.ten,

    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val fourAnim = AnimationUtils.loadAnimation(this,R.anim.fouranim)
        var photos = findViewById(R.id.gridView) as GridView

        photos.startAnimation(fourAnim)



        for(i in names.indices){
            modalList.add(Modal(names[i],images[i]))
        }

        var customAdapter = CustomAdapter(modalList,this)
        gridView.adapter = customAdapter

        gridView.setOnItemClickListener { adapterView, view, i, l ->

            var intent = Intent(this,ViewActivity::class.java)
            intent.putExtra("data",modalList[i])
            startActivity(intent)
        }

    }


    class CustomAdapter(
            var itemModel : ArrayList<Modal>,
            var context: Context
    ) : BaseAdapter(){
        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getCount(): Int {
            return itemModel.size
        }

        override fun getItem(p0: Int): Any {
        return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var view = view
            if (view == null){
                view = layoutInflater.inflate(R.layout.items_row, viewGroup, false)
            }

           var tvImageName = view?.findViewById<TextView>(R.id.imageName)
            var imageView = view?.findViewById<ImageView>(R.id.photo)

            tvImageName?.text = itemModel[position].name
            imageView?.setImageResource(itemModel[position].image!!)
            return view!!
        }
    }
}