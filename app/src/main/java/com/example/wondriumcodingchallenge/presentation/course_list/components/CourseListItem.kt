package com.example.wondriumcodingchallenge.presentation.course_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.wondriumcodingchallenge.domain.model.Course


@Composable
fun CourseListItem(
    modifier: Modifier = Modifier,
    course: Course,
    onItemClick: (Course) -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .clickable { onItemClick(course) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = course.name,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Image(
            painter =
            rememberAsyncImagePainter("https://secureimages.teach12.com/tgc/images/m2/wondrium/courses/" +
                    "${course.id}/portrait/${course.id}.jpg"),
            contentDescription = null,
            modifier = modifier.size(60.dp),
        )
    }
}