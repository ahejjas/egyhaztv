package com.google.jetstream.data.entities

data class ChurchVideo(
    val id: String,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val channelName: String,
    val youtubeVideoId: String
)