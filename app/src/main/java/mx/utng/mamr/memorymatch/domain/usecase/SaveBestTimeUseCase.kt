package mx.utng.mamr.memorymatch.domain.usecase

import mx.utng.mamr.memorymatch.domain.repository.BestTimeRepository

class SaveBestTimeUseCase(private val repository: BestTimeRepository) {
    suspend operator fun invoke(seconds: Long) = repository.saveBestTime(seconds)
}