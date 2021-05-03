package com.example.myfirsapp.data

import com.example.myfirsapp.domain.repositories.SignInRepository
import io.reactivex.Completable

class SignInRepositoryImpl: SignInRepository {
    val firebase = FireBaseRepository()

    override fun signIn(userName: String, password: String): Completable =
        firebase.signInFireBase(userName, password)

}