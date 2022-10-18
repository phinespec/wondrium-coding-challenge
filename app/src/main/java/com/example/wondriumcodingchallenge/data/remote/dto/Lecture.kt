package com.example.wondriumcodingchallenge.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Lecture(
    @SerializedName("content_brand")
    val contentBrand: String,
    @SerializedName("content_classification")
    val contentClassification: String,
    @SerializedName("lecture_allow_free_streaming")
    val lectureAllowFreeStreaming: String,
    @SerializedName("lecture_bif_filename")
    val lectureBifFilename: String,
    @SerializedName("lecture_description")
    val lectureDescription: String,
    @SerializedName("lecture_image_filename")
    val lectureImageFilename: String,
    @SerializedName("lecture_magento_id")
    val lectureMagentoId: Int,
    @SerializedName("lecture_name")
    val lectureName: String,
    @SerializedName("lecture_number")
    val lectureNumber: Int,
    @SerializedName("lecture_sku")
    val lectureSku: String,
    @SerializedName("lecture_soundtrack_filename")
    val lectureSoundtrackFilename: String,
    @SerializedName("lecture_video_filename")
    val lectureVideoFilename: String,
    @SerializedName("time_in_minutes")
    val timeInMinutes: String,
    @SerializedName("time_in_seconds")
    val timeInSeconds: String
)