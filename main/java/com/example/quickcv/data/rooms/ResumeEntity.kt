package com.example.quickcv.data.rooms

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity
@Serializable
data class ResumeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstname: String,
    val lastname: String,
    val jobtitle: String,
    val email: String,
    val phonenumber: String,
    val address: String,
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
