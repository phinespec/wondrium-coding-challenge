package com.example.wondriumcodingchallenge.data.remote.dto

import com.example.wondriumcodingchallenge.domain.model.Course
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("content_blacklist")
    val contentBlacklist: String,
    @SerializedName("content_brand")
    val contentBrand: String,
    @SerializedName("content_classification")
    val contentClassification: String,
    @SerializedName("content_partner")
    val contentPartner: String,
    @SerializedName("content_restriction")
    val contentRestriction: String,
    @SerializedName("course_has_cc_video")
    val courseHasCcVideo: Boolean,
    @SerializedName("course_has_hd_video")
    val courseHasHdVideo: Boolean,
    @SerializedName("course_id")
    val courseId: Int,
    @SerializedName("course_image_name")
    val courseImageName: String,
    @SerializedName("course_name")
    val courseName: String,
    @SerializedName("course_poster_image")
    val coursePosterImage: String,
    @SerializedName("course_swatch_image")
    val courseSwatchImage: String,
    @SerializedName("course_url_key")
    val courseUrlKey: String,
    @SerializedName("lecture_number")
    val lectureNumber: Int,
    @SerializedName("lecture_poster_image")
    val lecturePosterImage: String,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("product_image_name")
    val productImageName: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("product_short_description")
    val productShortDescription: String,
    @SerializedName("product_sku")
    val productSku: String,
    @SerializedName("product_sort_order")
    val productSortOrder: Int,
    @SerializedName("product_type")
    val productType: String
)

fun ProductDto.toCourse(): Course {
    return Course(
        id = courseId,
        name = courseName,
        imageName = courseImageName
    )
}