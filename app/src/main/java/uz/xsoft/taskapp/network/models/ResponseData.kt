package uz.xsoft.taskapp.network.models

import com.google.gson.annotations.SerializedName

sealed class ResponseData {
	class AdvertisementData(

		@field:SerializedName("ad_mob")
		val adMob: Boolean? = null,

		@field:SerializedName("zone")
		val zone: List<ZoneItem?>? = null
	)

	class ZoneItem(

		@field:SerializedName("name")
		val name: String? = null,

		@field:SerializedName("files")
		val files: List<FilesItem?>? = null,

		@field:SerializedName("type")
		val type: String? = null,

		@field:SerializedName("priority")
		val priority: Int? = null,

		@field:SerializedName("url")
		val url: String? = null
	)

	class FilesItem(

		@field:SerializedName("type")
		val type: String? = null,

		@field:SerializedName("url")
		val url: String? = null
	)
}

