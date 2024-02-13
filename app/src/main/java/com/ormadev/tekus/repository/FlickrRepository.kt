package com.ormadev.tekus.repository

import androidx.lifecycle.LiveData
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

        insertToDB(response)

        if(response.isSuccessful){
            return response.body()?.photos

        }
        return null
    }

    fun insertToDB(response : Response<FlickrResponse>){
        for (itemResponse : PhotoItemResponse in response.body()?.photos?.photo!!){
            val persistenceEntity = PersistenceEntity(title = itemResponse.title ?: "", imageUrl = itemResponse.imageUrl?: "")
            persistenceDao.insert(persistenceEntity)
        }
    }

    fun deleteFromDB(toDelete:PersistenceEntity) = persistenceDao.delete(toDelete)
    fun getAllFromDB():LiveData<List<PersistenceEntity>> = persistenceDao.getAll()


}