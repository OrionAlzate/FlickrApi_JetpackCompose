package com.ormadev.tekus.repository

import com.ormadev.tekus.data.ApiFlickr
import com.ormadev.tekus.model.PhotoItemResponse
import com.ormadev.tekus.model.PhotoResponse
import javax.inject.Inject

class FlickrRepository @Inject constructor(private val apiFlickr: ApiFlickr){

    suspend fun getContent(): PhotoResponse? {

        val response = apiFlickr.getPhoto()
        if(response.isSuccessful){
            return response.body()?.photos

        }
        return null
    }



}