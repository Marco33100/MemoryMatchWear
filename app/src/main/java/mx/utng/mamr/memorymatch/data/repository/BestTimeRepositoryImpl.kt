package mx.utng.mamr.memorymatch.data.repository

import mx.utng.mamr.memorymatch.data.datasource.BestTimeDataSource

interface BestTimeRepository {
    suspend fun getBestTime(): Long
    suspend fun saveBestTime(seconds: Long)
}

// data/repository/BestTimeRepositoryImpl.kt
class BestTimeRepositoryImpl(private val ds: BestTimeDataSource) : BestTimeRepository {
    override suspend fun getBestTime() = ds.getBestTime()
    override suspend fun saveBestTime(s: Long) = ds.saveBestTime(s)
}
