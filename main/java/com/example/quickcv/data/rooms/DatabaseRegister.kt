package com.example.quickcv.data.rooms

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ResumeEntity::class, PrimaryCardEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase():RoomDatabase(){

    abstract fun resumedoa():ResumeDoa

    abstract fun primarydoa(): PrimaryDoa

}