package com.example.wondriumcodingchallenge.domain.use_case

import com.example.wondriumcodingchallenge.data.remote.CourseApi
import com.example.wondriumcodingchallenge.data.remote.dto.CourseDetailDto
import com.example.wondriumcodingchallenge.data.remote.dto.CourseProfessorProductId
import com.example.wondriumcodingchallenge.data.remote.dto.Lecture
import com.example.wondriumcodingchallenge.data.remote.dto.ProductDto
import com.example.wondriumcodingchallenge.domain.repository.CourseRepository
import javax.inject.Inject

class FakeCourseRepository : CourseRepository {

    private val courses = mutableListOf<ProductDto>()

    override suspend fun getCourses(): List<ProductDto> {
        return courses
    }

    override suspend fun getCourseDetail(): CourseDetailDto {
        return CourseDetailDto()
    }
}