package com.example.wondriumcodingchallenge.presentation.course_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wondriumcodingchallenge.presentation.course_detail.CourseDetailViewModel


@Composable
fun CourseDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CourseDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier.fillMaxSize()) {
        Text(
            text = state.course?.name ?: "Name Placeholder",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
            color = Color.Cyan
        )
        LazyColumn(modifier.fillMaxSize()) {
            state.course?.let {
                items(it.lectures) { coin ->

                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier.align(Alignment.Center))
        }
    }

}