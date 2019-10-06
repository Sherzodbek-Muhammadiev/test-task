package uz.xsoft.taskapp.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*
import uz.xsoft.taskapp.R
import uz.xsoft.taskapp.room.entity.ItemData
import uz.xsoft.taskapp.room.entity.UserData
import uz.xsoft.taskapp.ui.calsbacks.ItemCallBack
import uz.xsoft.taskapp.ui.calsbacks.UserCallBack
import uz.xsoft.taskapp.utils.date
import uz.xsoft.taskapp.utils.inflate

class ItemAdapter : PagedListAdapter<ItemData,ItemAdapter.ViewHolder>(ItemCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_user))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val d = getItem(adapterPosition)
            d?.let {
                itemView.apply {
                    textTitle.text = d.name
                    textDate.text = d.date.date()
                    textSub.text = d.id.toString()
                }
            }

        }
    }

}