package com.example.myfirsapp.domain.usecase

import com.example.myfirsapp.domain.repositories.SignInRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.Completable
import javax.inject.Inject

class SignInUseCaseImpl @Inject constructor(
    private val signInRepository : SignInRepository
) : SignInUseCase {

    override fun invoke(user: String, password: String): Completable =
        signInRepository.signIn(user,password)

}