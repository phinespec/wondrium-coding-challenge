package com.example.wondriumcodingchallenge.presentation.course_list

import com.example.wondriumcodingchallenge.domain.model.Course

data class CourseListState(
    val isLoading: Boolean = false,
    val courses: List<Course> = emptyList(),
    val error: String = ""
)
