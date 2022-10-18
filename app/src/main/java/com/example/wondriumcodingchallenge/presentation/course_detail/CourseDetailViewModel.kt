package com.example.wondriumcodingchallenge.presentation.course_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wondriumcodingchallenge.common.Resource
import com.example.wondriumcodingchallenge.domain.repository.CourseRepository
import com.example.wondriumcodingchallenge.domain.use_case.get_course_detail.GetCourseDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    private val getCourseDetailUseCase: GetCourseDetailUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CourseDetailState())
    val state: State<CourseDetailState> = _state

    init {
        getCourseDetail()
    }

    private fun getCourseDetail() {
        getCourseDetailUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CourseDetailState(course = result.data)
                }
                is Resource.Failure -> {
                    _state.value = CourseDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CourseDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}