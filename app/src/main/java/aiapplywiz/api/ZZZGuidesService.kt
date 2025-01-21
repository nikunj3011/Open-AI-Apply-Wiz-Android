package aiapplywiz.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import aiapplywiz.models.api.character.AgentResponse
import aiapplywiz.models.api.characterdetail.CharacterDetailResponse
import aiapplywiz.models.api.bangboo.BangBoosResponse
import aiapplywiz.models.api.bangbooNew.BangbooNewResponse
import aiapplywiz.models.api.wengines.WEngineResponse
import aiapplywiz.models.api.wenginesNew.WEngineNewResponse

interface ZZZGuidesService {

    @GET("bangboos.json")
    suspend fun getBangboos(
    ): Response<BangBoosResponse>


    @GET("bangboosNew.json")
    suspend fun getBangboosNew(
    ): Response<BangbooNewResponse>

    @GET("charactersdetail/charactersDetails.json")
    suspend fun getCharacters(
    ): Response<AgentResponse>

    @GET("wengines.json")
    suspend fun getWEngines(
    ): Response<WEngineResponse>

    @GET("wenginesNew.json")
    suspend fun getWEnginesNew(
    ): Response<WEngineNewResponse>

    @GET("charactersdetail/{id}.json")
    suspend fun getCharactersDetail(
        @Path(value = "id") id: String,
        @Query("articlesCount") count: Int = 0
    ): Response<CharacterDetailResponse>


    @GET("charactersdetail/charactersDetails.json")
    suspend fun getCharactersDetails(
    ): Response<List<CharacterDetailResponse>>
}