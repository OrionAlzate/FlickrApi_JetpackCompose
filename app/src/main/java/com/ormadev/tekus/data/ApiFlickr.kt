package com.ormadev.tekus.data

import com.ormadev.tekus.model.FlickrResponse
import com.ormadev.tekus.util.Constants.Companion.COMLETE_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiFlickr {

    @GET(COMLETE_ENDPOINT)
    suspend fun getPhoto() : Response<FlickrResponse>

}


