package com.example.wondriumcodingchallenge.domain.use_case.get_course_detail

import com.example.wondriumcodingchallenge.common.Resource
import com.example.wondriumcodingchallenge.data.remote.dto.toCourseDetail
import com.example.wondriumcodingchallenge.domain.model.CourseDetail
import com.example.wondriumcodingchallenge.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCourseDetailUseCase @Inject constructor(
    private val repository: CourseRepository
) {

    operator fun invoke(): Flow<Resource<CourseDetail>> = flow {
        try {
            emit(Resource.Loading<CourseDetail>())
            val coin = repository.getCourseDetail().toCourseDetail()
            emit(Resource.Success<CourseDetail>(coin))
        } catch(e: HttpException) {
            emit(Resource.Failure<CourseDetail>(e.localizedMessage ?: "Unexpected response code!"))
        } catch(e: IOException) {
            emit(Resource.Failure<CourseDetail>("Network error. Check your connection!"))
        }
    }

}