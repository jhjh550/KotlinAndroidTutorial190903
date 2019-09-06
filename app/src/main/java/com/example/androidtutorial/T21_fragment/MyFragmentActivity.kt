package com.example.androidtutorial.T21_fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_fragment.*

class MyFragmentActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        btnAdd.setOnClickListener(this)
        btnRemove.setOnClickListener(this)
        btnReplace.setOnClickListener(this)
        btnHide.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val fragment = supportFragmentManager.findFragmentById(R.id.containerLayout)
        when(view?.id){
            R.id.btnAdd->{
                if(fragment == null){
                    val newFragment = CounterFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .add(R.id.containerLayout, newFragment, "counter")
                        .commit()
                }
            }
            R.id.btnRemove->{}
        }
    }
}
