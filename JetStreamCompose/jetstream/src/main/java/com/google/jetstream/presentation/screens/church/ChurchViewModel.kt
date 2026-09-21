package com.google.jetstream.presentation.screens.church

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.jetstream.data.entities.ChurchCategory
import com.google.jetstream.data.entities.ChurchVideo
import com.google.jetstream.data.repositories.ChurchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ChurchViewModel @Inject constructor(
    private val churchRepository: ChurchRepository
) : ViewModel() {

    private val _videos = MutableStateFlow<List<ChurchVideo>>(emptyList())
    val videos: StateFlow<List<ChurchVideo>> = _videos.asStateFlow()

    fun loadVideos(category: ChurchCategory) {
        viewModelScope.launch {
            churchRepository.getVideos(category).collect { videos ->
                _videos.value = videos
            }
        }
    }
}