package uz.xsoft.taskapp.ui.pages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.page_user.*
import uz.xsoft.taskapp.R
import uz.xsoft.taskapp.network.models.ResponseData
import uz.xsoft.taskapp.ui.adapters.AdvertisementAdapter
import uz.xsoft.taskapp.ui.viewmodels.AdvertisementViewModel
import uz.xsoft.taskapp.utils.factoryViewModel
import android.annotation.SuppressLint
import kotlinx.android.synthetic.main.page_image.*
import kotlinx.android.synthetic.main.page_user.list


class ImagePage : Fragment(R.layout.page_image) {
    private val viewModel: AdvertisementViewModel by factoryViewModel()
    private val adapter = AdvertisementAdapter()

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.advertisementLiveData.observe(this, advertisementObserver)
        viewModel.errorLiveData.observe(this, errorObserver)
        viewModel.reloadLiveData.observe(this, reloadableObserver)
        viewModel.progressLiveData.observe(this, progressObserver)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context)
        buttonReload.setOnClickListener { viewModel.reload() }
    }

    private val advertisementObserver = Observer<ResponseData.AdvertisementData> {
        it.zone?.let {
            adapter.updateData(it)
        }
    }

    private val errorObserver = Observer<Boolean> {
        layoutNetwork.visibility = if (it) View.VISIBLE else View.INVISIBLE
    }

    private val reloadableObserver = Observer<Boolean> {
        buttonReload.visibility = if (it) View.VISIBLE else View.INVISIBLE
    }

    private val progressObserver = Observer<Boolean> {
        progress.visibility = if (it) View.VISIBLE else View.INVISIBLE
    }
}