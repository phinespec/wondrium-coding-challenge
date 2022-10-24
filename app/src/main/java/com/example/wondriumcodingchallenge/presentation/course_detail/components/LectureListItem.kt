package com.example.wondriumcodingchallenge.presentation.course_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.wondriumcodingchallenge.data.remote.dto.Lecture


@Composable
fun LectureListItem(
    modifier: Modifier = Modifier,
    lecture: Lecture,
    onItemClick: (Lecture) -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .clickable { onItemClick(lecture) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = lecture.lectureName,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}