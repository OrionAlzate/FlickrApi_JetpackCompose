package com.ormadev.tekus.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ormadev.tekus.persistence.PersistenceEntity
import com.ormadev.tekus.persistence.PersistenceDao

@Database(entities = [PersistenceEntity::class], version = 1)
abstract class PersistenceDatabase : RoomDatabase() {
    abstract fun persistenceDao() : PersistenceDao

}