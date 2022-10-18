package com.example.wondriumcodingchallenge.presentation.course_list.components

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wondriumcodingchallenge.presentation.Screen
import com.example.wondriumcodingchallenge.presentation.course_list.CourseListViewModel

@Composable
fun CourseListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CourseListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier.fillMaxSize()) {
        LazyColumn(modifier.fillMaxSize()) {
            items(state.courses) { course ->
                CourseListItem(
                    course = course,
                    onItemClick = { navController.navigate(Screen.CourseDetailScreen.route) }
                )
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