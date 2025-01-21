package aiapplywiz.repository

import kotlinx.coroutines.flow.Flow
import aiapplywiz.models.db.Bangboo
import aiapplywiz.util.Resource

interface BangbooRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Bangboo>>>

    suspend fun getMovie(id: Int): Flow<Resource<Bangboo>>
}