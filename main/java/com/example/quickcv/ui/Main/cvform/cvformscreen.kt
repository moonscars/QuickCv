package com.example.quickcv.ui.cvform

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quickcv.data.Awards
import com.example.quickcv.data.Education
import com.example.quickcv.data.Experience
import com.example.quickcv.data.Projects
import com.example.quickcv.data.Skill
import com.example.quickcv.navigation.screens
import com.example.quickcv.ui.reusables.Logger.Log
import com.example.quickcv.ui.reusables.buttons.PrimaryButton
import com.example.quickcv.ui.reusables.buttons.SecondaryButton
import com.example.quickcv.ui.reusables.header.Header
import com.example.quickcv.ui.reusables.loading.Loading
import com.example.quickcv.ui.reusables.templates.TemplateChoices
import com.example.quickcv.ui.reusables.text.RoundText
import com.example.quickcv.ui.reusables.text.SfBoldText
import com.example.quickcv.ui.reusables.text.TextNInput
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun CvFormScreen(
    main_navController: NavController,
    vm: cvfromviewmodel = koinViewModel(),
) {

    //personal details
    val firstname = vm.firstname.collectAsState().value
    val lastname = vm.lastname.collectAsState().value
    val jobtitle = vm.jobtitle.collectAsState().value
    val email = vm.email.collectAsState().value
    val phonenumber = vm.phonenumber.collectAsState().value
    val address = vm.address.collectAsState().value

    //about
    val about = vm.about.collectAsState().value

    //work exp
    val exp_bucket = vm.exp_bucket.collectAsState().value.size
    val ex_job_title = vm.ex_job_title.collectAsState().value
    val duration = vm.duration.collectAsState().value
    val company_name = vm.company.collectAsState().value
    val role = vm.role.collectAsState().value

    //edu
    val edu_bucket = vm.edu_bucket.collectAsState().value.size
    val degree = vm.degree.collectAsState().value
    val edu_duration = vm.edu_duration.collectAsState().value
    val institution = vm.institution.collectAsState().value
    val cgpa = vm.cgpa.collectAsState().value


    //skill
    val skill_bucket = vm.skill_bucket.collectAsState().value.size
    val skill = vm.skill.collectAsState().value
    val skill_level = vm.skill_level.collectAsState().value


    //projects
    val project_bucket = vm.projects_bucket.collectAsState().value.size
    val project_name = vm.project_name.collectAsState().value
    val project_discreption = vm.project_discreption.collectAsState().value
    val project_link = vm.project_link.collectAsState().value


    //awards
    val award_bucket = vm.awards_bucket.collectAsState().value.size
    val award_name = vm.award_name.collectAsState().value
    val award_discreption = vm.award_discreption.collectAsState().value


    //lang
    val lang_bucket = vm.lang_bucket.collectAsState().value.size
    val lang_name = vm.lang_name.collectAsState().value

    //intrest
    val intrest_bucket = vm.intrest_bucket.collectAsState().value.size
    val intrest = vm.intrest.collectAsState().value

    //refer
    val ref_name = vm.ref_name.collectAsState().value
    val ref_designation = vm.ref_designation.collectAsState().value
    val ref_company = vm.ref_company.collectAsState().value
    val ref_phone = vm.ref_phone.collectAsState().value






    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SfBoldText("Fill Your Data", fontsize = 20.sp)

        Spacer(modifier = Modifier.height(15.dp))
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SfBoldText("Personal Data *", fontsize = 20.sp)
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "First Name",
                    value = firstname,
                    onChange = { vm.set_firstname(value = it) })
                TextNInput(
                    "Last Name",
                    value = lastname,
                    onChange = { vm.set_lastname(value = it) })
                TextNInput(
                    "Job Title",
                    value = jobtitle,
                    onChange = { vm.set_jobtitle(value = it) })
                TextNInput(
                    "Email",
                    value = email,
                    onChange = { vm.set_email(value = it) })
                TextNInput(
                    "Phone Number",
                    value = phonenumber,
                    onChange = { vm.set_phonenumber(value = it) })
                TextNInput(
                    "Address",
                    value = address,
                    onChange = { vm.set_address(value = it) })
            }
            SfBoldText("Professional Summery ", fontsize = 20.sp)
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "About Me ",
                    value = about,
                    onChange = { vm.set_about(value = it) })
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                SfBoldText("Work Experience ", fontsize = 20.sp)
                if (exp_bucket != 0) {
                    RoundText(exp_bucket)
                }

            }
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "Job Title ",
                    value = ex_job_title,
                    onChange = { vm.set_ex_job(value = it) })
                TextNInput(
                    "Duration",
                    value = duration,
                    onChange = { vm.set_duration(value = it) })
                TextNInput(
                    "Company Name ",
                    value = company_name,
                    onChange = { vm.set_company(value = it) })
                TextNInput(
                    "Role ",
                    value = role,
                    onChange = { vm.set_role(value = it) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
//                        SecondaryButton(
//                            "Save",
//                            modifier = Modifier.height(40.dp).width(140.dp),

//                            }
//                        )
                    PrimaryButton(
                        "Add Another ",
                        modifier = Modifier
                            .height(40.dp)
                            .width(140.dp),
                        onclick = {
                            if (ex_job_title.isNotEmpty() && duration.isNotEmpty() && company_name.isNotEmpty() && role.isNotEmpty()) {
                                vm.fill_exp_bucket(
                                    Experience(
                                        ex_job_title,
                                        duration,
                                        company_name,
                                        role
                                    )
                                )
                                vm.set_ex_job("")
                                vm.set_duration("")
                                vm.set_company("")
                                vm.set_role("")
                            }

                        }
                    )

                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                SfBoldText("Education ", fontsize = 20.sp)
                if (edu_bucket != 0) {
                    RoundText(edu_bucket)
                }

            }
            Column(Modifier.padding(10.dp)) {

                TextNInput(
                    "Degree ", value = degree,
                    onChange = { vm.set_degree(value = it) })
                TextNInput(
                    "Institution", value = institution,
                    onChange = { vm.set_institution(value = it) })
                TextNInput(
                    "Duration", value = edu_duration,
                    onChange = { vm.set_edu_duration(value = it) })
                TextNInput(
                    "CGPA ", value = cgpa,
                    onChange = { vm.set_cgpa(value = it) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
//                        SecondaryButton(
//                            "Save",
//                            modifier = Modifier.height(40.dp).width(140.dp)
//                        )
                    PrimaryButton(
                        "Add Another ",
                        modifier = Modifier
                            .height(40.dp)
                            .width(140.dp), onclick = {
                            if (degree.isNotEmpty() && edu_duration.isNotEmpty() && institution.isNotEmpty() && cgpa.isNotEmpty()) {
                                vm.fill_edu_bucket(
                                    Education(
                                        degree,
                                        institution,
                                        duration,
                                        cgpa
                                    )
                                )
                                vm.set_degree("")
                                vm.set_institution("")
                                vm.set_edu_duration("")
                                vm.set_cgpa("")
                            }

                        }
                    )
                }

            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                SfBoldText("Skills ", fontsize = 20.sp)
                if (skill_bucket != 0) {
                    RoundText(skill_bucket)
                }

            }
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "Name ", value = skill,
                    onChange = { vm.set_skill(value = it) })
                TextNInput(
                    "Level (noob,average,pro)", value = skill_level,
                    onChange = { vm.set_skill_level(value = it) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
//                        SecondaryButton(
//                            "Save",
//                            modifier = Modifier.height(40.dp).width(140.dp)
//                        )
                    PrimaryButton(
                        "Add Another ",
                        modifier = Modifier
                            .height(40.dp)
                            .width(140.dp), onclick = {
                            if (skill.isNotEmpty() && skill.isNotEmpty()) {
                                vm.fill_skill_bucket(
                                    Skill(
                                        skill,
                                        skill_level,

                                        )
                                )
                                vm.set_skill("")
                                vm.set_skill_level("")

                            }

                        }
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                SfBoldText("Projects ", fontsize = 20.sp)
                if (project_bucket != 0) {
                    RoundText(project_bucket)
                }

            }
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "Name ", value = project_name,
                    onChange = { vm.set_project_name(value = it) })
                TextNInput(
                    "Discreption", value = project_discreption,
                    onChange = { vm.set_project_discreption(value = it) })
                TextNInput(
                    "Link", value = project_link,
                    onChange = { vm.set_project_link(value = it) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
//                        SecondaryButton(
//                            "Save",
//                            modifier = Modifier.height(40.dp).width(140.dp)
//                        )
                    PrimaryButton(
                        "Add Another ",
                        modifier = Modifier
                            .height(40.dp)
                            .width(140.dp), onclick = {
                            if (project_name.isNotEmpty() && project_discreption.isNotEmpty() && project_link.isNotEmpty()) {
                                vm.fill_projects_bucket(
                                    Projects(
                                        project_name,
                                        project_discreption,
                                        project_link
                                    )
                                )
                                vm.set_project_link("")
                                vm.set_project_discreption("")
                                vm.set_project_name("")

                            }

                        }
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                SfBoldText("Achievements & Awards ", fontsize = 20.sp)
                if (award_bucket != 0) {
                    RoundText(award_bucket)
                }
            }
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "Name ", value = award_name,
                    onChange = { vm.set_award_name(value = it) })
                TextNInput(
                    "Discreption", value = award_discreption,
                    onChange = { vm.set_award_discreption(value = it) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
//                        SecondaryButton(
//                            "Save",
//                            modifier = Modifier.height(40.dp).width(140.dp)
//                        )
                    PrimaryButton(
                        "Add Another ",
                        modifier = Modifier
                            .height(40.dp)
                            .width(140.dp), onclick = {
                            if (award_name.isNotEmpty() && award_discreption.isNotEmpty()) {
                                vm.fill_awards_bucket(
                                    Awards(
                                        award_name,
                                        award_discreption,
                                    )
                                )
                                vm.set_award_name("")
                                vm.set_award_discreption("")


                            }

                        }
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                SfBoldText("Languages ", fontsize = 20.sp)
                if (lang_bucket != 0) {
                    RoundText(lang_bucket)
                }

            }
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "Name ", value = lang_name,
                    onChange = { vm.set_lang_name(value = it) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
//                        SecondaryButton(
//                            "Save",
//                            modifier = Modifier.height(40.dp).width(140.dp)
//                        )
                    PrimaryButton(
                        "Add Another ",
                        modifier = Modifier
                            .height(40.dp)
                            .width(140.dp), onclick = {
                            if (lang_name.isNotEmpty()) {
                                vm.fill_lang_bucket(
                                    lang_name,
                                )
                                vm.set_lang_name("")


                            }

                        }
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                SfBoldText("Hobbies & Interests ", fontsize = 20.sp)
                if (intrest_bucket != 0) {
                    RoundText(intrest_bucket)
                }

            }
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "Name ", value = intrest,
                    onChange = { vm.set_intrest(value = it) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.End
                ) {
//                        SecondaryButton(
//                            "Save",
//                            modifier = Modifier.height(40.dp).width(140.dp)
//                        )
                    PrimaryButton(
                        "Add Another ",
                        modifier = Modifier
                            .height(40.dp)
                            .width(140.dp), onclick = {
                            if (intrest.isNotEmpty()) {
                                vm.fill_intrest_bucket(
                                    intrest
                                )
                                vm.set_intrest("")
                            }

                        }
                    )
                }
            }

            SfBoldText("References ", fontsize = 20.sp)
            Column(Modifier.padding(10.dp)) {
                TextNInput(
                    "Name ", value = ref_name,
                    onChange = { vm.set_ref_name(value = it) })
                TextNInput(
                    "Designation", value = ref_designation,
                    onChange = { vm.set_ref_designation(value = it) })
                TextNInput(
                    "Company", value = ref_company,
                    onChange = { vm.set_ref_company(value = it) })
                TextNInput(
                    "Phone Number", value = ref_phone,
                    onChange = { vm.set_ref_phone(value = it) })
            }
            SfBoldText("Templates", fontsize = 20.sp)
            TemplateChoices(vm)
            PrimaryButton(

                "Build My Resume", Modifier
                    .height(45.dp)
                    .fillMaxWidth(),
                onclick = {
                    if (
                        firstname.isNotEmpty() && lastname.isNotEmpty()
                        && jobtitle.isNotEmpty() && email.isNotEmpty() && address.isNotEmpty()
                    ) {
                        var x = vm.buildmyresume()
                        if (x) main_navController.navigate(screens.HOME.route)
                    }

                },

            )


        }
    }


}





