package com.ormadev.tekus.di

import android.content.Context
import androidx.room.PrimaryKey
import androidx.room.Room
import com.ormadev.tekus.data.ApiFlickr
import com.ormadev.tekus.data.PersistenceDatabase
import com.ormadev.tekus.persistence.PersistenceDao
import com.ormadev.tekus.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiFlickr(retrofit: Retrofit):ApiFlickr {
        return retrofit.create(ApiFlickr::class.java)
    }

    @Singleton
    @Provides
    fun prividesPersistenceDatabase(@ApplicationContext context : Context):PersistenceDatabase {
        return Room.databaseBuilder(context, PersistenceDatabase::class.java, "flickr_response")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesPersistenceDatabase(db:PersistenceDatabase):PersistenceDao = db.persistenceDao()

}