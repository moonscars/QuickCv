package com.example.quickcv.ui.cvform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quickcv.data.Awards
import com.example.quickcv.data.Education
import com.example.quickcv.data.Experience
import com.example.quickcv.data.Projects
import com.example.quickcv.data.Skill
import com.example.quickcv.data.localRepository.LocalRepository
import com.example.quickcv.data.rooms.ResumeEntity
import com.example.quickcv.ui.reusables.Logger.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.collections.emptyList
import kotlin.collections.plus

class cvfromviewmodel(private val LocalRepository: LocalRepository) : ViewModel() {


    //personal data
    private val _firstname = MutableStateFlow("")
    var firstname = _firstname.asStateFlow()
    fun set_firstname(value: String) {
        _firstname.value = value; }

    private val _lastname = MutableStateFlow("")
    var lastname = _lastname.asStateFlow()
    fun set_lastname(value: String) {
        _lastname.value = value; }

    private val _jobtitle = MutableStateFlow("")
    var jobtitle = _jobtitle.asStateFlow()
    fun set_jobtitle(value: String) {
        _jobtitle.value = value; }

    private val _email = MutableStateFlow("")
    var email = _email.asStateFlow()
    fun set_email(value: String) {
        _email.value = value; }

    private val _phonenumber = MutableStateFlow("")
    var phonenumber = _phonenumber.asStateFlow()
    fun set_phonenumber(value: String) {
        _phonenumber.value = value; }

    private val _address = MutableStateFlow("")
    var address = _address.asStateFlow()
    fun set_address(value: String) {
        _address.value = value; }


    //professional summery
    private val _about = MutableStateFlow("")
    var about = _about.asStateFlow()
    fun set_about(value: String) {
        _about.value = value; }


    //work exp
    private val _exp_bucket = MutableStateFlow<List<Experience>>(emptyList())
    val exp_bucket = _exp_bucket.asStateFlow()
    fun fill_exp_bucket(value: Experience) {
        _exp_bucket.update { experiences -> experiences + value }
    }


    private val _ex_job_title = MutableStateFlow("")
    val ex_job_title = _ex_job_title.asStateFlow()
    fun set_ex_job(value: String) {
        _ex_job_title.value = value; }

    private val _duration = MutableStateFlow("")
    val duration = _duration.asStateFlow()
    fun set_duration(value: String) {
        _duration.value = value; }

    private val _company = MutableStateFlow("")
    val company = _company.asStateFlow()
    fun set_company(value: String) {
        _company.value = value; }

    private val _role = MutableStateFlow("")
    val role = _role.asStateFlow()
    fun set_role(value: String) {
        _role.value = value; }


    //education

    private val _edu_bucket = MutableStateFlow<List<Education>>(emptyList())
    val edu_bucket = _edu_bucket.asStateFlow()
    fun fill_edu_bucket(value: Education) {
        _edu_bucket.update { Education -> Education + value }
    }

    private val _degree = MutableStateFlow("")
    val degree = _degree.asStateFlow()
    fun set_degree(value: String) {
        _degree.value = value; }

    private val _institution = MutableStateFlow("")
    val institution = _institution.asStateFlow()
    fun set_institution(value: String) {
        _institution.value = value; }

    private val _edu_duration = MutableStateFlow("")
    val edu_duration = _edu_duration.asStateFlow()
    fun set_edu_duration(value: String) {
        _edu_duration.value = value; }

    private val _cgpa = MutableStateFlow("")
    val cgpa = _cgpa.asStateFlow()
    fun set_cgpa(value: String) {
        _cgpa.value = value; }


    //skills

    private val _skill_bucket = MutableStateFlow<List<Skill>>(emptyList())
    val skill_bucket = _skill_bucket.asStateFlow()
    fun fill_skill_bucket(value: Skill) {
        _skill_bucket.update { Skill -> Skill + value }
    }

    private val _skill = MutableStateFlow("")
    val skill = _skill.asStateFlow()
    fun set_skill(value: String) {
        _skill.value = value; }

    private val _skill_level = MutableStateFlow("")
    val skill_level = _skill_level.asStateFlow()
    fun set_skill_level(value: String) {
        _skill_level.value = value; }


