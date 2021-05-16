package com.example.myfirsapp.utils.dependencyinjection

import com.example.myfirsapp.domain.repositories.SignInRepository
import com.example.myfirsapp.domain.usecase.SignInUseCase
import com.example.myfirsapp.domain.usecase.SignInUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideSignInUseCase(signInUseCaseImpl: SignInUseCaseImpl): SignInUseCase = signInUseCaseImpl

}