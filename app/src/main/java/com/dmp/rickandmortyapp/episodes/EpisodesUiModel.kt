package com.dmp.rickandmortyapp.episodes

import com.dmp.rickandmortyapp.domain.models.Episode

sealed class EpisodesUiModel {
    class Item(val episode: Episode): EpisodesUiModel()
    class Header(val text: String): EpisodesUiModel()
}