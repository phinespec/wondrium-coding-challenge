package com.example.wondriumcodingchallenge.di

import android.app.Application
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.wondriumcodingchallenge.common.Constants
import com.example.wondriumcodingchallenge.data.remote.CourseApi
import com.example.wondriumcodingchallenge.data.remote.repository.CourseRepositoryImpl
import com.example.wondriumcodingchallenge.domain.repository.CourseRepository
import com.example.wondriumcodingchallenge.domain.video_player.MetadataReader
import com.example.wondriumcodingchallenge.domain.video_player.MetadataReaderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesCourseApi(): CourseApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CourseApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCourseRepository(api: CourseApi): CourseRepository {
        return CourseRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideVideoPlayer(app: Application): Player {
        return ExoPlayer.Builder(app)
            .build()
    }

    @Provides
    @Singleton
    fun provideMetadataReader(app: Application): MetadataReader {
        return MetadataReaderImpl(app)
    }
}