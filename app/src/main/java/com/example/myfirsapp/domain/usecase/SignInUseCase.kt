package com.example.myfirsapp.domain.usecase

import io.reactivex.Completable

interface SignInUseCase {
    operator fun invoke(user: String, password: String): Completable
}