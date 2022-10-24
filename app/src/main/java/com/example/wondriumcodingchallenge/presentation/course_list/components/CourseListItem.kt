package com.example.wondriumcodingchallenge.presentation.course_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.wondriumcodingchallenge.common.Preview.CourseListItemPreviewParameterProvider
import com.example.wondriumcodingchallenge.domain.model.Course
import com.example.wondriumcodingchallenge.ui.theme.WondriumCodingChallengeTheme


@Composable
fun CourseListItem(
    modifier: Modifier = Modifier,
    isPreview: Boolean = false,
    course: Course,
    onItemClick: (Course) -> Unit
) {

    val padding = 10.dp
    val backgroundColor = MaterialTheme.colors.primary

    Row(
        modifier
            .clickable { onItemClick(course) }
            .padding(padding)
            .background(if (isPreview) Color.Red else backgroundColor)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = course.name,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .background(if (isPreview) Color.Gray else backgroundColor)
                .width(300.dp)
                .padding(padding)
        )
        Image(
            painter = rememberAsyncImagePainter(
                "https://secureimages.teach12.com/tgc/images/" +
                        "m2/wondrium/courses/${course.id}/portrait/${course.id}.jpg",
                placeholder = painterResource(com.example.wondriumcodingchallenge.R.drawable.ic_baseline_account_circle_24)
            ),
            contentDescription = null,
            modifier = modifier
                .size(80.dp)
                .background(if (isPreview) Color.Blue else backgroundColor)
                .clip(RoundedCornerShape(20))
        )

    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF00FF00)
fun PreviewComposable(
    @PreviewParameter(CourseListItemPreviewParameterProvider::class) course: Course
) {
    WondriumCodingChallengeTheme {
        CourseListItem(isPreview = true, course = course, onItemClick = {})
    }
}