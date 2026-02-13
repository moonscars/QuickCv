package com.example.quickcv.ui.reusables.template

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickcv.data.Awards
import com.example.quickcv.data.Education
import com.example.quickcv.data.Experience
import com.example.quickcv.data.Projects
import com.example.quickcv.data.Skill
import com.example.quickcv.data.rooms.ResumeEntity
import com.example.quickcv.ui.reusables.Logger.Log
import com.example.quickcv.ui.reusables.text.SfBoldText
import com.example.quickcv.ui.reusables.text.SfRegText
import kotlinx.serialization.json.Json


@Composable
fun TemplateOne(Resume: MutableState<ResumeEntity?>) {
    Log.say("abhix","TEmplate here")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp, 0.dp),

        ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())


        ) {
            HeaderSection(
                firstname = Resume.value?.firstname,
                lastname = Resume.value?.lastname,
                jobtitle = Resume.value?.jobtitle,
                phonenumber = Resume.value?.phonenumber,
                email = Resume.value?.email,
                address = Resume.value?.address

            )
            Log.say("abhix","TEmplate here 2")

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Log.say("abhix","TEmplate 3")

                BottomLeftSection(data = Resume)
                Log.say("abhix","TEmplate 4")

                BottomRightSection(data = Resume)
                Log.say("abhix","TEmplate 5")

            }
                Spacer(modifier = Modifier.height(20.dp))
                CvHeading("References ")
                Spacer(modifier = Modifier.height(20.dp))
                SweetWrap {
                    SfBoldText("Dav Khrod", fontsize = 15.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    SfRegText("(Manager)", fontsize = 15.sp)
                }
                Spacer(modifier = Modifier.height(5.dp))
                SfBoldText(" Company (JP Morgan)", fontsize = 15.sp)
                Spacer(modifier = Modifier.height(5.dp))
                SfRegText(" +9485038274", fontsize = 13.sp)


        }
    }

}


@Composable
private fun HeaderSection(
    firstname: String? = "marian",
    lastname: String? = "langdon lee",
    jobtitle: String? = "nurse",

    phonenumber: String? = "+9038574832",
    email: String? = "marian@gmail.com",
    address: String? = "P-23 Ohio Usa",
) {
    Row(
        modifier = Modifier
//            .background(Color.Red)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween


    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(5.dp)
            ) {
                SfBoldText(firstname!!.uppercase(), fontsize = 15.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(5.dp)
            ) {
                SfBoldText(lastname!!.uppercase(), fontsize = 15.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                    )
                    .padding(5.dp)
            ) {
                SfBoldText(jobtitle!!.uppercase(), fontsize = 10.sp, color = Color.Black)
            }

        }

        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.Black)
                )
                Spacer(modifier = Modifier.width(5.dp))
                SfRegText(phonenumber!!, fontsize = 11.sp, color = Color.Black)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.Black)
                )
                Spacer(modifier = Modifier.width(5.dp))
                SfRegText(email!!, fontsize = 11.sp, color = Color.Black)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.Black)
                )
                Spacer(modifier = Modifier.width(5.dp))
                SfRegText(address!!, fontsize = 11.sp, color = Color.Black)
            }
        }

    }
}


