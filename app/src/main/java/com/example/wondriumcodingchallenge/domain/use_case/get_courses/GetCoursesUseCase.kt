package com.example.wondriumcodingchallenge.domain.use_case.get_courses

import com.example.wondriumcodingchallenge.common.Resource
import com.example.wondriumcodingchallenge.data.remote.dto.toCourse
import com.example.wondriumcodingchallenge.domain.model.Course
import com.example.wondriumcodingchallenge.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoursesUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke(): Flow<Resource<List<Course>>> = flow {
        try {
            emit(Resource.Loading<List<Course>>())
            val courses = repository.getCourses().map { it.toCourse() }
            emit(Resource.Success<List<Course>>(courses))
        } catch(e: HttpException) {
            emit(Resource.Failure<List<Course>>(e.localizedMessage ?: "There was an error with the response type!"))
        } catch(e: IOException) {
            emit(Resource.Failure<List<Course>>(e.localizedMessage ?: "Network error. Check internet connection!"))
        }
    }
}