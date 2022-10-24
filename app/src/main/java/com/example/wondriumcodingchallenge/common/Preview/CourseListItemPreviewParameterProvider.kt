package com.example.wondriumcodingchallenge.common.Preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.wondriumcodingchallenge.domain.model.Course

class CourseListItemPreviewParameterProvider : PreviewParameterProvider<Course> {
    override val values: Sequence<Course>
        get() = sequenceOf(
            Course(
                10300,
                "Solving for Zero: The Search for Climate Innovation",
                "10300.jpg"
            ),
            Course(
                9411,
                "How to Play Chess: Lessons from an International Master",
                "9411.jpg"
            ),
            Course(
                8220,
                "Living the French Revolution and the Age of Napoleon",
                "8220.jpg"
            )
        )
}