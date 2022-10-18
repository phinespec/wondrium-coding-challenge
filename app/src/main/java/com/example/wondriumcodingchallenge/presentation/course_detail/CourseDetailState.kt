package com.example.wondriumcodingchallenge.presentation.course_detail

import com.example.wondriumcodingchallenge.domain.model.CourseDetail

data class CourseDetailState(
    val isLoading: Boolean = false,
    val course: CourseDetail? = null,
    val error: String = ""
)
