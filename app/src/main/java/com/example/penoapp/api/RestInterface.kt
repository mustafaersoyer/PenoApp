package com.example.penoapp.api

import com.example.penoapp.model.Academician
import com.example.penoapp.model.Lecture
import com.example.penoapp.model.Notice
import com.example.penoapp.model.Student
import com.google.gson.JsonObject

import retrofit2.Call
import retrofit2.http.*

interface RestInterface {

    @GET("/api/Notices/GetNotices")
    fun getAllNotice(): Call<List<Notice>>

    @GET("/api/Acas/AcLogin")
    fun acLogin(@Query("no") no: Integer,@Query("pass") pass: String): Call<List<Academician>>


    @GET("/api/Student/StLogin")
    fun stLogin(@Query("no") no: Integer,@Query("pass") pass: String): Call<List<Student>>


    @GET("/api/Lectures/GetLectures")
    fun getAllLecture(): Call<List<Lecture>>

}
