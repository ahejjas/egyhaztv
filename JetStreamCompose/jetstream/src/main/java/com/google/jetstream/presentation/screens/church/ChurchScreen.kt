package com.google.jetstream.presentation.screens.church

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.material3.Card
import androidx.tv.material3.Text
import com.google.jetstream.data.entities.ChurchCategory

@Composable
fun ChurchScreen(
    category: ChurchCategory,
    viewModel: ChurchViewModel = hiltViewModel()
) {
    val videos by viewModel.videos.collectAsStateWithLifecycle()

    LaunchedEffect(category) {
        viewModel.loadVideos(category)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(videos) { video ->
            Card(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Text(text = video.title)
                    Text(
                        text = video.channelName,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}