package com.example.wondriumcodingchallenge.domain.use_case.get_courses

import com.example.wondriumcodingchallenge.domain.model.Course
import com.example.wondriumcodingchallenge.domain.use_case.FakeCourseRepository
import org.junit.Before
import org.junit.Test

class GetCoursesUseCaseTest {

    private lateinit var getCourses: GetCoursesUseCase
    private lateinit var fakeRepository: FakeCourseRepository

    @Before
    fun setup() {
        fakeRepository = FakeCourseRepository()
        getCourses = GetCoursesUseCase(fakeRepository)

        val coursesToInsert = mutableListOf<Course>()
        ('a'..'z').forEachIndexed { index, char ->
            coursesToInsert.add(
                Course(
                    index,
                    char.toString(),
                    char.toString()
                )
            )
        }

    }
}