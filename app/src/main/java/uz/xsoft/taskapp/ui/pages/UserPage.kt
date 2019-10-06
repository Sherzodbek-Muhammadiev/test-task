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
import uz.xsoft.taskapp.room.entity.UserData
import uz.xsoft.taskapp.ui.adapters.UserAdapter
import uz.xsoft.taskapp.ui.viewmodels.UserPageViewModel
import uz.xsoft.taskapp.utils.factoryViewModel

class UserPage : Fragment(R.layout.page_user) {
    private val viewModel : UserPageViewModel by factoryViewModel()
    private val adapter = UserAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
        viewModel.userListLiveData.observe(this,userListObserver)
    }

    private val userListObserver = Observer<PagedList<UserData>>{
        Log.d("TTT","it=${it.size}")
        adapter.submitList(it)
        list.smoothScrollToPosition(0)
    }
}