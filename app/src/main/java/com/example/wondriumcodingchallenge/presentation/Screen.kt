package com.example.wondriumcodingchallenge.presentation

sealed class Screen(val route: String) {
    object CourseListScreen: Screen("course_list_screen")
    object CourseDetailScreen: Screen("course_detail_screen")
    object VideoPlayerScreen: Screen("video_player_screen")
}
