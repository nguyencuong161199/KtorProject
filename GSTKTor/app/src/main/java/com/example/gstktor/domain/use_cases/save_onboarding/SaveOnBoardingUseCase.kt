package com.example.gstktor.domain.use_cases.save_onboarding // ktlint-disable package-name

import com.example.gstktor.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}
