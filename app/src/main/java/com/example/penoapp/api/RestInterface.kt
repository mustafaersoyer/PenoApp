package com.example.penoapp.api

import com.example.penoapp.model.Notice
import com.google.gson.JsonObject

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface RestInterface {

    @GET("/api/Notices/GetNotices")
    fun getAllNotice(): Call<List<Notice>>

}
