package com.example.wondriumcodingchallenge.data.remote.dto

import com.example.wondriumcodingchallenge.domain.model.CourseDetail
import com.google.gson.annotations.SerializedName

data class CourseDetailDto(
    @SerializedName("content_brand")
    val contentBrand: String,
    @SerializedName("content_brand_image")
    val contentBrandImage: String,
    @SerializedName("content_classification")
    val contentClassification: String,
    @SerializedName("content_partner")
    val contentPartner: String,
    @SerializedName("content_partner_image")
    val contentPartnerImage: String,
    @SerializedName("content_restriction")
    val contentRestriction: String,
    @SerializedName("course_description")
    val courseDescription: String,
    @SerializedName("course_guidebook_path")
    val courseGuidebookPath: String,
    @SerializedName("course_has_cc_video")
    val courseHasCcVideo: Boolean,
    @SerializedName("course_has_hd_video")
    val courseHasHdVideo: Boolean,
    @SerializedName("course_id")
    val courseId: Int,
    @SerializedName("course_image_filename")
    val courseImageFilename: String,
    @SerializedName("course_magento_id")
    val courseMagentoId: Int,
    @SerializedName("course_name")
    val courseName: String,
    @SerializedName("course_poster_image")
    val coursePosterImage: String,
    @SerializedName("course_primary_category")
    val coursePrimaryCategory: String,
    @SerializedName("course_professor_has_multiple")
    val courseProfessorHasMultiple: Boolean,
    @SerializedName("course_professor_image_filename")
    val courseProfessorImageFilename: String,
    @SerializedName("course_professor_name")
    val courseProfessorName: String,
    @SerializedName("course_professor_product_id_list")
    val courseProfessorProductIdList: List<CourseProfessorProductId>,
    @SerializedName("course_professor_qualification")
    val courseProfessorQualification: String,
    @SerializedName("course_rating")
    val courseRating: Int,
    @SerializedName("course_soundtrack_filename")
    val courseSoundtrackFilename: String,
    @SerializedName("course_swatch_image")
    val courseSwatchImage: String,
    @SerializedName("course_video_filename")
    val courseVideoFilename: String,
    @SerializedName("instructor_title")
    val instructorTitle: String,
    @SerializedName("lectures")
    val lectures: List<Lecture>,
    @SerializedName("product_magento_id")
    val productMagentoId: Int,
    @SerializedName("product_sku")
    val productSku: String,
    @SerializedName("wondrium_description")
    val wondriumDescription: String
)

fun CourseDetailDto.toCourseDetail(): CourseDetail {
    return CourseDetail(
        id = courseId,
        name = courseName,
        lectures = lectures
    )
}