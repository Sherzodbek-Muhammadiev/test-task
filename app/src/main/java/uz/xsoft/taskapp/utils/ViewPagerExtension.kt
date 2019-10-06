package uz.xsoft.taskapp.utils

import androidx.viewpager.widget.ViewPager

class OnPageSelectedListener(val f: (Int)->Unit) : ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        f(position)
    }
}