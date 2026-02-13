package com.example.quickcv.data.localRepository

import com.example.quickcv.data.rooms.ResumeDoa
import com.example.quickcv.data.rooms.ResumeEntity
import kotlinx.coroutines.flow.Flow


class LocalRepository( private val resume_doa : ResumeDoa){
    val AllResume: Flow<List<ResumeEntity>> = resume_doa.GetAllResumes()

    suspend fun AddResume(resume: ResumeEntity){
        resume_doa.SetResume(resume)
    }

    suspend fun PopResume(resume: ResumeEntity){
        resume_doa.PopResume(resume)
    }
}