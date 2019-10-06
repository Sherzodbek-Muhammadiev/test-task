package uz.xsoft.taskapp.ui.callbacks

import androidx.recyclerview.widget.DiffUtil
import uz.xsoft.taskapp.room.entity.ItemData
import uz.xsoft.taskapp.room.entity.UserData

class UserCallBack:DiffUtil.ItemCallback<UserData>(){
    override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean  = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean  =
        oldItem.date == newItem.date && oldItem.name == newItem.name
}

class ItemCallBack:DiffUtil.ItemCallback<ItemData>(){
    override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean  = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean  =
        oldItem.date == newItem.date && oldItem.name == newItem.name
}