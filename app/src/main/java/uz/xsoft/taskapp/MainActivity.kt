package uz.xsoft.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import uz.xsoft.taskapp.ui.adapters.PagerAdapter
import uz.xsoft.taskapp.ui.viewmodels.MainViewModel
import uz.xsoft.taskapp.utils.OnPageSelectedListener
import uz.xsoft.taskapp.utils.factoryViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by factoryViewModel()
    private lateinit var adapter:PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.addDisableLiveData.observe(this,addButtonDisableObserver)
        viewModel.addEnableLiveData.observe(this,addButtonEnableObserver)
        adapter = PagerAdapter(supportFragmentManager)
        pager.adapter = adapter
        tabLayout.setupWithViewPager(pager)
        pager.addOnPageChangeListener(OnPageSelectedListener{viewModel.pageSelected(it)})
        buttonFab.setOnClickListener {viewModel.addData(pager.currentItem)}
    }

    private val addButtonDisableObserver = Observer<Unit>{ buttonFab.hide() }

    private val addButtonEnableObserver = Observer<Unit>{ buttonFab.show() }
}
