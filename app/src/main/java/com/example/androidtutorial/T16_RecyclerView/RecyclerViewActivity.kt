package com.example.androidtutorial.T16_RecyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class RecyclerViewActivity : AppCompatActivity() {

    data class MyData(val title:String, val desc:String, val img:Int)

    val myList = ArrayList<MyData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        generateData()
    }

    private fun generateData(){
        val icons = arrayOf( R.drawable.ic_3d_rotation_black_24dp,
            R.drawable.ic_ac_unit_black_24dp,
            R.drawable.ic_access_alarm_black_24dp )

        for(i in 0..100){
            val icon = icons[i%3]
            myList.add(
                MyData("title $i", "desc $i", icon)
            )
        }
    }
}
