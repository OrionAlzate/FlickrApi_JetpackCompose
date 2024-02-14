package com.ormadev.tekus.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("flickr_response")
data class PersistenceEntity(

    @PrimaryKey(autoGenerate = true) var dbId : Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "localImagePath") val localImagePath : String?

) {}
