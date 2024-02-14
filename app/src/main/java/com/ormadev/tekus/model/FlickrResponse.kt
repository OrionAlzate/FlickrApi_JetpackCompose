package com.ormadev.tekus.model

import com.google.gson.annotations.SerializedName

data class FlickrResponse(
    @SerializedName("photos") val photos: PhotoResponse
) {}

data class PhotoResponse(
    @SerializedName("total") val total:Int ,
    @SerializedName("photo") val photo: List<PhotoItemResponse>

) {}

data class PhotoItemResponse(
    @SerializedName("title") val title: String,
    @SerializedName("url_h") val imageUrl: String
) {}