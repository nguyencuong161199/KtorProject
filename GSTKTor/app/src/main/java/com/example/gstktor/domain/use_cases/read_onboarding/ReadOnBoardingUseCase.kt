package com.example.gstktor.domain.use_cases.read_onboarding

import com.example.gstktor.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> =
        repository.readOnBoardingState()
}