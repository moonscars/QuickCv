package com.example.quickcv.data.rooms

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface ResumeDoa{
    @Query("SELECT * FROM ResumeEntity")
    fun GetAllResumes(): Flow<List<ResumeEntity>>

    @Insert
    suspend fun SetResume(resume: ResumeEntity)

    @Delete
    suspend fun PopResume(resume: ResumeEntity)




}