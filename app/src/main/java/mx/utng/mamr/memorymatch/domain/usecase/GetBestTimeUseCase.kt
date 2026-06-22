package mx.utng.mamr.memorymatch.domain.usecase

import mx.utng.mamr.memorymatch.domain.repository.BestTimeRepository

class GetBestTimeUseCase(private val repository: BestTimeRepository) {
    suspend operator fun invoke(): Long = repository.getBestTime()
}