package com.example.myfirsapp.domain

import com.example.myfirsapp.data.SignInRepositoryImpl
import io.reactivex.Completable

class SignInUseCaseImpl: SignInUseCase {

    private val signInRepository =  SignInRepositoryImpl()

    override fun invoke(user: String, password: String): Completable =
        signInRepository.signIn(user,password)


}