    //projects
    private val _projects_bucket = MutableStateFlow<List<Projects>>(emptyList())
    val projects_bucket = _projects_bucket.asStateFlow()
    fun fill_projects_bucket(value: Projects) {
        _projects_bucket.update { Projects -> Projects + value }
    }

    private val _project_name = MutableStateFlow("")
    val project_name = _project_name.asStateFlow()
    fun set_project_name(value: String) {
        _project_name.value = value; }

    private val _project_discreption = MutableStateFlow("")
    val project_discreption = _project_discreption.asStateFlow()
    fun set_project_discreption(value: String) {
        _project_discreption.value = value; }

    private val _project_link = MutableStateFlow("")
    val project_link = _project_link.asStateFlow()
    fun set_project_link(value: String) {
        _project_link.value = value; }


    //achievements
    private val _awards_bucket = MutableStateFlow<List<Awards>>(emptyList())
    val awards_bucket = _awards_bucket.asStateFlow()
    fun fill_awards_bucket(value: Awards) {
        _awards_bucket.update { Awards -> Awards + value }
    }

    private val _award_name = MutableStateFlow("")
    val award_name = _award_name.asStateFlow()
    fun set_award_name(value: String) {
        _award_name.value = value; }

    private val _award_discreption = MutableStateFlow("")
    val award_discreption = _award_discreption.asStateFlow()
    fun set_award_discreption(value: String) {
        _award_discreption.value = value; }


    //Languages
    private val _lang_bucket = MutableStateFlow<List<String>>(emptyList())
    val lang_bucket = _lang_bucket.asStateFlow()
    fun fill_lang_bucket(value: String) {
        _lang_bucket.update { Lang -> Lang + value }
    }

    private val _lang_name = MutableStateFlow("")
    val lang_name = _lang_name.asStateFlow()
    fun set_lang_name(value: String) {
        _lang_name.value = value; }


    //intrest
    private val _intrest_bucket = MutableStateFlow<List<String>>(emptyList())
    val intrest_bucket = _intrest_bucket.asStateFlow()
    fun fill_intrest_bucket(value: String) {
        _intrest_bucket.update { Hobby -> Hobby + value }
    }

    private val _intrest = MutableStateFlow("")
    val intrest = _intrest.asStateFlow()
    fun set_intrest(value: String) {
        _intrest.value = value; }

    //References
    private val _ref_name = MutableStateFlow("")
    val ref_name = _ref_name.asStateFlow()
    fun set_ref_name(value: String) {
        _ref_name.value = value; }

    private val _ref_designation = MutableStateFlow("")
    val ref_designation = _ref_designation.asStateFlow()
    fun set_ref_designation(value: String) {
        _ref_designation.value = value; }

    private val _ref_company = MutableStateFlow("")
    val ref_company = _ref_company.asStateFlow()
    fun set_ref_company(value: String) {
        _ref_company.value = value; }

    private val _ref_phone = MutableStateFlow("")
    val ref_phone = _ref_phone.asStateFlow()
    fun set_ref_phone(value: String) {
        _ref_phone.value = value; }


    private val _template = MutableStateFlow("template_one")
    val template = _template.asStateFlow()


    fun set_template(value: String) {
        _template.value = value
    }


    fun buildmyresume(): Boolean {

        val resume = ResumeEntity(
            firstname = _firstname.value,
            lastname = _lastname.value,
            jobtitle = _jobtitle.value,
            email = _email.value,
            phonenumber = _phonenumber.value,
            address = _address.value,
            exp_bucket = Json.encodeToString(_exp_bucket.value),
            edu_bucket = Json.encodeToString(_edu_bucket.value),
            skill_bucket = Json.encodeToString(_skill_bucket.value),
            project_bucket = Json.encodeToString(_projects_bucket.value),
            awards_bucket = Json.encodeToString(_awards_bucket.value),
            lang_bucket = Json.encodeToString(_lang_bucket.value),
            intrest_bucket = Json.encodeToString(_intrest_bucket.value),
            ref_name = _ref_name.value,
            ref_designation = _ref_designation.value,
            ref_company = _ref_company.value,
            ref_phone = _ref_phone.value,
            ref_template = _template.value,
        )
        viewModelScope.launch {
            LocalRepository.AddResume(resume)
        }
        return true

    }


}