package com.example.quickcv.data

import com.example.quickcv.data.rooms.PrimaryCardEntity
import com.example.quickcv.data.rooms.ResumeEntity
import kotlinx.serialization.Serializable

@Serializable
data class Awards(val name: String, val description: String)

@Serializable
data class Projects(val name: String, val description: String, val link: String)

@Serializable
data class Skill(val skill: String, val level: String)

@Serializable
data class Education(
    val degree: String,
    val institution: String,
    val duration: String,
    val cgpa: String
)

@Serializable
data class Experience(
    val jobtitle: String,
    val duration: String,
    val company: String,
    val role: String
)


@Serializable
data class PrimaryRequest(
    val resume: ResumeEntity,
    val code:String?
)


@Serializable
data class SearchRequest(val code:String)

@Serializable
data class code (
    val code :String,
   val  views:String
)

@Serializable
data class SearchResponse(
    val code: code,
    val firstname: String?,
    val lastname: String?,
    val jobtitle: String?,
    val email: String?,
    val phonenumber: String?,
    val address: String?,
    val exp_bucket: String?,
    val edu_bucket: String?,
    val skill_bucket: String?,
    val project_bucket: String?,
    val awards_bucket: String?,
    val lang_bucket: String?,
    val intrest_bucket: String?,
    val ref_name: String?,
    val ref_designation: String?,
    val ref_company: String?,
    val ref_phone: String?,
    val ref_template: String?,
)