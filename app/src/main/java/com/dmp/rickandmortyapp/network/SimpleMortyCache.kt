package com.dmp.rickandmortyapp.network

import com.dmp.rickandmortyapp.domain.models.Character

object SimpleMortyCache {

    val characterMap = mutableMapOf<Int, Character>()
}