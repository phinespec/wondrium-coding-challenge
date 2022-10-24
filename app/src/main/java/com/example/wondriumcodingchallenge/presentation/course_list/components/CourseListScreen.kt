package com.example.wondriumcodingchallenge.presentation.course_list.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wondriumcodingchallenge.presentation.Screen
import com.example.wondriumcodingchallenge.presentation.course_list.CourseListViewModel
import com.example.wondriumcodingchallenge.ui.theme.WondriumCodingChallengeTheme

@Composable
fun CourseListScreen(
    modifier: Modifier = Modifier.background(MaterialTheme.colors.primary),
    navController: NavController,
    viewModel: CourseListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(
        modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Title("Available Courses")
            Spacer(modifier = modifier.height(20.dp))
            LazyColumn(modifier.fillMaxWidth()) {
                items(state.courses) { course ->
                    CourseListItem(
                        course = course,
                        onItemClick = { navController.navigate(Screen.CourseDetailScreen.route) }
                    )
                    Divider()
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

@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.ExtraBold,
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.h4,
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    )
}


@Preview(showBackground = true, backgroundColor = 0xFFD9FFF5, widthDp = 320)
@Composable
fun PreviewComposable() {
    WondriumCodingChallengeTheme {
        Title("Courses")
    }
}