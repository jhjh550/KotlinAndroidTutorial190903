package com.example.androidtutorial.T22_ViewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_my_view_pager.*

class MyViewPagerActivity : AppCompatActivity() {

    inner class MyPagerAdapter(fm: FragmentManager?)
                                : FragmentPagerAdapter(fm) {
        private val fragmentList = ArrayList<Fragment>()
        init {
            fragmentList.add(MyFragment())
            fragmentList.add(MyFragment2())
            fragmentList.add(MyFragment3())
        }
        override fun getItem(position: Int) = fragmentList[position]
        override fun getCount() = fragmentList.size
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view_pager)

        myViewPager.adapter = MyPagerAdapter(supportFragmentManager)
    }
}
