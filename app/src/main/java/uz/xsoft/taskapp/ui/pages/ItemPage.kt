package uz.xsoft.taskapp.ui.pages

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.page_user.*
import uz.xsoft.taskapp.R
import uz.xsoft.taskapp.room.entity.ItemData
import uz.xsoft.taskapp.room.entity.UserData
import uz.xsoft.taskapp.ui.adapters.ItemAdapter
import uz.xsoft.taskapp.ui.adapters.UserAdapter
import uz.xsoft.taskapp.ui.viewmodels.ItemPageViewModel
import uz.xsoft.taskapp.ui.viewmodels.MainViewModel
import uz.xsoft.taskapp.utils.factoryViewModel

class ItemPage:Fragment(R.layout.page_user) {
    private val viewModel : ItemPageViewModel by factoryViewModel()
//    private val parentViewModel:MainViewModel by
    private val adapter = ItemAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
        viewModel.itemListLiveData.observe(this,itemListObserver)
    }

    private val itemListObserver = Observer<PagedList<ItemData>>{
        Log.d("TTT","it=${it.size}")
        adapter.submitList(it)
        list.smoothScrollToPosition(0)
    }
}