package com.ormadev.tekus.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PersistenceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(persistence: PersistenceEntity)

    @Query("SELECT * FROM flickr_response ORDER BY dbId ASC")
    fun getAll() : List<PersistenceEntity>

}