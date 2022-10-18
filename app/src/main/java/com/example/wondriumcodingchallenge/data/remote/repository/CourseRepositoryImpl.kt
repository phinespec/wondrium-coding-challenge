package com.example.wondriumcodingchallenge.data.remote.repository

import com.example.wondriumcodingchallenge.data.remote.CourseApi
import com.example.wondriumcodingchallenge.data.remote.dto.CourseDetailDto
import com.example.wondriumcodingchallenge.data.remote.dto.ProductDto
import com.example.wondriumcodingchallenge.domain.repository.CourseRepository
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val api: CourseApi
) : CourseRepository {
    override suspend fun getCourses(): List<ProductDto> = api.getCourses().products

    override suspend fun getCourseDetail(): CourseDetailDto = api.getCourseDetail()
}