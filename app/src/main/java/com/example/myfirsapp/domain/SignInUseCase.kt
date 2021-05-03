package com.example.myfirsapp.domain

import io.reactivex.Completable

interface SignInUseCase {
    operator fun invoke(user: String, password: String): Completable
}