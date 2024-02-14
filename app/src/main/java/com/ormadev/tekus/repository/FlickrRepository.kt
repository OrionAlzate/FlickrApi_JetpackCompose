package com.ormadev.tekus.repository

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.ormadev.tekus.data.ApiFlickr
import com.ormadev.tekus.model.FlickrResponse
import com.ormadev.tekus.model.PhotoItemResponse
import com.ormadev.tekus.model.PhotoResponse
import com.ormadev.tekus.persistence.PersistenceDao
import com.ormadev.tekus.persistence.PersistenceEntity
import retrofit2.Response
import javax.inject.Inject

class FlickrRepository @Inject constructor(
    private val apiFlickr: ApiFlickr,
    private val persistenceDao: PersistenceDao
){

    suspend fun getContent(): PhotoResponse? {

        val response = apiFlickr.getPhoto()

        if(response.isSuccessful){
            insertToDB(response)
            return response.body()?.photos
        }
        return null
    }

    fun insertToDB(response : Response<FlickrResponse>){

        for (itemResponse : PhotoItemResponse in response.body()?.photos?.photo!!){
            val localImagePath :String? = itemResponse.imageUrl // converitr en ruta local con Glide
            val persistenceEntity = PersistenceEntity(title = itemResponse.title ?: "", imageUrl = itemResponse.imageUrl?: "", localImagePath = localImagePath)
            persistenceDao.insert(persistenceEntity)
        }
    }

    fun getAllFromDB(): List<PersistenceEntity> = persistenceDao.getAll()


    private suspend fun saveFlickrImage(imageUrl: String): String{
        try {

//            val context = Context
//            val bitmap : Bitmap = Glide.with(context)



            return ""
        }catch (e : Exception){
            Log.i("Error", e.message.toString())
            return ""
        }
    }



}






