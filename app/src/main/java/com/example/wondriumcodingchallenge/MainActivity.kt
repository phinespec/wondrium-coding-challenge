package com.example.wondriumcodingchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wondriumcodingchallenge.presentation.Screen
import com.example.wondriumcodingchallenge.presentation.course_detail.components.CourseDetailScreen
import com.example.wondriumcodingchallenge.presentation.course_list.components.CourseListScreen
import com.example.wondriumcodingchallenge.ui.theme.WondriumCodingChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WondriumCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CourseListScreen.route
                    ) {
                        composable(
                            route = Screen.CourseListScreen.route
                        ) {
                            CourseListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CourseDetailScreen.route
                        ) {
                            CourseDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}