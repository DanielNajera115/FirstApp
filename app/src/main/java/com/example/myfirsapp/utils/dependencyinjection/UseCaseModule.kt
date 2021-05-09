package com.example.myfirsapp.utils.dependencyinjection

import com.example.myfirsapp.domain.usecase.SignInUseCase
import com.example.myfirsapp.domain.usecase.SignInUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindSignInUseCase(useCase: SignInUseCaseImpl): SignInUseCase
}