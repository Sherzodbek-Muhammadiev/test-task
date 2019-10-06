package uz.xsoft.taskapp.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_advertisement.view.*
import uz.xsoft.taskapp.R
import uz.xsoft.taskapp.network.models.ResponseData
import uz.xsoft.taskapp.utils.inflate
import uz.xsoft.taskapp.utils.loadImageFromUrl

class AdvertisementAdapter : RecyclerView.Adapter<AdvertisementAdapter.ViewHolder>() {
    private val data = ArrayList<ResponseData.ZoneItem?>()
    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_advertisement))
    }

    fun updateData(d: List<ResponseData.ZoneItem?>) {
        val pos = d.size
        data.addAll(d)
        notifyItemRangeChanged(pos, d.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val d = data[adapterPosition]
            itemView.apply {
                textTitle.text = d?.name
                imageIcon.loadImageFromUrl(d?.files?.firstOrNull()?.url.toString())
            }

        }
    }

}