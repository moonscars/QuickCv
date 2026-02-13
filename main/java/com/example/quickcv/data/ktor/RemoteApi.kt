package com.example.quickcv.data.ktor

import com.example.quickcv.data.PrimaryRequest
import com.example.quickcv.data.SearchRequest
import com.example.quickcv.data.SearchResponse
import com.example.quickcv.data.rooms.PrimaryCardEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//http://192.168.56.1:8000/

//private val ContentType.Companion.Application: Any
const val BASEURL: String = "http://192.168.0.101:8000/"

val clientx = HttpClient (OkHttp){
    install(ContentNegotiation) {
        json(
            Json {
                encodeDefaults = true
                isLenient = true
                ignoreUnknownKeys = true

            }
        )
    }
}

//add thsi desp tommorrohy
suspend fun SetPrimaryData(data: PrimaryRequest): PrimaryCardEntity {
    return clientx.post("${BASEURL}UpsertPrimaryData") {
        contentType(io.ktor.http.ContentType.Application.Json)
        setBody(data)
    }.body()
}


suspend fun GetResumeData(data: SearchRequest): SearchResponse?{
    return clientx.post("${BASEURL}GetResume"){
        contentType(io.ktor.http.ContentType.Application.Json)
        setBody(data)
    }.body()

}