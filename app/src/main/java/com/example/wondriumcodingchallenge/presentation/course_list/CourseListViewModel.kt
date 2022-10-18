package com.example.wondriumcodingchallenge.presentation.course_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wondriumcodingchallenge.common.Resource
import com.example.wondriumcodingchallenge.domain.use_case.get_courses.GetCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CourseListViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase
): ViewModel() {

    private val _state = mutableStateOf(CourseListState())
    val state: State<CourseListState> = _state

    init {
        getCourses()
    }

    private fun getCourses() {
        getCoursesUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CourseListState(courses = result.data ?: emptyList())
                }
                is Resource.Failure -> {
                    _state.value = CourseListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CourseListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}