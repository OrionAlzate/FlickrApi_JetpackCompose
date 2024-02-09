package com.ormadev.tekus.data

import com.ormadev.tekus.model.FlickrResponse
import com.ormadev.tekus.util.Constants.Companion.API_KEY
import com.ormadev.tekus.util.Constants.Companion.ENDPOINT
import com.ormadev.tekus.util.Constants.Companion.EXTRAS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiFlickr {


    @GET("?method=flickr.interestingness.getList&api_key=40bd373bb6a19a078023b06af055d03c&extras=url_h&format=json&nojsoncallback=1")
    suspend fun getPhoto() : Response<FlickrResponse>

}


