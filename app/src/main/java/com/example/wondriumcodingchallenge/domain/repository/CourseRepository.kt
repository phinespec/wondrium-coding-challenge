package com.example.wondriumcodingchallenge.domain.repository

import com.example.wondriumcodingchallenge.data.remote.dto.CourseDetailDto
import com.example.wondriumcodingchallenge.data.remote.dto.ProductDto


interface CourseRepository {

    suspend fun getCourses(): List<ProductDto>

    suspend fun getCourseDetail(): CourseDetailDto
}