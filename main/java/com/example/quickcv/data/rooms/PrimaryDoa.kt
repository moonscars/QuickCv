package com.example.quickcv.data.rooms

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PrimaryDoa{

    @Query("SELECT * FROM PrimaryCardEntity WHERE id  IS 0")
    fun GetPrimaryData(): Flow<PrimaryCardEntity?>

    @Upsert
    suspend fun UpsertPrimaryData(primarydata: PrimaryCardEntity)



}