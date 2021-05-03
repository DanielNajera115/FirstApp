package com.example.myfirsapp.domain.repositories

import io.reactivex.Completable

interface SignInRepository {
    fun signIn(userName: String, password: String ): Completable
}