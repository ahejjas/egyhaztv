package com.google.jetstream.data.repositories

import com.google.jetstream.data.entities.ChurchCategory
import com.google.jetstream.data.entities.ChurchVideo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChurchRepository @Inject constructor(
    private val churchDataSource: ChurchDataSource
) {
    fun getVideos(category: ChurchCategory): Flow<List<ChurchVideo>> = flow {
        emit(churchDataSource.getVideos(category))
    }
}