@Composable
private fun BottomLeftSection(data: MutableState<ResumeEntity?>) {
    Column(
        modifier = Modifier
            .width(170.dp)
    ) {
        Column {

            CvHeading("Education")
            Spacer(modifier = Modifier.height(20.dp))
            val x = Json.decodeFromString<List<Education?>>(data.value?.edu_bucket.toString())
            if (x.size != 0) {

                x.forEach { data ->
                    SfBoldText(
                        data?.degree.toString(), fontsize = 15.sp
                    )
                    SfRegText(
                        data?.institution.toString(), fontsize = 13.sp
                    )
                    SfRegText(
                        "${data?.duration.toString()}|${data?.cgpa.toString()}",
                        fontsize = 13.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }


            val y = Json.decodeFromString<List<Experience?>>(data.value?.exp_bucket.toString())
            if (y.size != 0) {
                Spacer(modifier = Modifier.height(20.dp))
                CvHeading("Experience")

                y.forEach { data ->
                    Spacer(modifier = Modifier.height(20.dp))
                    SfBoldText(data?.jobtitle.toString(), fontsize = 15.sp)
                    SfRegText(data?.company.toString(), fontsize = 13.sp)
                    SfRegText(data?.duration.toString(), fontsize = 13.sp)
                    SfRegText(
                        data?.role.toString(),
                        fontsize = 13.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }


            val z = Json.decodeFromString<List<Awards?>>(data.value?.awards_bucket.toString())
            if (z.size != 0) {

                Spacer(modifier = Modifier.height(20.dp))
                CvHeading("Achievements")
                Spacer(modifier = Modifier.height(20.dp))

                z.forEach { data ->

                    SweetWrap {
                        SfBoldText(data?.name.toString(), fontsize = 15.sp)
                    }
                    SfRegText(
                        data?.description.toString(),
                        fontsize = 13.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            val l = Json.decodeFromString<List<String?>>(data.value?.intrest_bucket.toString())
            if (l.size != 0) {


                CvHeading("Hobbies")
                Spacer(modifier = Modifier.height(20.dp))

                l.forEach { data ->
                    SweetWrap {
                        SfBoldText(data.toString(), fontsize = 15.sp)
                    }
                }
            }
        }
    }
}


@Composable
private fun BottomRightSection(
    about: String = "Write About Here",
    data: MutableState<ResumeEntity?>

) {
    Log.say("abhix","TEmplate 4.1")

    Column(
        modifier = Modifier
            .width(160.dp)
    ) {
        Column {

            CvHeading("About")
            Spacer(modifier = Modifier.height(20.dp))
            SfRegText(
                about,
                fontsize = 13.sp,
                textAlign = TextAlign.Start
            )


            Spacer(modifier = Modifier.height(20.dp))
            val f = Json.decodeFromString<List<String?>>(data.value?.lang_bucket.toString())
            if (f.size != 0) {
                CvHeading("Languages")
                f.forEach { data ->

                    SweetWrap {
                        SfBoldText(data.toString(), fontsize = 15.sp)
                    }
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            val x = Json.decodeFromString<List<Skill?>>(data.value?.skill_bucket.toString())
            if (x.size != 0) {
                CvHeading("Skills")
                Spacer(modifier = Modifier.height(20.dp))
                x.forEach { data ->

                    SweetWrap {
                        SfBoldText(data?.skill.toString(), fontsize = 13.sp, textAlign = TextAlign.Start)
                    }
                }


            }
            Spacer(modifier = Modifier.height(20.dp))
            val y = Json.decodeFromString<List<Projects?>>(data.value?.project_bucket.toString())
            if (y.size != 0) {

                CvHeading("Projects")
                Spacer(modifier = Modifier.height(20.dp))
                y.forEach { data ->

                    SweetWrap {
                        SfBoldText(
                            data?.name.toString(),
                            fontsize = 13.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                    SfRegText(
                        data?.description.toString(),
                        fontsize = 13.sp,
                        textAlign = TextAlign.Start
                    )

                    SfBoldText("View Project", fontsize = 12.sp)

                    Spacer(modifier = Modifier.height(20.dp))


                }

            }
        }
    }
}


@Composable
private fun CvHeading(heading: String = "Heading") {
    Row(
        modifier = Modifier
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .size(10.dp)
                    .background(Color.White)
            )
        }
        Column(
            modifier = Modifier
                .background(Color.Black)
                .padding(0.dp, 0.dp, 0.dp, 2.dp)
                .background(Color.White)
                .padding(5.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth()

        ) {
            SfBoldText(
                heading.uppercase(),
                fontsize = 13.sp
            )
        }
    }
}


@Composable
private fun SweetWrap(content: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(0.dp, 5.dp, 0.dp, 0.dp)
            .background(Color.Black)
            .padding(2.dp, 0.dp, 0.dp, 0.dp)
            .background(Color.White)
            .padding(2.dp, 0.dp, 0.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        content()
    }
}