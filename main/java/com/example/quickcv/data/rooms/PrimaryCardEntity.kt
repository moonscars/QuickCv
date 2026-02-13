package com.example.quickcv.data.rooms

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity
@Serializable
data class PrimaryCardEntity(
    @PrimaryKey(autoGenerate = true)
    val id :Int? = 0,
    val code: String?,
    val views: String?,
    val jobtitle:String?,
)