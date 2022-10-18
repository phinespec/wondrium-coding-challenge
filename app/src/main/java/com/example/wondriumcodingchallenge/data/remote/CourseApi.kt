package com.example.wondriumcodingchallenge.data.remote

import com.example.wondriumcodingchallenge.data.remote.dto.CourseDetailDto
import com.example.wondriumcodingchallenge.data.remote.dto.ResponseDto
import retrofit2.http.GET

interface CourseApi {

    @GET("/homeitems/")
    suspend fun getCourses(): ResponseDto

    @GET("/details/")
    suspend fun getCourseDetail(): CourseDetailDto
}