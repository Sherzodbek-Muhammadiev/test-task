package uz.xsoft.taskapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.xsoft.taskapp.ui.pages.ImagePage
import uz.xsoft.taskapp.ui.pages.ItemPage
import uz.xsoft.taskapp.ui.pages.UserPage

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int) = when (position) {
        0 -> UserPage()
        1 -> ImagePage()
        2 -> ItemPage()
        else -> Fragment()
    }

    override fun getCount() = 3

    override fun getPageTitle(position: Int) = when (position) {
        0 -> "ONE"
        1 -> "TWO"
        2 -> "THREE"
        else -> ""
    }
}