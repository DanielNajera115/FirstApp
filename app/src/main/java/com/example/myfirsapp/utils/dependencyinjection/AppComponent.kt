package com.example.myfirsapp.utils.dependencyinjection


import com.example.myfirsapp.presentation.fragments.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    UseCaseModule::class
])
interface AppComponent {
    fun inject(activity: MainActivity)
}