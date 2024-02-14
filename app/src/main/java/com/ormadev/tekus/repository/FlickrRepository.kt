package com.ormadev.tekus.repository

import android.content.Context
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
    private val persistenceDao: PersistenceDao,
    private val context: Context
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
            val persistenceEntity = PersistenceEntity(title = itemResponse.title ?: "", imageUrl = itemResponse.imageUrl?: "")
//            val persistenceEntity = PersistenceEntity(title = itemResponse.title ?: "" )
            persistenceDao.insert(persistenceEntity)
        }
    }

    fun getAllFromDB(): List<PersistenceEntity> = persistenceDao.getAll()






}






