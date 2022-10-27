package com.example.wondriumcodingchallenge.data.remote.dto

import com.example.wondriumcodingchallenge.domain.model.CourseDetail
import com.google.gson.annotations.SerializedName

data class CourseDetailDto(
    @SerializedName("content_brand")
    val contentBrand: String? = null,
    @SerializedName("content_brand_image")
    val contentBrandImage: String? = null,
    @SerializedName("content_classification")
    val contentClassification: String? = null,
    @SerializedName("content_partner")
    val contentPartner: String? = null,
    @SerializedName("content_partner_image")
    val contentPartnerImage: String? = null,
    @SerializedName("content_restriction")
    val contentRestriction: String? = null,
    @SerializedName("course_description")
    val courseDescription: String? = null,
    @SerializedName("course_guidebook_path")
    val courseGuidebookPath: String? = null,
    @SerializedName("course_has_cc_video")
    val courseHasCcVideo: Boolean? = null,
    @SerializedName("course_has_hd_video")
    val courseHasHdVideo: Boolean? = null,
    @SerializedName("course_id")
    val courseId: Int? = null,
    @SerializedName("course_image_filename")
    val courseImageFilename: String? = null,
    @SerializedName("course_magento_id")
    val courseMagentoId: Int? = null,
    @SerializedName("course_name")
    val courseName: String? = null,
    @SerializedName("course_poster_image")
    val coursePosterImage: String? = null,
    @SerializedName("course_primary_category")
    val coursePrimaryCategory: String? = null,
    @SerializedName("course_professor_has_multiple")
    val courseProfessorHasMultiple: Boolean? = null,
    @SerializedName("course_professor_image_filename")
    val courseProfessorImageFilename: String? = null,
    @SerializedName("course_professor_name")
    val courseProfessorName: String? = null,
    @SerializedName("course_professor_product_id_list")
    val courseProfessorProductIdList: List<CourseProfessorProductId>? = null,
    @SerializedName("course_professor_qualification")
    val courseProfessorQualification: String? = null,
    @SerializedName("course_rating")
    val courseRating: Int? = null,
    @SerializedName("course_soundtrack_filename")
    val courseSoundtrackFilename: String? = null,
    @SerializedName("course_swatch_image")
    val courseSwatchImage: String? = null,
    @SerializedName("course_video_filename")
    val courseVideoFilename: String? = null,
    @SerializedName("instructor_title")
    val instructorTitle: String? = null,
    @SerializedName("lectures")
    val lectures: List<Lecture>? = null,
    @SerializedName("product_magento_id")
    val productMagentoId: Int? = null,
    @SerializedName("product_sku")
    val productSku: String? = null,
    @SerializedName("wondrium_description")
    val wondriumDescription: String? = null
)

fun CourseDetailDto.toCourseDetail(): CourseDetail {
    return CourseDetail(
        id = courseId!!,
        name = courseName!!,
        lectures = lectures!!
    )
}