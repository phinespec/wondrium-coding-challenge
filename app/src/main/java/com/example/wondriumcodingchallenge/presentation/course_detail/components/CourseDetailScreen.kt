package com.example.wondriumcodingchallenge.presentation.course_detail.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wondriumcodingchallenge.presentation.Screen
import com.example.wondriumcodingchallenge.presentation.course_detail.CourseDetailViewModel


@Composable
fun CourseDetailScreen(
    modifier: Modifier = Modifier.background(MaterialTheme.colors.primary),
    navController: NavController,
    viewModel: CourseDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .padding(10.dp)
        ) {
            Text(
                text = state.course?.name ?: "Name Placeholder",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
            LazyColumn(modifier.fillMaxSize()) {
                state.course?.let {
                    items(it.lectures) { lecture ->
                        LectureListItem(
                            lecture = lecture,
                            onItemClick = { navController.navigate(Screen.VideoPlayerScreen.route) }
                        )
                        Divider()
                    }
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

internal enum class VideoOption(val url: String) {
    FIRST("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
    SECOND("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4")
}