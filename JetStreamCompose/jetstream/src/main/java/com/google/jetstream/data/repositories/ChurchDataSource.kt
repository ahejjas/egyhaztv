package com.google.jetstream.data.repositories

import com.google.jetstream.data.entities.ChurchCategory
import com.google.jetstream.data.entities.ChurchVideo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChurchDataSource @Inject constructor() {

    fun getVideos(category: ChurchCategory): List<ChurchVideo> {
        return when (category) {
            ChurchCategory.REFORMATUS -> listOf(
                ChurchVideo(
                    id = "ref_1",
                    title = "Református istentisztelet",
                    description = "Református istentisztelet",
                    thumbnailUrl = "",
                    channelName = "Református",
                    youtubeVideoId = ""
                )
            )

            ChurchCategory.KATOLIKUS -> listOf(
                ChurchVideo(
                    id = "kat_1",
                    title = "Katolikus szentmise",
                    description = "Katolikus szentmise",
                    thumbnailUrl = "",
                    channelName = "Katolikus",
                    youtubeVideoId = ""
                )
            )

            ChurchCategory.EVANGELIKUS -> listOf(
                ChurchVideo(
                    id = "eva_1",
                    title = "Evangélikus istentisztelet",
                    description = "Evangélikus istentisztelet",
                    thumbnailUrl = "",
                    channelName = "Evangélikus",
                    youtubeVideoId = ""
                )
            )
        }
    }
}