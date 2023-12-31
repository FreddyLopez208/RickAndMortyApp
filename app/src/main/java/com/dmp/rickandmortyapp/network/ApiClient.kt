package com.dmp.rickandmortyapp.network

import com.dmp.rickandmortyapp.network.response.GetCharacterByIdResponse
import com.dmp.rickandmortyapp.network.response.GetCharactersPageResponse
import com.dmp.rickandmortyapp.network.response.GetEpisodeByIdResponse
import com.dmp.rickandmortyapp.network.response.GetEpisodesPageResponse
import retrofit2.Response

class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {

    // region Characters
    suspend fun getCharacterById(characterId: Int): SimpleResponse<GetCharacterByIdResponse> {
        return safeApiCall { rickAndMortyService.getCharacterById(characterId) }
    }

    suspend fun getCharactersPage(pageIndex: Int): SimpleResponse<GetCharactersPageResponse> {
        return safeApiCall { rickAndMortyService.getCharactersPage(pageIndex) }
    }

    suspend fun getCharactersPage(
        characterName: String,
        pageIndex: Int
    ): SimpleResponse<GetCharactersPageResponse> {
        return safeApiCall { rickAndMortyService.getCharactersPage(characterName, pageIndex) }
    }

    suspend fun getMultipleCharacters(characterList: List<String>): SimpleResponse<List<GetCharacterByIdResponse>> {
        return safeApiCall { rickAndMortyService.getMultipleCharacters(characterList) }
    }
    // endregion Characters

    // region Episodes
    suspend fun getEpisodeById(episodeId: Int): SimpleResponse<GetEpisodeByIdResponse> {
        return safeApiCall { rickAndMortyService.getEpisodeById(episodeId) }
    }

    suspend fun getEpisodeRange(episodeRange: String): SimpleResponse<List<GetEpisodeByIdResponse>> {
        return safeApiCall { rickAndMortyService.getEpisodeRange(episodeRange) }
    }

    suspend fun getEpisodesPage(pageIndex: Int): SimpleResponse<GetEpisodesPageResponse> {
        return safeApiCall { rickAndMortyService.getEpisodesPage(pageIndex) }
    }
    // endregion Episodes

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }
}